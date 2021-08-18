package com.example.demo.integration;

import com.example.demo.DemoApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
public class NumberOperationsIntTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @ParameterizedTest
    @CsvSource({"5, 10, 15", "20, 40, 60"})
    public void should_return_sum_of_two_numbers(int n1, int n2, int expected) {
        ResponseEntity<Integer> responseEntity = restTemplate.getForEntity("/demo/sum/" + n1 + "/" + n2 + ""
                , Integer.class);

        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals(expected, responseEntity.getBody());
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 6", "4, 24", "5, 120"})
    public void should_return_factorial_of_given_number(int number, int expected) {
        ResponseEntity<Integer> responseEntity = restTemplate.getForEntity("/demo/factorial/" + number
                , Integer.class);

        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals(expected, responseEntity.getBody());
    }

}
