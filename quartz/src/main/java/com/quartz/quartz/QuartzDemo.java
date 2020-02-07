package com.quartz.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author 徐老板
 * @date 2020/2/4   13:37
 */
public class QuartzDemo implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("这个能成功吗"+new Date());
    }
}
