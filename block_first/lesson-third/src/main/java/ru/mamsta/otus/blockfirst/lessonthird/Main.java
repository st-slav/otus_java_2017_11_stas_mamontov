package ru.mamsta.otus.blockfirst.lessonthird;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> ss = new ArrayList<>(5);
        System.out.println(ss.size());
        ss.add(" ");
        ss.add(null);
        ss.get(2);
        System.out.println(ss.size());
        String[] sss = new String[5];
        System.out.println(sss.length);
//        System.out.println(sss[6]);
        List<String> myStrings = new MyArrayList<>();
//        ss.get(6);
        Collections.copy(ss, myStrings);
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
