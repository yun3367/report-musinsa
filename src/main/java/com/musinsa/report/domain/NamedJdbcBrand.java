package com.musinsa.report.domain;

import com.musinsa.report.dto.MinTotal;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NamedJdbcBrand extends NamedParameterJdbcDaoSupport implements BrandJdbcDao {
    String MIN_TOTAL_BRAND_SQL =
            "select b.BRAND as name, (b.ACCESSORIES + b.BAG + b.CAP + b.OUTER + b.PANTS + b.SHOES + b.SNEAKERS + b.TOP) as totalValue " +
                    "from Brand b order by totalValue";

    String MIN_MAX_ACCESSORIES_BRAND_SQL =
            "select BRAND as name, ACCESSORIES from BRAND " +
                    "where ACCESSORIES=(select MIN(ACCESSORIES) from BRAND) or ACCESSORIES=(select MAX(ACCESSORIES) from BRAND) order by ACCESSORIES";

    String MIN_MAX_CAP_BRAND_SQL =
            "select BRAND as name, CAP from BRAND " +
                    "where CAP=(select MIN(CAP) from BRAND) or CAP=(select MAX(CAP) from BRAND) order by CAP";

    String MIN_MAX_BAG_BRAND_SQL =
            "select BRAND as name, BAG from BRAND " +
                    "where BAG=(select MIN(BAG) from BRAND) or BAG=(select MAX(BAG) from BRAND) order by BAG";

    String MIN_MAX_OUTER_BRAND_SQL =
            "select BRAND as name, OUTER from BRAND " +
                    "where OUTER=(select MIN(OUTER) from BRAND) or OUTER=(select MAX(OUTER) from BRAND) order by OUTER";

    String MIN_MAX_PANTS_BRAND_SQL =
            "select BRAND as name, PANTS from BRAND " +
                    "where PANTS=(select MIN(PANTS) from BRAND) or PANTS=(select MAX(PANTS) from BRAND) order by PANTS";

    String MIN_MAX_SHOES_BRAND_SQL =
            "select BRAND as name, SHOES from BRAND " +
                    "where SHOES=(select MIN(SHOES) from BRAND) or SHOES=(select MAX(SHOES) from BRAND) order by SHOES";

    String MIN_MAX_SNEAKERS_BRAND_SQL =
            "select BRAND as name, SNEAKERS from BRAND " +
                    "where SNEAKERS=(select MIN(SNEAKERS) from BRAND) or SNEAKERS=(select MAX(SNEAKERS) from BRAND) order by SNEAKERS";

    String MIN_MAX_TOP_BRAND_SQL =
            "select BRAND as name, TOP from BRAND " +
                    "where TOP=(select MIN(TOP) from BRAND) or TOP=(select MAX(TOP) from BRAND) order by TOP";

    @Override
    public List<MinTotal> getTotalMinBrand() {
        Map params = null;
        try {
            return getNamedParameterJdbcTemplate().query(MIN_TOTAL_BRAND_SQL,
                    params,
                    BeanPropertyRowMapper.newInstance(MinTotal.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Brand> getMinMaxBAGBrand() {
        try {
            return getNamedParameterJdbcTemplate().query(MIN_MAX_BAG_BRAND_SQL,
                    BeanPropertyRowMapper.newInstance(Brand.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Brand> getMinMaxCAPBrand() {
        try {
            return getNamedParameterJdbcTemplate().query(MIN_MAX_CAP_BRAND_SQL,
                    BeanPropertyRowMapper.newInstance(Brand.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Brand> getMinMaxOUTERBrand() {
        try {
            return getNamedParameterJdbcTemplate().query(MIN_MAX_OUTER_BRAND_SQL,
                    BeanPropertyRowMapper.newInstance(Brand.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Brand> getMinMaxAccessoriesBrand() {
        try {
            return getNamedParameterJdbcTemplate().query(MIN_MAX_ACCESSORIES_BRAND_SQL,
                    BeanPropertyRowMapper.newInstance(Brand.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Brand> getMinMaxPantsBrand() {
        try {
            return getNamedParameterJdbcTemplate().query(MIN_MAX_PANTS_BRAND_SQL,
                    BeanPropertyRowMapper.newInstance(Brand.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Brand> getMinMaxShoesBrand() {
        try {
            return getNamedParameterJdbcTemplate().query(MIN_MAX_SHOES_BRAND_SQL,
                    BeanPropertyRowMapper.newInstance(Brand.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Brand> getMinMaxSneakersBrand() {
        try {
            return getNamedParameterJdbcTemplate().query(MIN_MAX_SNEAKERS_BRAND_SQL,
                    BeanPropertyRowMapper.newInstance(Brand.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Brand> getMinMaxTopBrand() {
        try {
            return getNamedParameterJdbcTemplate().query(MIN_MAX_TOP_BRAND_SQL,
                    BeanPropertyRowMapper.newInstance(Brand.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
