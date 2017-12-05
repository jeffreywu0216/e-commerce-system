package com.nozama.nozama.dao;

import com.nozama.nozama.domain.Item;
import com.nozama.nozama.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {

    List<Item> findByStatusId(Integer statusId);
    List<Item> findByStatusIdAndDescriptionContaining (Integer id, String s);
    List<Item> findByStatusIdAndProductNameContaining (Integer id, String s);
    List<Item> findBySellerId(User sellerId);
    List<Item> findBySellerIdAndStatusId(User sellerId, Integer statusId);
    List<Item> findByBuyerId(User buyerId);

    @Transactional
    void deleteByItemId(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Item SET buyerId = ?1, statusId = 2 WHERE itemId IN (SELECT itemId FROM ShoppingCart WHERE buyerId = ?1)")
    void setBuyer(User buyerId);


}
