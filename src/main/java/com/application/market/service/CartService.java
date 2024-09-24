package com.application.market.service;

import com.application.market.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getCartsItemsByUserId(Long id);

    Double getTotalPrice();

    Cart getCartById(Long id);

    void updateQuantity(Long cartId, int quantity);

    Cart getCartByUserIdAndProductId(Long userId, Long productId);

    void removeProductFromCart(Long cartId);

}
