package com.nozama.nozama.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ITEM")
public class Item {
    private Integer itemId;
    private Integer sellerId;
    private Integer buyerId;
    private String productName;
    private String description;
    private Double price;
    private Date timeToSell;
    private Integer statusId;
    private String pictureUrl;

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


    @Column(name="SELLERID")
    @Basic
//    @ManyToOne
//    @JoinColumn(name = "SELLERID", referencedColumnName = "USERID")
    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }


    @Column(name="BUYERID")
    @Basic
//    @ManyToOne
//    @JoinColumn(name = "BUYERID", referencedColumnName = "USERID")
    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
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
                '}';
    }
}
