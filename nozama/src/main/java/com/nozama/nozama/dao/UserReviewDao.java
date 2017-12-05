package com.nozama.nozama.dao;

import com.nozama.nozama.domain.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewDao extends JpaRepository<UserReview, Integer>{
}
