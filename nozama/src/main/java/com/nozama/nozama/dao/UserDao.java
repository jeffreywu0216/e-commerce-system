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

    @Modifying
    @Transactional
    @Query("UPDATE User  SET NAME = :NAME, STREET =:STREET WHERE USERID = 51")
    void updateUser(@Param("NAME") String name, @Param("STREET") String street);

}
