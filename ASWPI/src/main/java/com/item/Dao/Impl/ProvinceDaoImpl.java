package com.item.Dao.Impl;

import com.item.Dao.ProvinceDao;
import com.item.domain.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("provinceDao")
public class ProvinceDaoImpl implements ProvinceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Province> queryProvince() {
        List<Province> list = jdbcTemplate.query("select * from province", new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
