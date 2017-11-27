package com.nozama.nozama.domain;

import javax.persistence.*;

@Entity
@Table(name = "SHOPPINGCART")
public class ShoppingCart {
    private Integer shoppingCartId;
    private Integer buyerId;
    private Integer itemId;

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

    @Basic
    @Column(name = "BUYERID")
    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    @Column(name = "ITEMID")
    @Basic
//    @ManyToOne
//    @JoinColumn(name = "ITEMID", referencedColumnName = "ITEMID")
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
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
