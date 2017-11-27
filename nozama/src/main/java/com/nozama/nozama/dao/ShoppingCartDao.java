package com.nozama.nozama.dao;

import com.nozama.nozama.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Integer> {
    List<ShoppingCart> findByBuyerId(Integer buyerId);

    @Transactional
    void deleteByShoppingCartId(Integer id);

//    @Transactional
    void deleteAllByBuyerId(Integer id);
}
