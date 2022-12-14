package com.onlineshop.service;

import com.onlineshop.domain.OrderSummary;
import com.onlineshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderSummary orderSummary(List<String> itemList) {

        double totalPrice = 0;

        double priceForOrange = 0.25;
        double priceForApple = 0.60;


        long countOfApple = itemList.stream().filter(item -> item.equalsIgnoreCase("Apple")).count();
        long countOfOrange = itemList.stream().filter(item -> item.equalsIgnoreCase("Orange")).count();


        //with deal
        double applePriceWithDeal = appleDeal(countOfApple, priceForApple);
        double orangePriceWithDeal = orangeDeal(countOfOrange, priceForOrange);

        //send this as response when deal available
        double totalPriceWithDeal = applePriceWithDeal + orangePriceWithDeal;

        OrderSummary orderSummary = new OrderSummary(1l,itemList,totalPriceWithDeal);

        return orderSummary;
    }

    @Override
    public Optional<OrderSummary> getParticularOrder(Long id) {
          return orderRepository.findById(id);
    }

    @Override
    public List<OrderSummary> getAllOrders() {
        return orderRepository.findAll();
    }


    private double appleDeal(long count, double unitPrice) {
        if (count == 1) {
            return unitPrice;
        } else if (count % 2 == 0) {
            return (count * unitPrice) / 2;
        } else {
            return ((count - 1) * unitPrice)/2 + unitPrice;
        }
    }

    private double orangeDeal(long count, double unitPrice) {
        if (count < 3) {
            return count * unitPrice;
        } else if (count % 3 == 0) {
            return ((count/3)*2)*unitPrice;
        } else {
            return  ((count/3)*2)*unitPrice + (count%3)*unitPrice;
        }

    }
}
