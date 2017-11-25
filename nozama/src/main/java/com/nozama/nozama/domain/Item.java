package com.nozama.nozama.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Item {
    private int itemId;
    private User sellerId;
    private User buyerId;
    private String productName;
    private String description;
    private double price;
    private Date timeToSell;
    private ItemStatus statusId;

    @Id
    @Column
    @GeneratedValue(generator = "ITEMCOUNT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ITEMCOUNT", sequenceName = "ITEMCOUNT",allocationSize=1)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Column
    @ManyToOne
    @JoinColumn(name = "SELLERID", referencedColumnName = "USERID")
    public User getSellerId() {
        return sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }

    @Column
    @ManyToOne
    @JoinColumn(name = "BUYERID", referencedColumnName = "USERID")
    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    @Basic
    @Column
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column
    public Date getTimeToSell() {
        return timeToSell;
    }

    public void setTimeToSell(Date timeToSell) {
        this.timeToSell = timeToSell;
    }


    @Column
    @ManyToOne
    @JoinColumn(name = "STATUSID", referencedColumnName = "STATUSID")
    public ItemStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(ItemStatus statusId) {
        this.statusId = statusId;
    }

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
                '}';
    }
}
