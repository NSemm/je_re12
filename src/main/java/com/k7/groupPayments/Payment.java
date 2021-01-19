package com.k7.groupPayments;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
    private String type;
    private Integer sum;
    private String purpose;

    public void show() {
        System.out.println(getType() + " " + getSum() + " " + getPurpose());
    }
    public void equalPurposeSum(int s){
        sum = sum+s;
    }
}
