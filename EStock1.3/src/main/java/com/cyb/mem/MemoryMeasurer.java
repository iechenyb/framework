package com.cyb.mem;

import java.lang.instrument.Instrumentation;

public class MemoryMeasurer {
    private static final Instrumentation instrumentation =
        InstrumentationGrabber.instrumentation();


    private static final long costOfBareEnumConstant =
        instrumentation.getObjectSize(DummyEnum.CONSTANT);

    private enum DummyEnum {
        CONSTANT;
    }


    @SuppressWarnings("all")
    public static long measureBytes(Object rootObject) {
        ObjectFilters.AtMostOncePredicate aa = new ObjectFilters.AtMostOncePredicate();
        ObjectFilter<Chain> chains = ObjectFilters.compose(aa, ObjectFilters.notEnumFieldsOrClasses); 
        long result = ObjectExplorer.exploreObject(rootObject, new MemoryMeasurerVisitor(chains));
        return result;
    }

    private static class MemoryMeasurerVisitor implements ObjectVisitor<Long> {
        private long memory;
        private final ObjectFilter<Chain> filter;

        MemoryMeasurerVisitor(ObjectFilter<Chain> filter) {
            this.filter = filter;
        }

        public Traversal visit(Chain chain) {

            if (filter.apply(chain)) {
                Object o = chain.getValue();
                memory += instrumentation.getObjectSize(o);
                if (Enum.class.isAssignableFrom(o.getClass())) {
                    memory -= costOfBareEnumConstant;
                }
                return Traversal.EXPLORE;
            }
            return Traversal.SKIP;
        }

        public Long result() {
            return memory;
        }
    }
}
