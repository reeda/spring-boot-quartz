package com.github.reeda.sbq.engine.quartz;

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
public class EngineQuartzConfig {

    @Bean
    public JobDetail engineJob() {
        return JobBuilder.newJob(EngineQuartzJob.class)
                .build();
    }

    @Bean
    public SimpleTrigger engineJobTriggerBean(@Qualifier("engineJobTriggerFactoryBean") SimpleTriggerFactoryBean engineJobTriggerFactoryBean) {
        return engineJobTriggerFactoryBean.getObject();
    }

    @Bean(name = "engineJobTriggerFactoryBean")
    public SimpleTriggerFactoryBean engineJobTriggerFactoryBean() {
        SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
        stFactory.setStartDelay(3000);
        stFactory.setRepeatInterval(TimeUnit.MILLISECONDS.convert(10, TimeUnit.SECONDS));
        stFactory.setJobDetail(engineJob());
        stFactory.isSingleton();
        stFactory.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        return stFactory;
    }

}
