package com.nozama.nozama.dao;

import com.nozama.nozama.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {

    List<Item> findByStatusId(Integer statusId);
    List<Item> findByProductNameContainingAndDescriptionContaining (String s1, String s2);
    List<Item> findBySellerId(Integer sellerId);
    List<Item> findBySellerIdAndStatusId(Integer sellerId, Integer statusId);
    List<Item> findByBuyerId(Integer buyerId);

    @Transactional
    void deleteByItemId(Integer id);

    @Modifying
//    @Transactional
    @Query("UPDATE Item SET buyerId = ?1, statusId = 2 WHERE itemId IN (SELECT itemId FROM ShoppingCart WHERE buyerId = ?1)")
    void setBuyer(Integer buyerId);

}
