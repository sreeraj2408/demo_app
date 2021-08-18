package com.example.demo.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberOperationsControllerTest {

    NumberOperationsController controller;

    @BeforeAll
    public void setUp() {
        this.controller = new NumberOperationsController();
    }

    @Test
    public void return_sum_of_two_numbers() {
        int number1 = 10, number2 = 20;

        ResponseEntity responseEntity = controller.sumOfNumbers(number1, number2);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(30);
    }
}
