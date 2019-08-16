package demo.springboot.mybatis.generator.controller;

import demo.springboot.mybatis.generator.entity.City;
import demo.springboot.mybatis.generator.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findCityByID(@PathVariable("id") Long id) {
        return cityService.findCityByID(id);
    }

    @RequestMapping(value = "/api/city/create", method = RequestMethod.POST)
    public void createCity(City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city/update", method = RequestMethod.POST)
    public void modifyCity(City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/delete/{id}", method = RequestMethod.POST)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
