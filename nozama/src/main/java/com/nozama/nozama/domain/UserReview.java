package com.nozama.nozama.domain;

import javax.persistence.*;

@Entity
@Table(name = "USERREVIEW")
public class UserReview {
    private Integer userReviewId;
    private User userId;
    private String userReview;
    private Double rating;

    @Id
    @Column(name = "USERREVIEWID")
    @GeneratedValue(generator = "USERREVIEWCOUNT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USERREVIEWCOUNT", sequenceName = "USERREVIEWCOUNT",allocationSize=1)
    public Integer getUserReviewId() {
        return userReviewId;
    }

    public void setUserReviewId(Integer userReviewId) {
        this.userReviewId = userReviewId;
    }


    //    @Basic
//    @Column
    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USERREVIEW")
    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }




    @Basic
    @Column
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "UserReview{" +
                "userReviewId=" + userReviewId +
                ", userId=" + userId +
                ", userReview='" + userReview + '\'' +
                ", rating=" + rating +
                '}';
    }
}
