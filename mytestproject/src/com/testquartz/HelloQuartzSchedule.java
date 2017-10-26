package com.testquartz;

import org.quartz.*;

import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.text.ParseException;
import java.util.*;
import java.util.Calendar;

/**
 * Created by dell on 2017/8/14.
 */
public class HelloQuartzSchedule {
    public static void main(String[] args) throws SchedulerException, ParseException {
        //获得一个Schedule
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        scheduler = schedulerFactory.getScheduler();
        //新建一个JobDetail 并设置参数
        JobDetail jobDetail = new JobDetailImpl("helloQuartz", Scheduler.DEFAULT_GROUP, HelloQuartz.class);

   /*     //  设置SimpleTrigger（Trigger一）
        SimpleTriggerImpl simpleTriggerImpl = new SimpleTriggerImpl("simpleTrigger",
                Scheduler.DEFAULT_GROUP);
        simpleTriggerImpl.setStartTime(new Date(System.currentTimeMillis()));
        simpleTriggerImpl.setRepeatInterval(5000);
        simpleTriggerImpl.setRepeatCount(10);*/


     /*   //设置假期做排除
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.OCTOBER, 1);
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        holidayCalendar.addExcludedDate(calendar.getTime());
        scheduler.addCalendar("calendar", holidayCalendar, true, false);
*/

        // 设置CronTrigger  利用Cron表达式（Trigger二）
        String cronExpression = "30/5 * * * * ?"; // 每分钟的30s起，每5s触发任务
        CronTrigger cronTrigger = new CronTriggerImpl("cronTrigger",
                Scheduler.DEFAULT_GROUP, cronExpression);

        //设置Schedule
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();


    }

}
