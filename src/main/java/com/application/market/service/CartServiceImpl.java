package com.application.market.service;

import com.application.market.entity.Cart;
import com.application.market.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getCartsItemsByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Double getTotalPrice() {
        return cartRepository.getTotalPrice();
    }

}
