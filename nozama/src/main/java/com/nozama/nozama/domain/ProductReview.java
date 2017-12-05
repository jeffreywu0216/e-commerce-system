package com.nozama.nozama.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTREVIEW")
public class ProductReview {
    private Integer productReviewId;
    private Item itemId;
    private String productReview;
    private Double rating;

    @Id
    @Column(name = "PRODUCTREVIEWID")
    @GeneratedValue(generator = "PRODUCTREVIEWCOUNT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRODUCTREVIEWCOUNT", sequenceName = "PRODUCTREVIEWCOUNT",allocationSize=1)
    public Integer getProductReviewId() {
        return productReviewId;
    }

    public void setProductReviewId(Integer productReviewId) {
        this.productReviewId = productReviewId;
    }

//    @Basic
//    @Column
    @ManyToOne
    @JoinColumn(name = "ITEMID", referencedColumnName = "ITEMID")
//    @JsonBackReference
    public Item getItemId() {
        return itemId;
    }
    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "PRODUCTREVIEW")
    public String getProductReview() {
        return productReview;
    }

    public void setProductReview(String productReview) {
        this.productReview = productReview;
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
        return "ProductReview{" +
                "productReviewId=" + productReviewId +
                ", itemId=" + itemId +
                ", productReview='" + productReview + '\'' +
                ", rating=" + rating +
                '}';
    }



}
