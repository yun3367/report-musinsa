package com.musinsa.report.domain;

import com.musinsa.report.dto.MinTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BrandDao extends JpaRepository<Brand, String> {

}
