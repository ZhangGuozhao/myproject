package com.testquartz;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by dell on 2017/8/14.
 */
public class HelloQuartz implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello,Quartz! - executing its JOB at" + new Date() + " by "
        + jobExecutionContext.getTrigger().getDescription());

//        String  str = new String();
//        str.getClass().getName()

    }
}
