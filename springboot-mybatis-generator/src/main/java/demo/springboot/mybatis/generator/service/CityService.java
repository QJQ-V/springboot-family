package demo.springboot.mybatis.generator.service;

import demo.springboot.mybatis.generator.entity.City;

import java.util.List;

// 城市业务接口类
public interface CityService {
    List<City> findAllCity();
    City findCityByID(int id);
    int saveCity(City city);
    int updateCity(City city);
    int deleteCity(Long id);
}
