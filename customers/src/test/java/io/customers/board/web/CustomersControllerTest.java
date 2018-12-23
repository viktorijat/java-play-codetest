package io.customers.board.web;

import io.customers.board.domain.Customer;
import io.customers.board.service.CustomersService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class CustomersControllerTest {

    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:SSSZ";

    @Mock
    private CustomersService customersService;

    @InjectMocks
    private CustomersController customersController;

    public CustomersControllerTest() {}

    @Test
    public void shouldSortAddedCustomers() {

        List<Customer> customers = createCustomers();
        Mockito.when(customersService.sortCustomers(Mockito.any())).thenReturn(Flux.fromIterable(customers));


        Flux<?> flux = customersController.addCustomers(createCustomers(), null);

        List<?> collect = flux.collectList().block();
        assertThat(collect.get(0), equalTo(customers.get(0)));
        assertThat(collect.get(1), equalTo(customers.get(1)));
        assertThat(collect.get(2), equalTo(customers.get(2)));
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