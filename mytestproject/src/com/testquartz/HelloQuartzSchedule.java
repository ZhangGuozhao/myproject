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
        //���һ��Schedule
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        scheduler = schedulerFactory.getScheduler();
        //�½�һ��JobDetail �����ò���
        JobDetail jobDetail = new JobDetailImpl("helloQuartz", Scheduler.DEFAULT_GROUP, HelloQuartz.class);

   /*     //  ����SimpleTrigger��Triggerһ��
        SimpleTriggerImpl simpleTriggerImpl = new SimpleTriggerImpl("simpleTrigger",
                Scheduler.DEFAULT_GROUP);
        simpleTriggerImpl.setStartTime(new Date(System.currentTimeMillis()));
        simpleTriggerImpl.setRepeatInterval(5000);
        simpleTriggerImpl.setRepeatCount(10);*/


     /*   //���ü������ų�
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.OCTOBER, 1);
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        holidayCalendar.addExcludedDate(calendar.getTime());
        scheduler.addCalendar("calendar", holidayCalendar, true, false);
*/

        // ����CronTrigger  ����Cron���ʽ��Trigger����
        String cronExpression = "30/5 * * * * ?"; // ÿ���ӵ�30s��ÿ5s��������
        CronTrigger cronTrigger = new CronTriggerImpl("cronTrigger",
                Scheduler.DEFAULT_GROUP, cronExpression);

        //����Schedule
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();


    }

}
