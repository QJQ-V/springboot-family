package demo.springboot.springbootrestful.service;

import demo.springboot.springbootrestful.domain.City;

import java.util.List;

// 城市业务接口类
public interface CityService {
    List<City> findAllCity();
    City findCityByID(long id);
    Long saveCity(City city);
    Long updateCity(City city);
    Long deleteCity(Long id);
}
