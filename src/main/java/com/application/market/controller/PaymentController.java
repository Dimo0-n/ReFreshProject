//package com.application.market.controller;
//
//import com.application.market.entity.Checkout;
//import com.application.market.repository.CheckoutRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//
//@Controller
//@RestController("/payment")
//public class PaymentController {
//
//    @Autowired
//    CheckoutRepository checkoutRepository;
//
//    @GetMapping("")
//    public String getPaymentPage(Model model) {
//        Checkout checkout = (Checkout) model.getAttribute("checkout");
//        model.addAttribute("checkout", checkout);
//        return "payment";
//    }
//
//    @PostMapping("/payment/verification")
//    public boolean verification(@RequestParam("fullName") String fullName,
//                               @RequestParam("cardNumber") String cardNumber,
//                               @RequestParam("expirationdate") String expirationDate,
//                               @RequestParam("securityCode") String securityCode,
//                                Model model) {
//
//        if (securityCode.equals("000")){
//            return true;
//        }
//        else
//            return false;
//
//    }
//
//
//
//}
