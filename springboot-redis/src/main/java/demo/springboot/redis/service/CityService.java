package demo.springboot.redis.service;

import demo.springboot.redis.entity.City;

import java.util.List;

// 城市业务接口类
public interface CityService {
    List<City> findAllCity(int pageSize, int pageIndex);
    City findCityByID(int id);
    int saveCity(City city);
    int updateCity(City city);
    int deleteCity(Long id);
}
