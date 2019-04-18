package com.demo.customer.controller;


import com.demo.customer.model.type.City;
import com.demo.customer.response.ResponseModel;
import com.demo.customer.response.city.AddCityResponse;
import com.demo.customer.response.city.CityResponse;
import com.demo.customer.response.city.DeleteCityResponse;
import com.demo.customer.response.city.ListAllCityResponse;
import com.demo.customer.utils.ResponseUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class CityController extends AbstractController {

    @GetMapping("/citys")
    public ResponseEntity<ResponseModel> listCity(){
        List<City> citys = cityService.findAll();
        if (citys.isEmpty()) {
            return FAIL_RESPONSE;
        }
        ListAllCityResponse listAllCityResponse = new ListAllCityResponse();
        return ResponseUtils.buildResponseEntity (listAllCityResponse, HttpStatus.OK);

    }

    @GetMapping("/citys/{id}")
    public ResponseEntity<ResponseModel> getCity(@PathVariable("id") Long id)
    {
        City city = cityService.findById(id);
        if (city == null) {
            return FAIL_RESPONSE ;
        }
        CityResponse cityResponse = new CityResponse();
        return  ResponseUtils.buildResponseEntity(cityResponse, HttpStatus.OK);
    }

    @PostMapping("/citys")
    public ResponseEntity<City> createCity(@RequestBody City city,
                                           UriComponentsBuilder builder){
        cityService.save(city);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/citys/{id}")
        .buildAndExpand(city.getId()).toUri());
        return new ResponseEntity<>(city, HttpStatus.CREATED);

    }

    @PutMapping("/citys/{id}")
    public ResponseEntity<ResponseModel> updateCity(@PathVariable("id") Long id,
                                                    @RequestBody City city){
        City currentCity = cityService.findById(id);
        if (currentCity == null) {
            return FAIL_RESPONSE;
        }
        currentCity.setName(city.getName());
        cityService.save(currentCity);
        AddCityResponse addCityResponse = new AddCityResponse(currentCity.getName());
        return ResponseUtils.buildResponseEntity(addCityResponse, HttpStatus.OK);
    }

    @DeleteMapping("/citys/{id}")
    public ResponseEntity<ResponseModel> deleteCity(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        if (city == null) {
            return FAIL_RESPONSE;
        }
        cityService.remove(id);
        DeleteCityResponse deleteCityResponse = new DeleteCityResponse();
        return ResponseUtils.buildResponseEntity(deleteCityResponse, HttpStatus.OK);
    }
}
