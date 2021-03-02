package com.eunchae.restaurantbooker.application;

import com.eunchae.restaurantbooker.domain.Review;
import com.eunchae.restaurantbooker.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Long restaurantId, String name, Integer score, String description) {
        Review review = Review.builder()
                .restaurantId(restaurantId)
                .name(name)
                .score(score)
                .description(description)
                .build();

        review.setRestaurantId(restaurantId);
        return reviewRepository.save(review);
    }
}