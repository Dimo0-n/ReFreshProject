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

    public Cart getCartById(Long id) {
        // Returnează coșul pe baza id-ului
        return cartRepository.findById(id).orElse(null);
    }

    public void updateQuantity(Long id, int quantity) {
        Cart cart = getCartById(id);
        cart.setQuantity(quantity);
        cart.setTotal(cart.getPrice() * quantity); // Actualizează prețul total
        cartRepository.save(cart);
    }


    // Găsește produsul din coș pe baza utilizatorului și a produsului
    public Cart getCartByUserIdAndProductId(Long userId, Long productId) {
        return cartRepository.findByUserIdAndProductId(userId, productId);
    }

    // Metodă pentru ștergerea unui produs din coș
    public void removeProductFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
