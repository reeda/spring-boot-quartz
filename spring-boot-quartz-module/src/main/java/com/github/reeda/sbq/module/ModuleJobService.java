package com.github.reeda.sbq.module;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by andrew on 11/27/15.
 */
@Service
public class ModuleJobService {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public String getValue() {
        return "Module Job Executed: " + atomicInteger.incrementAndGet();
    }

}
