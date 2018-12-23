package io.customers.board.web;


import io.customers.board.domain.Customer;
import io.customers.board.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@CrossOrigin
@Component
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @PostMapping("")
    public Flux<?> addCustomers(@Valid @RequestBody List<Customer> customers, BindingResult result) {

        System.out.println(customers);
        if (result != null && result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return Flux.just(errorMap);
        }
        return customersService.sortCustomers(customers);
    }
}