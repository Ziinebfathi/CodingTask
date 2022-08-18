package com.onlineshop.service;

import com.onlineshop.domain.Item;
import com.onlineshop.domain.OrderSummary;
import com.onlineshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository repository;

    @Override
    public OrderSummary orderSummary(List<String> itemList) {
        boolean isOrange = itemList.contains("Orange");
        boolean isApple = itemList.contains("Apple");
//        double priceForOrange = 0;
//        double priceForApple = 0;
        double totalPrice = 0;

        double priceForOrange = 0.25;
        double priceForApple = 0.60;

        //find for price from repo
//        if (isOrange) {
//            Item orange = repository.findByName("Orange");
//            priceForOrange = orange.getPrice();
//        }
//        if (isApple) {
//            Item apple = repository.findByName("Apple");
//            priceForApple = apple.getPrice();
//        }

        long countOfApple = itemList.stream().filter(item -> item.equalsIgnoreCase("Apple")).count();
        long countOfOrange = itemList.stream().filter(item -> item.equalsIgnoreCase("Orange")).count();


        totalPrice =  (countOfApple*priceForApple)+ (countOfOrange*priceForOrange);

        OrderSummary orderSummary = new OrderSummary(itemList,totalPrice);

        return orderSummary;
    }
}
