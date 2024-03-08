package com.example.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.entity.Cart;
import com.example.back.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    public void saveCart(Cart cart) {
        cartRepo.save(cart);
    }

}
