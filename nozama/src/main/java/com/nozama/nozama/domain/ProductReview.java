package com.nozama.nozama.domain;

import javax.persistence.*;

@Entity
@Table
public class ProductReview {
    private Integer productReviewId;
    private Integer itemId;
    private String productReview;

    @Id
    @Column
    @GeneratedValue(generator = "PRODUCTREVIEWCOUNT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRODUCTREVIEWCOUNT", sequenceName = "PRODUCTREVIEWCOUNT",allocationSize=1)
    public Integer getProductReviewId() {
        return productReviewId;
    }

    public void setProductReviewId(Integer productReviewId) {
        this.productReviewId = productReviewId;
    }

    @Basic
    @Column
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column
    public String getProductReview() {
        return productReview;
    }

    public void setProductReview(String productReview) {
        this.productReview = productReview;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "productReviewId=" + productReviewId +
                ", itemId=" + itemId +
                ", productReview='" + productReview + '\'' +
                '}';
    }
}
