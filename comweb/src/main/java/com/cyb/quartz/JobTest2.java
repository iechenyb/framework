package com.cyb.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobTest2 implements Job
{

    public void execute(JobExecutionContext jobexecutioncontext)
            throws JobExecutionException
    {
        System.out.println("JobTest2");
    }

}
