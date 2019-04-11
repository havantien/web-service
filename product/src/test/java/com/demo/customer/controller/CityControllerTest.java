//package com.demo.customer.controller;
//
//import com.demo.customer.CustomerApplication;
//import com.demo.customer.model.type.City;
//import com.demo.customer.service.CityService;
//import com.demo.customer.utils.JsonUtil;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import javax.transaction.Transactional;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = CustomerApplication.class)
//@Transactional
//public class CityControllerTest {
//    private MockMvc mockMvc;
//
//    @Autowired
//    private CityService cityService;
//
//
//    private JacksonTester<City> jsonSuperHero;
//
//    private City city;
//
//    @Before
//    public void setUp() throws Exception {
//        JacksonTester.initFields(this, new ObjectMapper());
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new CityController(cityService)).build();
//    }
//
//    @Test
//    @Transactional
//    public void getCity() throws Exception{
//        City city = new City();
//        city.setId((long)25);
//        city.setName("hanoi");
//        String json = JsonUtil.convertObjToJsonCity(city);
//
//        //when
//        MockHttpServletResponse response = mockMvc.perform(get("/v1/citys/{id}", 25)
//                .accept(MediaType.APPLICATION_JSON))
//                .andReturn()
//                .getResponse();
//
//        //Then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo(
//                jsonSuperHero.write(city).getJson()
//        );
//
//    }
//
//    @Test
//    @Transactional
//    public void createCity() throws Exception {
//        City currentCity = new City();
//        currentCity.setId((long)26);
//        currentCity.setName("hanoi");
//        String json = JsonUtil.convertObjToJsonCity(currentCity);
//
//
//
//        //when
//        MockHttpServletResponse response = mockMvc.perform(post("/v1/citys")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonSuperHero.write(currentCity).getJson()))
//                .andReturn().getResponse();
//
//        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
//        assertThat(response.getContentAsString()).isEqualTo(
//                jsonSuperHero.write(currentCity).getJson()
//        );
//    }
//
//    @Test
//    public void updateCity() throws Exception{
//            city = cityService.findById((long)25);
//            city.setName(city.getName());
//
//            //when
//            MockHttpServletResponse response = mockMvc.perform(put("/v1/citys/{id}", 25)
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(jsonSuperHero.write(city).getJson()))
//                    .andReturn().getResponse();
//
//            // then
//            assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//            assertThat(response.getContentAsString()).isEqualTo(
//                    jsonSuperHero.write(city).getJson()
//            );
//    }
//
//    @Test
//    public void deleteCity() throws Exception {
//
//        MockHttpServletResponse response = mockMvc.perform(delete("/v1/citys/{id}", 25)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse();
//    }
//}