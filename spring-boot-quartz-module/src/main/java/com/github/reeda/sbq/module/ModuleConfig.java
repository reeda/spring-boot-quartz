package com.github.reeda.sbq.module;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.concurrent.TimeUnit;

/**
 * Created by andrew on 11/27/15.
 */
@Configuration
public class ModuleConfig {

    @Bean
    public JobDetail moduleJob() {
        return JobBuilder.newJob(ModuleJob.class)
                .build();
    }

    @Bean
    public SimpleTrigger moduleJobTriggerBean(@Qualifier("moduleJobTriggerFactoryBean") SimpleTriggerFactoryBean moduleJobTriggerFactoryBean) {
        return moduleJobTriggerFactoryBean.getObject();
    }

    @Bean(name = "moduleJobTriggerFactoryBean")
    public SimpleTriggerFactoryBean moduleJobTriggerFactoryBean() {
        SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
        stFactory.setStartDelay(3000);
        stFactory.setRepeatInterval(TimeUnit.MILLISECONDS.convert(20, TimeUnit.SECONDS));
        stFactory.setJobDetail(moduleJob());
        stFactory.isSingleton();
        stFactory.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        return stFactory;
    }
}
