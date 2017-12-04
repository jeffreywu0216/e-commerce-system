package com.nozama.nozama.dao;

import com.nozama.nozama.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

//    @Transactional
//    void deleteByItemId(Integer id);

    @Modifying
    @Transactional
//    ) u.EMAIL = ?2, u.STREET = ?3, u.CITY = ?4, u.STATE = ?5  WHERE u.USERID = ?6")
    @Query("UPDATE User SET NAME = ?1 WHERE USERID = 51")
    void updateUser(@Param("NAME") String name);

}
