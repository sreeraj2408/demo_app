package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class NumberOperationsController {

    @GetMapping("/sum/{number1}/{number2}")
    public ResponseEntity sumOfNumbers(@PathVariable("number1") int number1, @PathVariable("number2") int number2) {
        return ResponseEntity.ok(number1 + number2);
    }
}
