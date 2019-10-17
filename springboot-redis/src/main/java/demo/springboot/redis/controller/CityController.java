package demo.springboot.redis.controller;

import demo.springboot.redis.entity.City;
import demo.springboot.redis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/redis/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping(value = "/all")
    public List<City> findAllCity() {
        return cityService.findAllCity(1,2);
    }

    @GetMapping(value = "/detail/{id}")
    public City findCityByID(@PathVariable("id") int id) {
        return cityService.findCityByID(id);
    }

    @PostMapping(value = "/create")
    public void createCity(City city) {
        cityService.saveCity(city);
    }

    @PostMapping(value = "/update")
    public void modifyCity(City city) {
        cityService.updateCity(city);
    }

    @PostMapping(value = "delete/{id}")
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
