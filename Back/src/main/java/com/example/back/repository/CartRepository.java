package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}