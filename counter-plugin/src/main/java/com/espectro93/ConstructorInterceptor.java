package com.espectro93;

import java.util.concurrent.atomic.AtomicInteger;

public class ConstructorInterceptor {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void increment() {
        int count = counter.incrementAndGet();
        System.out.println("A class was instantiated! Total count: " + count);
    }
}
