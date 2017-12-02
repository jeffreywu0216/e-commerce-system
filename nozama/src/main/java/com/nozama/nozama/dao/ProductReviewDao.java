package com.nozama.nozama.dao;

import com.nozama.nozama.domain.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewDao extends JpaRepository<ProductReview, Integer>{
}
