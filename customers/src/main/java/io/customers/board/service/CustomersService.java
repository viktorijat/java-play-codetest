package io.customers.board.service;

import io.customers.board.domain.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.List;

@Service
public class CustomersService {

    public Flux<Customer> sortCustomers(List<Customer> customers){
        return Flux.fromIterable(customers).sort(Comparator.comparing(Customer::getDuetime));
    }
}