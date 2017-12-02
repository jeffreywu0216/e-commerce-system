package com.nozama.nozama.dao;

import com.nozama.nozama.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

    @Modifying
//    @Transactional
    @Query("UPDATE User SET buyerId = ?1, statusId = 2 WHERE itemId IN (SELECT itemId FROM ShoppingCart WHERE buyerId = ?1)")
    void setBuyer(Integer buyerId);

}
