package com.musinsa.report.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="BRAND")
public class Brand {
    @Id
    @Column(name="BRAND")
    private String name;

    @Column(name="TOP")
    private int top;

    @Column(name="OUTER")
    private int outer;

    @Column(name="PANTS")
    private int pants;

    @Column(name="SNEAKERS")
    private int sneakers;

    @Column(name="BAG")
    private int bag;

    @Column(name="CAP")
    private int cap;

    @Column(name="SHOES")
    private int shoes;

    @Column(name="ACCESSORIES")
    private int accessories;
}
