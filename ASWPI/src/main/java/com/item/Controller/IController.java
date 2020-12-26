package com.item.Controller;

import com.item.Dao.CityDao;
import com.item.Dao.CountyDao;
import com.item.Dao.ProvinceDao;
import com.item.domain.City;
import com.item.domain.County;
import com.item.domain.Province;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class IController{
    @RequestMapping("/China")
    @ResponseBody
    public List<Province> getProvince(){
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        ProvinceDao bean = app.getBean(ProvinceDao.class);
        List<Province> list = bean.queryProvince();
        return list;
    }

    @RequestMapping("/China/{City}")
    @ResponseBody
    public List<City> getCity(@PathVariable("City") int cityId){
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        CityDao bean = app.getBean(CityDao.class);
        List<City> cities = bean.queryCity(cityId);
        return cities;
    }

    @RequestMapping("/China/{City}/{County}")
    @ResponseBody
    public List<County> getCounty(@PathVariable("County") int CountyId){
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        CountyDao bean = app.getBean(CountyDao.class);
        List<County> counties = bean.queryCounty(CountyId);
        System.out.println(counties);
        return counties;
    }
}
