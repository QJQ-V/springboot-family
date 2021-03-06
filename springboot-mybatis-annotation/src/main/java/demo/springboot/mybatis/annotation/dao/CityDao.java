package demo.springboot.mybatis.annotation.dao;
import demo.springboot.mybatis.annotation.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityDao {
    @Select("select * from city")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "provinceId", column = "province_id"),
        @Result(property = "cityName", column = "city_name"),
        @Result(property = "description", column = "description"),
    })
    List<City> findAllCity();

    @Select("select * from city where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    City findCityByID(long id);

    @Insert("insert into city(province_id,city_name,description) values(#{provinceId},#{cityName},#{description})")
    Long saveCity(City city);

    @Update("update city set province_id=#{provinceId},city_name = #{cityName},description=#{description}  where id = #{id}")
    Long updateCity(City city);

    @Delete("delete from city where id = #{id}")
    Long deleteCity(long id);
}
