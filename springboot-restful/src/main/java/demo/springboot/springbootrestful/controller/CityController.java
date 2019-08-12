package demo.springboot.springbootrestful.controller;

import demo.springboot.springbootrestful.domain.City;
import demo.springboot.springbootrestful.service.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    private CityService cityService;

    @RequestMapping(value = "/api/city",method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }
}
