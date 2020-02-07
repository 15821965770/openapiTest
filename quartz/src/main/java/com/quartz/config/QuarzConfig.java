package com.quartz.config;

import com.quartz.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author 徐老板
 * @date 2020/2/4   13:38
 */
@Configuration
public class QuarzConfig {
    /**
     * 创建job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory=new JobDetailFactoryBean();
        factory.setJobClass(QuartzDemo.class);
        return factory;
    }

    /**
     * 创建trigger对象
     */
//    @Bean
//    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
//        SimpleTriggerFactoryBean factoryBean=new SimpleTriggerFactoryBean();
//        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
//        factoryBean.setRepeatInterval(2000);
//        factoryBean.setRepeatCount(10);
//
//        return factoryBean;
//    }
    /**
     * 接下来是corn trigger
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean cronTriggerFactoryBean=new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("*/5 * * * * ?");
        return cronTriggerFactoryBean;
    }

    /**
     * 创建scheduler对象
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
        SchedulerFactoryBean schedulerFactoryBean=new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        return schedulerFactoryBean;

    }
}
