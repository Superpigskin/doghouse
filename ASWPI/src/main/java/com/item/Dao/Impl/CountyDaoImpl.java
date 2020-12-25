package com.item.Dao.Impl;

import com.item.domain.County;
import com.item.Dao.CountyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("countyDao")
public class CountyDaoImpl implements CountyDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<County> queryCounty(int id) {
        List<County> list = jdbcTemplate.query("select * from county where cityid = ?", new BeanPropertyRowMapper<County>(County.class), id);
        return list;
    }
}
