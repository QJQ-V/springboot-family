package demo.springboot.mybatis.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.springboot.mybatis.generator.repository.CityMapper;
import demo.springboot.mybatis.generator.entity.City;
import demo.springboot.mybatis.generator.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    public List<City>  findAllCity() {
        return cityMapper.selectAll();
    }

    public City findCityByID(int id) {
        return cityMapper.selectByPrimaryKey(id);
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

    public PageInfo<List<City>> findCityByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<City> cites = cityMapper.selectAll();
        PageInfo page = new PageInfo(cites);

        return page;
    }
}
