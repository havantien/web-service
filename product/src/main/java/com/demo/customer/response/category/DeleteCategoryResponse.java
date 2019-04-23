package com.demo.customer.response.category;

import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCategoryResponse extends AbstractResponse {
    private String message = "thanh cong";
}
