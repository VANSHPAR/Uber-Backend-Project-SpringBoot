package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Bookingreview")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Identity means auto_increment
    Long id;
    @Column(nullable = false)
    String content;

    Double rating;
}
