package com.item.Dao.Impl;

import com.item.domain.City;
import com.item.Dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("cityDao")
public class CityDaoImpl implements CityDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<City> queryCity(int id) {
        List<City> list = jdbcTemplate.query("select * from city where provinceid = ?", new BeanPropertyRowMapper<City>(City.class), id);
        return list;
    }
}
