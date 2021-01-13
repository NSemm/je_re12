package com.k7;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {


    public void parse(String in) {
        List<String> listIn = List.of(in);
        List<Payment> paymentList = listIn.stream()
                .map(s->s.split(" ", 2))
                .map(p->new Payment(p[1],p[0]))
                .collect(Collectors.toList());
    }
}

