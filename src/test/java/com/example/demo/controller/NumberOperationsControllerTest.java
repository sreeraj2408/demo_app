package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberOperationsControllerTest {

    private NumberOperationsController controller;
    private ObjectMapper mapper;

    @BeforeAll
    public void setUp() {
        this.controller = new NumberOperationsController();
        this.mapper = new ObjectMapper();
    }

    @ParameterizedTest
    @CsvSource({"10, 20, 30", "3, 2, 5"})
    public void return_sum_of_two_numbers(int n1, int n2, int expected) throws JsonProcessingException {
        ResponseEntity responseEntity = controller.sumOfNumbers(n1, n2);

        assertEquals(OK, responseEntity.getStatusCode());
        Integer actual = mapper.readValue(responseEntity.getBody().toString(), Integer.class);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"5, 120", "3, 6", "4, 24"})
    public void return_factorial_of_number(int number, int expected) throws JsonProcessingException {
        ResponseEntity responseEntity = controller.factorialOfNumber(number);

        assertEquals(OK, responseEntity.getStatusCode());
        Integer actual = mapper.readValue(responseEntity.getBody().toString(), Integer.class);
        assertEquals(expected, actual);
    }

}
