package com.demo.customer.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;


@Data
@AllArgsConstructor
public abstract class AbstractResponse {

    LocalDate date = LocalDate.now();

    public AbstractResponse() {
        this.date = getDate();
    }

}
