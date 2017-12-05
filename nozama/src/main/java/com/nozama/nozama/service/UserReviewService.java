package com.nozama.nozama.service;

import com.nozama.nozama.dao.UserReviewDao;
import com.nozama.nozama.domain.UserReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
