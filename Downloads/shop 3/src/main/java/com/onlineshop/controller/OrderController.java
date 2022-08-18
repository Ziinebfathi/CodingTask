package com.onlineshop.controller;

import com.onlineshop.domain.OrderSummary;
import com.onlineshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    ResponseEntity<OrderSummary> receivedOrder(@RequestBody List<String> itemList) {
        OrderSummary orderSummary = orderService.orderSummary(itemList);
        return new ResponseEntity<>(orderSummary, HttpStatus.OK);
    }
}
