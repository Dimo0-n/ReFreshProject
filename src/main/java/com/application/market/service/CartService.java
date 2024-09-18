package com.application.market.service;

import com.application.market.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getCartsItemsByUserId(Long id);

    Double getTotalPrice();

}
