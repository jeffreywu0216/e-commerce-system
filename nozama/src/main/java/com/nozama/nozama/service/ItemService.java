package com.nozama.nozama.service;

import com.nozama.nozama.dao.ItemDao;
import com.nozama.nozama.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    ItemDao dao;

    @Autowired
    public void setDao (ItemDao dao) {
        this.dao = dao;
    }

    public Item findOne(Integer itemId) {
        return dao.findOne(itemId);
    }

    public List<Item> findByStatusId(Integer statusId) {
        return dao.findByStatusId(statusId);
    }

    public List<Item> findByDescriptionContaining(String word) {
        return dao.findByDescriptionContaining(word);
    }

    public List<Item> findBySellerId(Integer sellerId) {
        return dao.findBySellerId(sellerId);
    }

    public List<Item> findBySellerIdAAndStatusId(Integer sellerId, Integer statusId) {
        return dao.findBySellerIdAndStatusId(sellerId, statusId);
    }

    public List<Item> findByBuyerId(Integer buyerId) {
        return dao.findByBuyerId(buyerId);
    }

    public Item save(Item item) {
        return dao.save(item);
    }

    public void setBuyer(Integer buyerId) {
        dao.setBuyer(buyerId);
    }

    public void deleteByItemId(Integer itemId) {
        dao.deleteByItemId(itemId);
    }
}
