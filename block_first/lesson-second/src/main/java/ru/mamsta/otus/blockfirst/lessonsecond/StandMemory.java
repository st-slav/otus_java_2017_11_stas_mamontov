package ru.mamsta.otus.blockfirst.lessonsecond;

import java.util.function.Supplier;

public class StandMemory {

    public static <T> long monitoring(Runtime runtime, Supplier<T> factory) throws InterruptedException {

        System.gc();
        Thread.sleep(100);

        long befoMem = runtime.totalMemory() - runtime.freeMemory();

        factory.get();

        System.gc();
        Thread.sleep(100);

        return (runtime.totalMemory() - runtime.freeMemory()) - befoMem;
    }
}
