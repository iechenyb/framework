package com.cyb.mem;

public class MeasurerMain {

    public static String measure(Object value) {
        StringBuilder sb = new StringBuilder();
        sb.append("type :  ").append(value.getClass().getName()).append("\n");
        sb.append("size :  " + MemoryMeasurer.measureBytes(value)).append("\n");
        sb.append("graph:  " + ObjectGraphMeasurer.measure(value)).append("\n");
        return sb.toString();
    }
   public static void main(String[] args) {
	  // measure(new MeasurerMain());
}
}
