package com.nozama.nozama.domain;

import com.amazonaws.services.storagegateway.model.CachediSCSIVolume;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "SHOPPINGCART")
public class ShoppingCart {
    private Integer shoppingCartId;
    private User buyerId;
    private Item itemId;

    @Id
    @Column(name = "SHOPPINGCARTID")
    @GeneratedValue(generator = "SHOPPINGCARTCOUNT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SHOPPINGCARTCOUNT", sequenceName = "SHOPPINGCARTCOUNT",allocationSize=1)
    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

//    @Basic
//    @Column(name = "BUYERID")
    @ManyToOne
    @JoinColumn(name = "BUYERID", referencedColumnName = "USERID")
//    @JsonBackReference
    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }


//    @Column(name = "ITEMID")
//    @Basic
    @ManyToOne
    @JoinColumn(name = "ITEMID", referencedColumnName = "ITEMID")
//    @JsonBackReference
    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartId=" + shoppingCartId +
                ", buyerId=" + buyerId +
                ", itemId=" + itemId +
                '}';
    }
}
