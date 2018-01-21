package ru.mamsta.otus.blockfirst.lessonsecond;

import java.lang.management.ManagementFactory;
import java.util.*;

public class Main {

    private static String strForGenerator = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm" +
            "ЙЦУКЕНГШЩЗХЪЁФЫВАПРОЛДЖЭЯЧСМИТЬБЮёйцукенгшщзхъфывапролджэячсмитьбю1234567890";
    private static Random random = new Random(System.nanoTime());

    public static void main(String[] args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int arraySize = 2_000_000;
        int stringSize = 50;
        int minList = 8;
        int sizeList = 40;

        System.out.println("Starting the loop");
        Runtime runtime = Runtime.getRuntime();

        System.gc();
        Thread.sleep(1000);

        while(true){

            System.out.println("memory for 'new Object()': " +
                    StandMemory.monitoring(runtime, () -> {
                        Object[] os = new Object[arraySize];
                        for (int i = 0; i < arraySize; i++){
                            os[i] = new Object();
                        }
                        return os;
                    })/arraySize);

            System.out.println("memory for 'new String(new char[0])': " +
                    StandMemory.monitoring(runtime, () -> {
                        String[] ss = new String[arraySize];
                        for(int i = 0; i < arraySize; i++) {
                            ss[i] = new String(new char[0]);
                        }
                        return ss;
                    })/arraySize);

            System.out.println("memory for 'new String(new char[1])': " +
                    StandMemory.monitoring(runtime, () -> {
                        String[] ss = new String[arraySize];
                        for(int i = 0; i < arraySize; i++) {
                            ss[i] = new String(new char[1]);
                        }
                        return ss;
                    })/arraySize);

            System.out.println("memory for 'new String(new char[" + stringSize + "])': " +
                    StandMemory.monitoring(runtime, () -> {
                        String[] ss = new String[arraySize];
                        for(int i = 0; i < arraySize; i++) {
                            ss[i] = new String(new char[stringSize]);
                        }
                        return ss;
                    })/arraySize);

            System.out.println("memory for 'new String()': " +
                    StandMemory.monitoring(runtime, () -> {
                        String[] ss = new String[arraySize];
                        for(int i = 0; i < arraySize; i++) {
                            ss[i] = new String();
                        }
                        return ss;
                    })/arraySize);

            System.out.println("memory for \"\": " +
                    StandMemory.monitoring(runtime, () -> {
                        String[] ss = new String[arraySize];
                        for(int i = 0; i < arraySize; i++) {
                            ss[i] = "";
                        }
                        return ss;
                    })/arraySize);

            System.out.println("memory for 'new String(\"\")': " +
                    StandMemory.monitoring(runtime, () -> {
                        String[] ss = new String[arraySize];
                        for(int i = 0; i < arraySize; i++) {
                            ss[i] = new String("");
                        }
                        return ss;
                    })/arraySize);

            System.out.println("memory for random string with length " + stringSize + ": " +
                    StandMemory.monitoring(runtime, () -> {
                        String[] ss = new String[arraySize];
                        for (int i = 0; i < arraySize; i++) {
                            ss[i] = getRndStr(stringSize);
                        }
                        return ss;
                    })/arraySize);

            System.out.println("memory for 'new ArrayList<String>()' empty: " +
                    StandMemory.monitoring(runtime, () -> {
                        ArrayList<String>[] als = new ArrayList[arraySize];
                        ArrayList<String> al = new ArrayList<>();
                        for(int i = 0; i < minList; i++) {
                            al.add(getRndStr(stringSize));
                        }
                        for(int i = 0; i < arraySize; i++) {
                            als[i] = new ArrayList<String>();
                        }
                        return als;
                    })/arraySize);

            System.out.println("memory for 'new LinkedList<String>()' empty: " +
                    StandMemory.monitoring(runtime, () -> {
                        LinkedList<String>[] lls = new LinkedList[arraySize];
                        LinkedList<String> ll = new LinkedList<>();
                        for(int i = 0; i < arraySize; i++) {
                            lls[i] = ll;
                        }
                        return lls;
                    })/arraySize);

            System.out.println("memory for 'new ArrayList<String>()' with " + minList + " string in list and string length " + stringSize + " char (random): " +
                    StandMemory.monitoring(runtime, () -> {
                        ArrayList<String>[] als = new ArrayList[arraySize];
                        ArrayList<String> al = new ArrayList<>();
                        for(int i = 0; i < minList; i++) {
                            al.add(getRndStr(stringSize));
                        }
                        for(int i = 0; i < arraySize; i++) {
                            als[i] = new ArrayList<String>();
                        }
                        return als;
                    })/arraySize);

            System.out.println("memory for 'new LinkedList<String>()' with " + minList + " string in list and string length " + stringSize + " char (random): " +
                    StandMemory.monitoring(runtime, () -> {
                        LinkedList<String>[] lls = new LinkedList[arraySize];
                        LinkedList<String> ll = new LinkedList<>();
                        for(int i = 0; i < minList; i++) {
                            ll.add(getRndStr(stringSize));
                        }
                        for(int i = 0; i < arraySize; i++) {
                            lls[i] = ll;
                        }
                        return lls;
                    })/arraySize);

            System.out.println("memory for 'new ArrayList<String>()' with " + sizeList + " string in list and string length " + stringSize + " char (random): " +
                    StandMemory.monitoring(runtime, () -> {
                        ArrayList<String>[] als = new ArrayList[arraySize];
                        ArrayList<String> al = new ArrayList<>();
                        for(int i = 0; i < sizeList; i++) {
                            al.add(getRndStr(stringSize));
                        }
                        for(int i = 0; i < arraySize; i++) {
                            als[i] = new ArrayList<String>();
                        }
                        return als;
                    })/arraySize);

            System.out.println("memory for 'new LinkedList<String>()' with " + sizeList + " string in list and string length " + stringSize + " char (random): " +
                    StandMemory.monitoring(runtime, () -> {
                        LinkedList<String>[] lls = new LinkedList[arraySize];
                        LinkedList<String> ll = new LinkedList<>();
                        for(int i = 0; i < sizeList; i++) {
                            ll.add(getRndStr(stringSize));
                        }
                        for(int i = 0; i < arraySize; i++) {
                            lls[i] = ll;
                        }
                        return lls;
                    })/arraySize);

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
