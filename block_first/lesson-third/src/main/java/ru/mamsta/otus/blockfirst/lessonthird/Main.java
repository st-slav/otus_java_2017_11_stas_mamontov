package ru.mamsta.otus.blockfirst.lessonthird;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> ss = new ArrayList<>(5);
        System.out.println(ss.size());
        ss.add(" ");
        System.out.println(ss.size());
        String[] sss = new String[5];
        System.out.println(sss.length);
    }
}
