package com.musinsa.report.domain;

import com.musinsa.report.dto.MinTotal;

import java.util.List;

public interface BrandJdbcDao {
    List<MinTotal> getTotalMinBrand();

    List<Brand> getMinMaxBAGBrand();
    List<Brand> getMinMaxCAPBrand();
    List<Brand> getMinMaxOUTERBrand();
    List<Brand> getMinMaxAccessoriesBrand();
    List<Brand> getMinMaxPantsBrand();
    List<Brand> getMinMaxShoesBrand();
    List<Brand> getMinMaxSneakersBrand();
    List<Brand> getMinMaxTopBrand();
}
