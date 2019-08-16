package demo.springboot.mybatis.dao;
import demo.springboot.mybatis.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityDao {
    List<City> findAllCity();

    City findCityByID(@Param("id") long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
