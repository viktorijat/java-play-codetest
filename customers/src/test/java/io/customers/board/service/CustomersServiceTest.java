package io.customers.board.service;

import io.customers.board.domain.Customer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CustomersServiceTest {

    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:SSSZ";

    @Autowired
    private CustomersService customersService;

    public CustomersServiceTest() {
        this.customersService = new CustomersService();
    }

    @Test
    public void shouldSortCustomers() {

        List<Customer> unsortedCustomers = createCustomers();
        Flux<Customer> customerFlux = customersService.sortCustomers(unsortedCustomers);

        List<Customer> result = customerFlux.collectList().block();
        assertThat(result.get(0), equalTo(unsortedCustomers.get(2)));
        assertThat(result.get(1), equalTo(unsortedCustomers.get(1)));
        assertThat(result.get(2), equalTo(unsortedCustomers.get(0)));
    }

    private List<Customer> createCustomers() {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(10000000L,
                "Ulysses Leon",
                dateTimeFromString("2014-06-18T13:26:56-07:00"),
                dateTimeFromString("2015-04-08T19:47:16-07:00")));
        customers.add(new Customer(10000001L,
                "Bruce Cardenas",
                dateTimeFromString("2013-12-28T14:11:12-08:00"),
                dateTimeFromString("2014-07-03T21:53:42-07:00")));
        customers.add(new Customer(10000002L,
                "Barrett Peterson",
                dateTimeFromString("2013-01-29T22:33:23-08:00"),
                dateTimeFromString("2014-10-23T21:46:24-07:00")));
        return customers;
    }

    private DateTime dateTimeFromString(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(PATTERN);
        return DateTime.parse(dateTime, formatter);
    }
}

