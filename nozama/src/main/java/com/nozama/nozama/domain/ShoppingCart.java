package com.nozama.nozama.domain;

import javax.persistence.*;

@Entity
@Table
public class ShoppingCart {
    private Integer shoppingCartId;
    private Integer buyerId;
    private Item itemId;

    @Id
    @Column
    @GeneratedValue(generator = "SHOPPINGCARTCOUNT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SHOPPINGCARTCOUNT", sequenceName = "SHOPPINGCARTCOUNT",allocationSize=1)
    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    @Basic
    @Column
    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    @Column
    @ManyToOne
    @JoinColumn(name = "ITEMID", referencedColumnName = "ITEMID")
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
