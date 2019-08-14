package demo.springboot.springbootmybatis.dao;

import demo.springboot.springbootmybatis.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityDao {
    @Select("select * from city")
    List<City> findAllCity();

    @Select("select * from city where id = #{id}")
    City findCityByID(long id);

    @Insert("insert into city(province_id,city_name,description) values(#{provinceId},#{cityName},#{description})")
    Long saveCity(City city);

    @Update("update city set province_id=#{provinceId},city_name = #{cityName},description=#{description}  where id = #{id}")
    Long updateCity(City city);

    @Delete("delete from city where id = ${id}")
    Long deleteCity(Long id);
}
