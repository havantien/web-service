package com.demo.customer.response.city;

import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCityResponse extends AbstractResponse {

    private String name;
}
