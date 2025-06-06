package com.example.UberReviewService.Services;

import com.example.UberReviewService.Repositories.ReviewRepository;
import com.example.UberReviewService.models.Review;
import org.apache.catalina.LifecycleState;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************");
        Review r=Review.builder()
                .content("Amazing service!!!!!!").rating(11.5).build();
        System.out.println(r);
        reviewRepository.save(r);//executes sql query

        List<Review> reviews=reviewRepository.findAll();
        for(Review review:reviews){
            System.out.println(review.getContent());
        }
    //    reviewRepository.deleteById(3L);
    }
}
