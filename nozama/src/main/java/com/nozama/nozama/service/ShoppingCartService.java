package com.nozama.nozama.service;

import com.nozama.nozama.dao.ShoppingCartDao;
import com.nozama.nozama.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    ShoppingCartDao dao;

    @Autowired
    public void setDao(ShoppingCartDao dao) {
        this.dao = dao;
    }

    public List<ShoppingCart> findByBuyerId(Integer buyerId) {
        return dao.findByBuyerId(buyerId);
    }

    public void deleteByShoppingCartId (Integer shoppingCartId) {
        dao.deleteByShoppingCartId(shoppingCartId);
    }

    public ShoppingCart save(ShoppingCart shoppingCart) {
        return dao.save(shoppingCart);
    }

    public void deleteAllByBuyerId(Integer buyerId) {
        dao.deleteAllByBuyerId(buyerId);
    }
}
