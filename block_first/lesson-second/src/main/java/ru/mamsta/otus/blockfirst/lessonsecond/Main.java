package ru.mamsta.otus.blockfirst.lessonsecond;

import java.lang.management.ManagementFactory;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

            int size = 20000000;

        System.out.println("Starting the loop");

        while(true) {
            System.gc();
            Thread.sleep(50);

            Runtime runtime = Runtime.getRuntime();
            long mem = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("active memory: " + mem);

            //String s = new String();
            //String s = new String(new char[50]);
            String s = new String(new char[1]);

            System.gc();
            Thread.sleep(50);

            long mem1 = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("active memory1: " + mem1);
            System.out.println("memory for string: " + (mem1 - mem));

            String[] objects = new String[size];
            System.out.println("new array of size: " + size + " created");

            System.gc();
            Thread.sleep(50);

            long mem2 = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("active memory2: " + mem2);
            System.out.println("active for empty: " + (mem2 - mem1) / size);

            //Stream.of(objects).forEach(x -> x = new String());
            Stream.of(objects).forEach(x -> x = new String(new char[100]));

            System.out.println("created " + size + " objects.");
            System.gc();
            Thread.sleep(50);

            long mem3 = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("active memory3: " + mem3);
            System.out.println("memory for object: " + (mem3 - mem2) / size);
        }
    }
}
