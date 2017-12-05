package com.nozama.nozama.dao;

import com.nozama.nozama.domain.User;
import com.nozama.nozama.domain.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewDao extends JpaRepository<UserReview, Integer>{
    List<UserReview> findBySellerId(User sellerId);
}

