package com.k7;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Payment {
    private String article;
    private String sum;
}
