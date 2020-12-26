package com.item.Dao;

import com.item.domain.County;

import java.util.List;

public interface CountyDao {
    List<County> queryCounty(int id);
}
