package com.demo.customer.controller.sub;

import com.demo.customer.controller.AbstractController;
import com.demo.customer.model.type.City;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CityController extends AbstractController {
    @GetMapping("/listCity")
    public ResponseEntity<List<City>> listCity(){
        List<City> cities = cityService.findAll();
        if (cities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cities, HttpStatus.OK);

    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> getCity(@PathVariable("id") Long id)
    {
        City city = cityService.findById(id);
        if (city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping("/citys")
    public ResponseEntity<City> createCity(@RequestBody City city,
                                           UriComponentsBuilder builder){
        cityService.save(city);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/city/{id}")
        .buildAndExpand(city.getId()).toUri());
        return new ResponseEntity<>(city, HttpStatus.CREATED);

    }

    @PutMapping("/city/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") Long id,
                                           @RequestBody City city){
        City currentCity = cityService.findById(id);
        if (currentCity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCity.setName(city.getName());
        cityService.save(currentCity);
        return new ResponseEntity<>(currentCity, HttpStatus.OK);
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        if (city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
