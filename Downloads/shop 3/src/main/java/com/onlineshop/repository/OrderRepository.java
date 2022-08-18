package com.onlineshop.repository;

import com.onlineshop.domain.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderSummary, Long> {
}
