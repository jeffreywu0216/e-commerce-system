package com.nozama.nozama.domain;

import javax.persistence.*;

@Entity
@Table(name = "USERREVIEW")
public class UserReview {
    private Integer userReviewId;
    private User buyerId;
    private User sellerId;
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
    @JoinColumn(name = "BUYERID", referencedColumnName = "USERID")
    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    @ManyToOne
    @JoinColumn(name = "SELLERID", referencedColumnName = "USERID")
    public User getSellerId() {
        return sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
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
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                ", userReview='" + userReview + '\'' +
                ", rating=" + rating +
                '}';
    }
}
