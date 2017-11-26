package com.nozama.nozama.dao;

import com.nozama.nozama.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {
    public List<Item> findByStatusId(Integer statusId);
    public List<Item> findByDescriptionContaining (String s);
    public List<Item> findBySellerId(Integer sellerId);
    public List<Item> findBySellerIdAndStatusId(Integer sellerId, Integer statusId);
    public List<Item> findByBuyerId(Integer buyerId);

    @Transactional
    public void deleteByItemId(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Item SET buyerId = ?1, statusId = 2 WHERE itemId IN (SELECT itemId FROM ShoppingCart WHERE buyerId = ?1)")
    public void setBuyer(Integer buyerId);

}
