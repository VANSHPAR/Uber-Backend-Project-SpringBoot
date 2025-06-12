package com.example.UberReviewService.Services;

import com.example.UberReviewService.Repositories.BookingRepository;
import com.example.UberReviewService.Repositories.DriverRepository;
import com.example.UberReviewService.Repositories.ReviewRepository;
import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.*;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private  final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }


    @Override
    @Transactional
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
//        Optional<Booking> b=bookingRepository.findById(2L);
//        if(b.isPresent()){
//            bookingRepository.delete(b.get());
//        }
//       Optional<Driver> driver=driverRepository.findById(1L);
//
//       if(driver.isPresent()){
//           System.out.println(driver.get().getName() );
//
//           List<Booking> b=driver.get().getBookings();
//               for(Booking booking:b){
//               System.out.println(booking.getId());
//               }
//           List<Booking> b=bookingRepository.findAllByDriverId(1L);
//           for(Booking booking:b){
//               System.out.println(booking.getBookingStatus());
//           }
//       }
    //   Optional<Booking> b=bookingRepository.findById(1L);


    //    reviewRepository.deleteById(3L);
//    Optional<Driver> d=driverRepository.rawfindByIdAndLicenseNumber(1L,"Gj061234");
//        System.out.println(d.get().getName());
//        Optional<Driver> d=driverRepository.hqlFindByIdAndLicense(1L,"Gj061234");
//        System.out.println(d.get().getName());
      List<Long> driver_ids=new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L,6L));
      List<Driver> drivers=driverRepository.findAllByIdIn(driver_ids);

    // List<Booking> bookings=bookingRepository.findAllByDriverIn(drivers);  //solution of fetch n+1 query  problem using hibernate
        for(Driver d:drivers){ //solution of fetch n+1 query  problem using fetch mode subselect, it executes only 1 query for n number of drivers
            List<Booking> bookings=d.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }
    }
}
