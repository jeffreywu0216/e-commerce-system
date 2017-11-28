package com.nozama.nozama.service;

import com.nozama.nozama.dao.UserDao;
import com.nozama.nozama.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserDao dao;

    @Autowired
    public void setDao (UserDao dao){
        this.dao = dao;
    }

    public User getUserByEmail (String email){
        User user = dao.findByEmail(email);
        return user;
    }

    public User getUserById (Integer id){
        User user = dao.findOne(id);
        return user;
    }

    public void insertUser(User user){
        dao.save(user);
    }
}
