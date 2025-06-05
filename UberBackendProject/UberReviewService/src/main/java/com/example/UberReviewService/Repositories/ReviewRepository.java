package com.example.UberReviewService.Repositories;


import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //this annotation automatically create review obj. we dont need to create
public interface ReviewRepository  extends JpaRepository<Review,Long> {

}
