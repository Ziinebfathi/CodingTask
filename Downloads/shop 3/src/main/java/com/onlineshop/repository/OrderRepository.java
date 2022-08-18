package com.onlineshop.repository;

import com.onlineshop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Item, Long> {
    @Query
    Item findByName (String name);
}

