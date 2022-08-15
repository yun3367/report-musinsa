package com.musinsa.report.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MinTotal implements Serializable {
    private String name;
    private String category;
    private int totalValue;
}
