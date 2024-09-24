package com.application.market.controller;

import com.application.market.entity.Cart;
import com.application.market.entity.Checkout;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.entity.UserActivity;
import com.application.market.repository.CheckoutRepository;
import com.application.market.repository.ProductRepository;
import com.application.market.repository.UserActivityRepository;
import com.application.market.repository.UserRepository;
import com.application.market.service.CartService;
import com.application.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@SessionAttributes("checkout")
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserActivityRepository userActivityRepository;

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
            @RequestParam(value = "totalPrice") String totalPrice,
            Model model,
            Authentication auth) {

        Checkout checkout = new Checkout();

        if (productId != null) {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            checkout.setProduct(product);
            checkout.setVanzatorId(product.getUser().getId());
        }

        User user = userService.findByEmail(auth.getName());
        Cart cartItem = cartService.getCartByUserIdAndProductId(user.getId(), productId);

        checkout.setCumparatorId(user.getId());
        checkout.setName(name);
        checkout.setSurname(surname);
        checkout.setPhoneNumber(phoneNumber);
        checkout.setEmail(email);
        checkout.setOrderNotes(orderNotes);
        checkout.setTotal(Double.valueOf(totalPrice));

        LocalDateTime now = LocalDateTime.now();

        if (personal != null) {
            checkout.setAdresaPreluarePersonala(locationVanzator);
        } else if (livrare != null)
            checkout.setAdresaLivrare(locationCumparator);

        if (paymentCash != null) {
            checkout.setPaymentCash("Cash");
            checkoutRepository.save(checkout);
            // Log the user's activity as 'PURCHASE'
            if (productId != null) {
                logUserPurchaseActivity(user, productRepository.findById(productId).get());
            }
            cartService.removeProductFromCart(cartItem.getId()); // Șterge produsul din coș
            model.addAttribute("checkout", checkout);
//            model.addAttribute("time", now);
            model.addAttribute("totalPrice", checkout.getTotal());
            return "order-confirmation";
        }

        if (paymentOnline != null) {
            model.addAttribute("checkout", checkout);
            model.addAttribute("totalPrice", checkout.getTotal());
            // Log the user's activity as 'PURCHASE'
            if (productId != null) {
                logUserPurchaseActivity(user, productRepository.findById(productId).get());
            }
            return "redirect:/payment";
        }

        return "index";
    }

    private void logUserPurchaseActivity(User user, Product product) {
        UserActivity activity = new UserActivity();
        activity.setUser(user);
        activity.setProduct(product);
        activity.setActivityType(UserActivity.ActivityType.PURCHASE);  // Set the action as 'PURCHASE'
        activity.setTimestamp(LocalDateTime.now());
        userActivityRepository.save(activity);
    }

    @GetMapping("/payment")
    public String getPaymentPage(Model model) {
        Checkout checkout = (Checkout) model.getAttribute("checkout");
        model.addAttribute("checkout", checkout);
        model.addAttribute("totalPrice", checkout.getTotal());
        return "payment";
    }

    @PostMapping("/payment/verification")
    public String verification(Model model, @ModelAttribute("checkout") Checkout checkout) {

        String securityCode = "000";

        // Verificarea codului de securitate
        if ("000".equals(securityCode)) {
            try {
                checkout.setPaymentOnline("Achitare cu success");
                checkoutRepository.save(checkout);

                model.addAttribute("checkout", checkout);
//                model.addAttribute("time", now);
                model.addAttribute("total", checkout.getTotal());
                return "redirect:/order-confirmation";
            } catch (Exception e) {
                model.addAttribute("error", "A apărut o eroare la salvarea comenzii.");
                return "payment";
            }
        } else {
            model.addAttribute("errorMessage", "Datele cardului sunt incorecte");
            return "payment";
        }
    }

    @GetMapping("/anulare")
    public String failure(){
        return "order-failure";
    }

    @GetMapping("/order-confirmation")
    public String success(Model model, Authentication auth) {
        User user = userService.findByEmail(auth.getName());
        Checkout checkout = (Checkout) model.getAttribute("checkout");

        if (checkout != null) {
            Long productId = checkout.getProduct().getId();

            // Găsește produsul din coș pentru utilizatorul respectiv
            Cart cartItem = cartService.getCartByUserIdAndProductId(user.getId(), productId);

            // Dacă produsul există în coș, șterge-l
            if (cartItem != null) {
                cartService.removeProductFromCart(cartItem.getId());
            }
        }

        model.addAttribute("checkout", checkout);
        return "order-confirmation";
    }


}
