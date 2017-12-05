package com.nozama.nozama.service;

import com.nozama.nozama.dao.UserReviewDao;
import com.nozama.nozama.domain.User;
import com.nozama.nozama.domain.UserReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewService {
    UserReviewDao dao;
    @Autowired
    public void setDao (UserReviewDao dao){
        this.dao = dao;
    }

    public UserReview save(UserReview userReview){
        return  dao.save(userReview);
    }

    public List<UserReview> findBySellerId(User sellerId) {
        return  dao.findBySellerId(sellerId);
    }
//    public List<ShoppingCart> findByBuyerId(User buyerId) {
//        return dao.findByBuyerId(buyerId);
//    }
}
