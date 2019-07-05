package com.intabia.aop.service;

import com.intabia.aop.annotation.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class ExampleService {

    @LogExecutionTime
    public void method() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextLong(5000));
    }

    public void method2() {
        log.info("Method 2");
    }
}
