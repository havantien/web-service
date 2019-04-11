package com.demo.customer.response.city;

import com.demo.customer.model.type.City;
import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListAllCityResponse extends AbstractResponse {
    private List<City> cityList;
}
