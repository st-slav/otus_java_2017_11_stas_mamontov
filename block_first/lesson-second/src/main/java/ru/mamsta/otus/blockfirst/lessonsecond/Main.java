package ru.mamsta.otus.blockfirst.lessonsecond;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    private static String strForGenerator = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm" +
            "ЙЦУКЕНГШЩЗХЪЁФЫВАПРОЛДЖЭЯЧСМИТЬБЮёйцукенгшщзхъфывапролджэячсмитьбю1234567890";
    private static Random random = new Random(System.nanoTime());

    public static void main(String[] args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 1000;
        int listSize = 100000;
        int stringSize = 50;

        System.out.println("Starting the loop");
        Runtime runtime = Runtime.getRuntime();

        while(true){

            System.out.println("memory for 'new String(new char[0])': " +
                    StandMemory.monitoring(runtime, () -> new String(new char[0])));

            System.out.println("memory for 'new String(new char[" + stringSize + "])': " +
                    StandMemory.monitoring(runtime, () -> new String(new char[stringSize])));

            System.out.println("memory for 'new String()': " +
                    StandMemory.monitoring(runtime, () -> new String()));

            System.out.println("memory for 'new String(\"\")': " +
                    StandMemory.monitoring(runtime, () -> new String("")));

            System.out.println("memory for \"\": " +
                    StandMemory.monitoring(runtime, () -> ""));

            System.out.println("memory for 'new ArrayList<String>()': " +
                    StandMemory.monitoring(runtime, () -> new ArrayList<String>()));

            System.out.println("memory for 1 object in 'new ArrayList<String>()' and add " + listSize + " empty string: " +
                    StandMemory.monitoring(runtime, () -> {
                        List<String> l = new ArrayList<>();
                        for(int i = 0; i < listSize; i++) {
                            l.add(new String());
                        }
                        return l;
                    })/listSize);

            System.out.println("memory for 1 object in 'new ArrayList<String>()' and add " + listSize + " random string length " + stringSize + ": " +
                    StandMemory.monitoring(runtime, () -> {
                        List<String> l = new ArrayList<>();
                        for(int i = 0; i < listSize; i++) {
                            l.add(getRndStr(stringSize));
                        }
                        return l;
                    })/listSize);

            System.out.println("memory for 1 object in 'new ArrayList<String>()' and add " + listSize + " string with char array length " + stringSize + ": " +
                    StandMemory.monitoring(runtime, () -> {
                        List<String> l = new ArrayList<>();
                        for(int i = 0; i < listSize; i++) {
                            l.add(new String(new char[stringSize]));
                        }
                            return l;
                    })/listSize);

            System.out.println("memory for 1 object in 'new String[]' with size " + listSize + ": " +
                    StandMemory.monitoring(runtime, () -> new String[listSize])/listSize);

            System.out.println("memory for 1 object in 'new String[]' with size " + listSize + " and object is char array length " + stringSize + ": " +
                    StandMemory.monitoring(runtime, () -> {
                        String[] ss = new String[listSize];
                        Stream.of(ss).forEach(s -> s = new String(new char[stringSize]));
                        return ss;
                    })/listSize);

            System.out.println("memory for 1 object in 'new String[]' with size " + listSize + " and object is random string with length " + stringSize + ": " +
                    StandMemory.monitoring(runtime, () -> {
                        String[] ss = new String[listSize];
                        Stream.of(ss).forEach(s -> s = getRndStr(stringSize));
                        return ss;
                    })/listSize);

            System.out.println("memory for 'new LinkedList<String>()': " +
                    StandMemory.monitoring(runtime, () -> new LinkedList<String>()));

            System.out.println("memory for 1 object in 'new LinkedList<String>()' and add " + listSize + " empty string: " +
                    StandMemory.monitoring(runtime, () -> {
                        List<String> l = new LinkedList<>();
                        for(int i = 0; i < listSize; i++) {
                            l.add(new String());
                        }
                        return l;
                    })/listSize);

            System.out.println("memory for 1 object in 'new LinkedList<String>()' and add " + listSize + " random string length " + stringSize + ": " +
                    StandMemory.monitoring(runtime, () -> {
                        List<String> l = new LinkedList<>();
                        for(int i = 0; i < listSize; i++) {
                            l.add(getRndStr(stringSize));
                        }
                        return l;
                    })/listSize);

            System.out.println("memory for 1 object in 'new LinkedList<String>()' and add " + listSize + " and object is char array length " + stringSize + ": " +
                    StandMemory.monitoring(runtime, () -> {
                        List<String> l = new LinkedList<>();
                        for(int i = 0; i < listSize; i++) {
                            l.add(new String(new char[stringSize]));
                        }
                        return l;
                    })/listSize);

            System.out.println("memory for class with 2 field int: " +
                    StandMemory.monitoring(runtime, () -> new Object() {
                        public int first;
                        public int second;
                    }));

            System.out.println("memory for class with 3 field int: " +
                    StandMemory.monitoring(runtime, () -> new Object() {
                        public int first;
                        public int second;
                        public int third;
                    }));


//            System.gc();
//            Thread.sleep(100);
//
//            long mem2 = runtime.totalMemory() - runtime.freeMemory();
//
//            String[] objects = new String[size];
//            System.out.println("new array of size: " + size + " created");
//
//            long mem3 = runtime.totalMemory() - runtime.freeMemory();
//            System.out.println("active for object in empty string array: " + (mem3 - mem2) / size);
//
//            for(String ss : objects) {
//                ss = "очень важная строка";
//            }
//
//            System.out.println("created " + size + " objects.");
//
//            long mem4 = runtime.totalMemory() - runtime.freeMemory();
//            System.out.println("memory for object in string array: " + (mem4 - mem3) / size);
//
//            //если это расскомментировать тогда выйдет NPE
//            Stream.of(objects).forEach(x -> x.toString());
//
//            long mem5 = runtime.totalMemory() - runtime.freeMemory();
//            System.out.println("memory for object in string array after call: " + (mem5 - mem4) / size);

            System.out.println("----------------------------------------------------------------------------");
        }
    }

    private static String getRndStr(int stringSize) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < stringSize; j++) {
            sb.append(strForGenerator.charAt(random.nextInt(strForGenerator.length())));
        }
        return sb.toString();
    }
}
