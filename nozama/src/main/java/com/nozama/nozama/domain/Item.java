package com.nozama.nozama.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.File;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="ITEM")
public class Item {
    private Integer itemId;
    private User sellerId;
    private User buyerId;
    private String productName;
    private String description;
    private Double price;
    private Date timeToSell;
    private Integer statusId;
    private String pictureUrl;
    private String picture;
    @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL)
    private Set<ShoppingCart> shoppingCartSet;
//    private Set<ProductReview> productReviewSet;

    public Item() {
    }

    @Id
    @Column(name="ITEMID")
    @GeneratedValue(generator = "ITEMCOUNT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ITEMCOUNT", sequenceName = "ITEMCOUNT",allocationSize=1)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }


//    @Column(name="SELLERID")
//    @Basic
    @ManyToOne
    @JoinColumn(name = "SELLERID", referencedColumnName = "USERID")
//    @JsonBackReference
    public User getSellerId() {
        return sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }


//    @Column(name="BUYERID")
//    @Basic
    @ManyToOne
    @JoinColumn(name = "BUYERID", referencedColumnName = "USERID")
//    @JsonBackReference
    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    @Basic
    @Column(name="PRODUCTNAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name="PRICE")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name="TIMETOSELL", updatable = false, insertable = false)
    public Date getTimeToSell() {
        return timeToSell;
    }

    public void setTimeToSell(Date timeToSell) {
        this.timeToSell = timeToSell;
    }


    @Column(name="STATUSID", insertable = false, updatable = false)
    @Basic
//    @ManyToOne
//    @JoinColumn(name = "STATUSID", referencedColumnName = "STATUSID")
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Column(name="PICTUREURL")
    @Basic
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Transient
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

//    @OneToMany(mappedBy = "itemId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    public Set<ShoppingCart> getShoppingCartSet() {
//        return shoppingCartSet;
//    }
//
//    public void setShoppingCartSet(Set<ShoppingCart> shoppingCartSet) {
//        this.shoppingCartSet = shoppingCartSet;
//    }
//
//    @OneToMany(mappedBy = "itemId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    public Set<ProductReview> getProductReviewSet() {
//        return productReviewSet;
//    }
//
//    public void setProductReviewSet(Set<ProductReview> productReviewSet) {
//        this.productReviewSet = productReviewSet;
//    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", sellerId=" + sellerId +
                ", buyerId=" + buyerId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", timeToSell=" + timeToSell +
                ", statusId=" + statusId +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
