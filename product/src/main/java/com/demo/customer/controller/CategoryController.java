package com.demo.customer.controller;

import com.demo.customer.model.type.Category;
import com.demo.customer.response.ResponseModel;
import com.demo.customer.response.category.AddCategoryResponse;
import com.demo.customer.response.category.CategoryResponse;
import com.demo.customer.response.category.DeleteCategoryResponse;
import com.demo.customer.response.category.ListAllCategoryResponse;
import com.demo.customer.utils.ResponseUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CategoryController extends AbstractController {

    @GetMapping("/categories")
    public ResponseEntity<ResponseModel> listCategory(){
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return FAIL_RESPONSE;
        }
        ListAllCategoryResponse listAllCityResponse = new ListAllCategoryResponse();
        return ResponseUtils.buildResponseEntity (listAllCityResponse, HttpStatus.OK);

    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<ResponseModel> getCity(@PathVariable("id") Long id)
    {
        Category category = categoryService.findById(id);
        if (category == null) {
            return FAIL_RESPONSE ;
        }
        CategoryResponse categoryResponse = new CategoryResponse();
        return  ResponseUtils.buildResponseEntity(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCity(@RequestBody Category category,
                                           UriComponentsBuilder builder){
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/categories/{id}")
                .buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<ResponseModel> updateCity(@PathVariable("id") Long id,
                                                    @RequestBody Category category){
        Category currentCategory = categoryService.findById(id);
        if (currentCategory == null) {
            return FAIL_RESPONSE;
        }
        currentCategory.setName(category.getName());
        categoryService.save(currentCategory);
        AddCategoryResponse addCategoryResponse = new AddCategoryResponse();
        return ResponseUtils.buildResponseEntity(addCategoryResponse, HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<ResponseModel> deleteCity(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return FAIL_RESPONSE;
        }
        categoryService.remove(id);
        DeleteCategoryResponse deleteCategoryResponse = new DeleteCategoryResponse();
        return ResponseUtils.buildResponseEntity(deleteCategoryResponse, HttpStatus.OK);
    }
}
