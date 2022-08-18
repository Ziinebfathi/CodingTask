package com.onlineshop.service;

import com.onlineshop.domain.OrderSummary;
import com.onlineshop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    OrderService orderService = new OrderServiceImpl();


    @Test
    void return_total_cost_of_order() {


        List<String> itemList = new ArrayList<>();
        String item1 = "Apple";
        String item2 = "Orange";

        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item2);
        itemList.add(item2);

        OrderSummary orderSummary = orderService.orderSummary(itemList);
        double expectedDealPriceForOrange = 0.50;
        double expectedDealPriceForApple = 0.60;
        double expectedPrice = expectedDealPriceForApple+expectedDealPriceForOrange;
        assertEquals(expectedPrice, orderSummary.getTotalPrice());
    }

}