package com.k7.groupPayments;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private Payments payments;

    public Parser(Payments payments) {
        this.payments = payments;
    }

    public void parse(List<String> listIn) {
        //  for (String s : listIn) {
        //Валится с ошибкой Exception in thread "main" java.lang.IllegalStateException: No match found
//            Pattern pattern = Pattern.compile("(\\+|\\-)(\\d+)(\\s)(.+)");
//            Matcher matcher = pattern.matcher(s);
//            payments.add(new Payment(matcher.group(1), Integer.valueOf(matcher.group(1)+matcher.group(2)), matcher.group(4)));
        // }

        List<String[]> paymentList = listIn.stream()
                .map(s -> s.split(" ", 2))
                .collect(Collectors.toList());
        for (String[] s : paymentList) {
            payments.add(new Payment(s[0].substring(0, 1), Integer.valueOf(s[0].substring(1)), s[1]));
            //System.out.println(s[0] + "," + s[1]);
        }
//        return paymentList;
    }

}

