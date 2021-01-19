package com.k7.groupPayments;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class ConsoleUserInput<T> implements UserInput<T> {
    private Scanner sc;
    private Parser parser;

    @Override
    public void start(T in) {
        List<String> listIn = new ArrayList<>();
        while (!in.equals("END")) {
            listIn.add((String)in);
            in = (T) sc.nextLine();
        }
        parser.parse(listIn);
//        for (String s:listIn) {
//            System.out.println(s);
        }
    }

