package com.application.market.controller;

import com.application.market.entity.Cart;
import com.application.market.entity.Checkout;
import com.application.market.entity.Product;
import com.application.market.repository.CheckoutRepository;
import com.application.market.repository.ProductRepository;
import com.application.market.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/purchase{id}")
    public String showCheckoutPage(@PathVariable Long id, Model model) {
        // Preluarea articolelor din coș după id-ul coșului
        Cart cart = cartService.getCartById(id);

        Checkout checkout = new Checkout();

        if (cart != null) {
            model.addAttribute("cart", cart);
            model.addAttribute("checkout", checkout);
        } else return "redirect:/404";

        return "checkout"; // Redirecționarea către pagina de checkout
    }

    @PostMapping("/submitCheckout")
    public String handleCheckout(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam(value = "personal", required = false) String personal,
            @RequestParam(value = "locationVanzator", required = false) String locationVanzator,
            @RequestParam(value = "livrare", required = false) String livrare,
            @RequestParam(value = "locationCumparator", required = false) String locationCumparator,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("email") String email,
            @RequestParam(value = "orderNotes", required = false) String orderNotes,
            @RequestParam(value = "paymentCash", required = false) String paymentCash,
            @RequestParam(value = "paymentOnline", required = false) String paymentOnline,
            @RequestParam(value = "productId", required = false) Long productId,
            Model model) {

        Checkout checkout = new Checkout();

        if (productId != null) {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            checkout.setProduct(product);
        }

        checkout.setName(name);
        checkout.setSurname(surname);
        checkout.setPhoneNumber(phoneNumber);
        checkout.setEmail(email);
        checkout.setOrderNotes(orderNotes);

        if (personal != null) {
            checkout.setAdresaPreluarePersonala(locationVanzator);
        } else if (livrare != null)
            checkout.setAdresaLivrare(locationCumparator);

        if (paymentCash != null) {
            checkout.setPaymentCash("Cash");
            checkoutRepository.save(checkout);
            return "order-confirmation";
        }

        if (paymentOnline != null)
            return "redirect:/paymentOnline";

        return "thankyou";
    }

}
