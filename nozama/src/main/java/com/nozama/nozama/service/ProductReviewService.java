package com.nozama.nozama.service;

import com.nozama.nozama.dao.ProductReviewDao;
import com.nozama.nozama.domain.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewService {
    ProductReviewDao dao;

    @Autowired
    public void setDao (ProductReviewDao dao){
        this.dao = dao;
    }

    public ProductReview save(ProductReview productReview){
        return  dao.save(productReview);
    }


}
