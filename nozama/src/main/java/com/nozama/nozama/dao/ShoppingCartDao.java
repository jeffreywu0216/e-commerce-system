package com.nozama.nozama.dao;

import com.nozama.nozama.domain.Item;
import com.nozama.nozama.domain.ShoppingCart;
import com.nozama.nozama.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Integer> {
    List<ShoppingCart> findByBuyerId(User buyerId);

    @Transactional
    void deleteByShoppingCartId(Integer id);

    @Transactional
    void deleteByBuyerIdAndItemId(User buyerId, Item itemId);

//    @Transactional
    void deleteAllByBuyerId(User id);
}
