package com.onlineshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class OrderSummary {
    List<String> itemList;
    double totalPrice;
}
