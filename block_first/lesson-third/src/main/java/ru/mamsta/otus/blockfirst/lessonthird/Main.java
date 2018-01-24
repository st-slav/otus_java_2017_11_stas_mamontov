package ru.mamsta.otus.blockfirst.lessonthird;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> ss = new ArrayList<>(5);
        System.out.println(ss.size());
        ss.add(" ");
        System.out.println(ss.size());
        String[] sss = new String[5];
        System.out.println(sss.length);
        List<String> myStrings = new MyArrayList<>();
        Collections.copy(ss, myStrings);
        Collections.sort(myStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}
