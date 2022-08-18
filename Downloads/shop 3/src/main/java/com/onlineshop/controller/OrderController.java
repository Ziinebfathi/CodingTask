package com.onlineshop.controller;

import com.onlineshop.domain.OrderSummary;
import com.onlineshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    ResponseEntity<?> getOneOder (@PathVariable Long id)  {
          Optional<OrderSummary> orderSummary = orderService.getParticularOrder(id);
        return new ResponseEntity<>(orderSummary, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<OrderSummary>> getAllOrders ()  {
        List<OrderSummary> orderSummaryList = orderService.getAllOrders();
        return new ResponseEntity<>(orderSummaryList, HttpStatus.OK);
    }

    @PostMapping("/placeOrder")
    ResponseEntity<OrderSummary> receivedOrder(@RequestBody List<String> itemList) {
        OrderSummary orderSummary = orderService.orderSummary(itemList);
        return new ResponseEntity<>(orderSummary, HttpStatus.OK);
    }
}
