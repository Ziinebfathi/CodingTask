package com.onlineshop.service;

import com.onlineshop.domain.OrderSummary;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public OrderSummary orderSummary (List<String> itemList);
    public Optional<OrderSummary> getParticularOrder (Long id);
    public List<OrderSummary> getAllOrders ();
}
