package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name="Bookingreview")

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Identity means auto_increment
    private Long id;
    @Column(nullable = false)
    private String content;

    private Double rating;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) //this annotation tells spring to type time
    @CreatedDate //this annotaion tells spring spring that only handle it for object creation
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate//this annotaion tells spring spring that only handle it for object updation
    private Date updatedAt;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", createAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
