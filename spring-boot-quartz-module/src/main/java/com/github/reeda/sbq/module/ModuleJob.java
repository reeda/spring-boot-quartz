package com.github.reeda.sbq.module;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by andrew on 11/27/15.
 */
@Slf4j
public class ModuleJob  extends QuartzJobBean {

    @Autowired
    private ModuleJobService moduleJobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info(moduleJobService.getValue());
    }
}
