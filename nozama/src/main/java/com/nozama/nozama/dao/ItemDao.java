package com.nozama.nozama.dao;

import com.nozama.nozama.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {
    List<Item> findByStatusId(Integer statusId);
    List<Item> findByDescriptionContaining (String s);
    List<Item> findBySellerId(Integer sellerId);
    List<Item> findBySellerIdAndStatusId(Integer sellerId, Integer statusId);
    List<Item> findByBuyerId(Integer buyerId);
    void deleteByItemId(Integer id);

    @Query("UPDATE Item SET buyerId = ?1 WHERE itemId = (SELECT itemId FROM ShoppingCart WHERE buyerId = ?1)")
    void setBuyer(Integer buyerId);

}
