package com.example.UberReviewService.Services;

import com.example.UberReviewService.Repositories.BookingRepository;
import com.example.UberReviewService.Repositories.ReviewRepository;
import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import org.apache.catalina.LifecycleState;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public void run(String... args) throws Exception {
//        System.out.println("**************");
//        Review r=Review.builder()
//                .content("Amazing service!!!!!!").rating(11.5).build();
//
//        Booking b=Booking
//                .builder()
//                .review(r)
//                .endTime(new Date())
//                .build();
//
//        bookingRepository.save(b);
//
//        reviewRepository.save(r);//executes sql query
//        System.out.println(r);
//
//
//        List<Review> reviews=reviewRepository.findAll();
//        for(Review review:reviews){
//            System.out.println(review.getContent());
//        }
        Optional<Booking> b=bookingRepository.findById(2L);
        if(b.isPresent()){
            bookingRepository.delete(b.get());
        }
    //    reviewRepository.deleteById(3L);
    }
}
