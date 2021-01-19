package com.k7.groupPayments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculation {
    private Payments payments;
    //private int sumCredit = getSumCredit();
    //private int sumDebit = getSumDebit();

    public Calculation(Payments payments) {
        this.payments = payments;
    }

    public void showResult() {
        System.out.println((getSumCredit() > getSumDebit()) ?
                "Общий доход : " + (getSumCredit() - getSumDebit()) :
                "Общий убыток : " + (getSumDebit() - getSumCredit()));
        if (getSumCredit() > 0) {
            System.out.println("Доходы составляют " + getSumCredit() + " из которых:");
            showListCredit();
        }
        if (getSumDebit() > 0) {
            System.out.println("Расходы составляют " + getSumDebit() + " из которых:");
            showListDebit();
        }
    }

    private int getSumDebit() {
        int sum = 0;
        for (Payment p : payments.getAll()) {
            if (p.getType().equals("-"))
                sum = sum + p.getSum();
        }
        return sum;
    }

    private int getSumCredit() {
        int sum = 0;
        for (Payment p : payments.getAll()) {
            if (p.getType().equals("+"))
                sum = sum + p.getSum();
        }
        return sum;
    }

    private List<Payment> getListDebit() {
        return payments.getAll().stream()
                .filter(s -> s.getType().equals("-"))
                .collect(Collectors.toList());

    }


    private List<Payment> getListCredit() {
        return payments.getAll().stream()
                .filter(s -> s.getType().equals("+"))
                .collect(Collectors.toList());
    }

    private void showListDebit() {
        List<Payment> mainList = getListDebit();
        group(mainList);
    }

    private void showListCredit() {
        List<Payment> mainList = getListCredit();
        group(mainList);
    }

    private void group(List<Payment> mainList) {
        List<Payment> rezList = new ArrayList<>();
        boolean flagNeedAdd = true;
        for (Payment main : mainList) {
            if (rezList.size() == 0) rezList.add(new Payment(main.getType(), main.getSum(), main.getPurpose()));
            else {
                for (Payment rez : rezList) {
                    if (main.getPurpose().equals(rez.getPurpose())) {
                        rez.equalPurposeSum(main.getSum());
                        flagNeedAdd = false;
                    }
                }
                if (flagNeedAdd) rezList.add(new Payment(main.getType(), main.getSum(), main.getPurpose()));
                flagNeedAdd = true;
            }
        }
        for (Payment p : rezList) {
            System.out.println("   " + p.getPurpose() + " : " + p.getSum());
        }
    }


}
