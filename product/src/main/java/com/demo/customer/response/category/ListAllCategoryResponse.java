package com.demo.customer.response.category;

import com.demo.customer.model.type.Category;
import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAllCategoryResponse extends AbstractResponse {
   private List<Category> categoryList;
}
