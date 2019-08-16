package demo.springboot.mybatis.service.impl;

import demo.springboot.mybatis.dao.CityDao;
import demo.springboot.mybatis.domain.City;
import demo.springboot.mybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    public List<City> findAllCity() {
        return cityDao.findAllCity();
    }

    public City findCityByID(long id) {
        return cityDao.findCityByID(id);
    }

    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    public Long updateCity(City city) {
        return cityDao.updateCity(city);
    }

    public Long deleteCity(Long id) {
        return cityDao.deleteCity(id);
    }
}
