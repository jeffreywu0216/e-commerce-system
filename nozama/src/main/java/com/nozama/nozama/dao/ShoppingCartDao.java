package com.nozama.nozama.dao;

import com.nozama.nozama.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Integer> {
    List<ShoppingCart> findByBuyerId(Integer buyerId);
    void deleteByShoppingCartId(Integer id);
    void deleteAllByBuyerId(Integer id);
}
