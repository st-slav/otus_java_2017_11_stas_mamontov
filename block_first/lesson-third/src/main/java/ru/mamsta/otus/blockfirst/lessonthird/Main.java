package ru.mamsta.otus.blockfirst.lessonthird;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> ss = new ArrayList<>(5);
        System.out.println(ss.size());
        ss.add("1 ");
        ss.add("2 ");
//        ss.add(null);
//        ss.toArray();
//        ss.get(2);
        System.out.println(ss.size());
        String[] sss = new String[5];
        System.out.println(sss.length);
//        System.out.println(sss[6]);
        List<String> myStrings = new MyArrayList<>();
        System.out.println("------------");
        myStrings.add("nuuuull");
        myStrings.add("one");
        myStrings.add("three");
        myStrings.add("four");
        myStrings.addAll(2, ss);
        System.out.println("--------------------");
        for(int i = 0; i < myStrings.size(); i++) {
            System.out.println(myStrings.get(i));
        }
        System.out.println("--------------------");
        System.out.println(myStrings.toString());
        System.out.println(myStrings.get(1));
        System.out.println(myStrings.size());
        System.out.println(myStrings.remove("one"));
        System.out.println(myStrings.toString());
        System.out.println(myStrings.get(0));
        System.out.println(myStrings.get(1));
        System.out.println(myStrings.get(2));
        System.out.println(myStrings.size());
        System.out.println(myStrings.remove("nuuuull"));
        System.out.println(myStrings.toString());
        System.out.println(myStrings.get(0));
        System.out.println(myStrings.get(1));
        System.out.println(myStrings.size());
        System.out.println(myStrings.remove("nuuuull"));
        System.out.println(myStrings.toString());
        System.out.println(myStrings.get(0));
        System.out.println(myStrings.get(1));
        System.out.println(myStrings.size());
//        Collections.copy(ss, myStrings);
//        Collections.sort(myStrings, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

       Map<String, String> map = new HashMap<>();

        for(Map.Entry<String, String> s : map.entrySet()) {

        }
    }
}
