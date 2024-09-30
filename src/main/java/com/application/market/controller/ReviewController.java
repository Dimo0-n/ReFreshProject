package com.application.market.controller;

import com.application.market.entity.Product;
import com.application.market.entity.Review;
import com.application.market.entity.User;
import com.application.market.service.ProductService;
import com.application.market.service.ReviewService;
import com.application.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @PostMapping("/submit-review")
    public String submitReview(@RequestParam Long productId, @RequestParam String comment, @RequestParam int rating, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());

        Product product = productService.findProductById(productId);

        if (user != null && product != null) {
            reviewService.addReview(product, user, comment, rating);
            redirectAttributes.addFlashAttribute("reviewAdded", true);
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding review.");
        }

        return "redirect:/shopDetail-" + productId;
    }

    @PostMapping("/update-review")
    public String updateReview(@RequestParam("reviewId") Long reviewId,
                               @RequestParam("comment") String comment,
                               @RequestParam("rating") int rating,
                               Principal principal) {
        // Get the logged-in user
        User currentUser = userService.findByEmail(principal.getName());

        // Fetch the review by its ID
        Review review = reviewService.findById(reviewId);

        // Ensure that the current user is the one who posted the review
        if (review.getUser().getId().equals(currentUser.getId())) {
            // Update the review
            review.setComment(comment);
            review.setRating(rating);
            reviewService.save(review);
        }

        return "redirect:/shopDetail-" + review.getProduct().getId();
    }

    @PostMapping("/delete-review")
    public String deleteReview(@RequestParam("reviewId") Long reviewId, Principal principal) {
        // Get the logged-in user
        User currentUser = userService.findByEmail(principal.getName());

        // Fetch the review by its ID
        Review review = reviewService.findById(reviewId);

        // Ensure that the current user is the one who posted the review
        if (review.getUser().getId().equals(currentUser.getId())) {
            reviewService.deleteById(reviewId);
        }

        return "redirect:/shopDetail-" + review.getProduct().getId();
    }
}
