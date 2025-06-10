package com.example.UberReviewService.Repositories;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {


  Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);


}
