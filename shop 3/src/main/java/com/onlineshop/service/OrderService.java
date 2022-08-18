package com.onlineshop.service;

import com.onlineshop.domain.Item;
import com.onlineshop.domain.OrderSummary;

import java.util.List;

public interface OrderService {
    public OrderSummary orderSummary (List<String> itemList);
}
