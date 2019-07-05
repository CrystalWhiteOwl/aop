package com.intabia.aop.service;

import com.intabia.aop.annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class ExampleService {

    @LogExecutionTime
    public void method() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextLong(5000));
    }
}
