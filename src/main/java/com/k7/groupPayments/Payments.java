package com.k7.groupPayments;

import lombok.Data;

import java.util.*;


@Data
public class Payments {
    private List<Payment> paymentList = new ArrayList<>();

    public void add(Payment payment) {
        paymentList.add(payment);
    }

    public void showPayments() {
        for (Payment p : paymentList) {
            p.show();
        }
    }

    public List<Payment> getAll() {
        return paymentList;
    }
}
