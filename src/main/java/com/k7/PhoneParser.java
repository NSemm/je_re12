package com.k7;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneParser {
    private String text;

    public PhoneParser(String text) {
        this.text = text;
    }

    private List<String> stringToList() {
        List<String> list = List.of(text.split(" "));
        return list;
    }

    public void formatter() {
        Set<String> str = stringToList().stream()
                .filter(s -> s.matches("(?:(\\+)?(3)?(8)?)(0)?(\\d{8,9})"))
                .map(s -> s.substring(s.length() - 9, s.length() - 1))
                .map(s -> "+380" + s)
                .collect(Collectors.toSet());
        System.out.println("---------------Phones---------------");
        for (
                String s : str) {
            System.out.println(s);
        }
        System.out.println("------------------------------------");

    }

}
