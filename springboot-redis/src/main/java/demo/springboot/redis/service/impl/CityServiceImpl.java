package demo.springboot.redis.service.impl;

import demo.springboot.redis.redis.RedisUtil;
import demo.springboot.redis.entity.City;
import demo.springboot.redis.redis.annoatation.RedisCache;
import demo.springboot.redis.repository.CityMapper;
import demo.springboot.redis.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;

    @Autowired
    private RedisUtil redisUtil;

    @RedisCache(Key = "cityList")
    public List<City> findAllCity(int pageSize, int pageIndex) {
        return cityMapper.selectAll();
    }

    public City findCityByID(int id) {
        String key = "city_" + id;
        boolean hasKey = redisUtil.hasKey(key);
        if (hasKey) {
            City city = redisUtil.get(key);
            log.info("从缓存中获取了城市 >> " + city.toString());
            return city;
        }

        City city = cityMapper.selectByPrimaryKey(id);
        redisUtil.set(key, city, 60 * 1000);
        log.info("写入缓存 >> " + city.toString());
        log.info("从数据库中获取了城市 >> " + city.toString());

        return city;
    }

    public int saveCity(City city) {
        return cityMapper.insert(city);
    }

    public int updateCity(City city) {
        return cityMapper.updateByPrimaryKey(city);
    }

    public int deleteCity(Long id) {
        return cityMapper.deleteByPrimaryKey(id);
    }
}
