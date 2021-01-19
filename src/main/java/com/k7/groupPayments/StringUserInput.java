package com.k7.groupPayments;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class StringUserInput<T> implements UserInput<T> {
    private final Parser parser;

    @Override
    public void start(T in) {
        List<String> listIn = new ArrayList<>();
//        for (String s:(String[])in) {
//            System.out.println(s);
//        }
        for (String s : (String[]) in) {
            if (!s.equals("END")) {
                listIn.add(s);
            }else parser.parse(listIn);
        }
    }
}

