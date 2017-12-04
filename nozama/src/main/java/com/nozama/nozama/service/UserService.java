package com.nozama.nozama.service;

import com.nozama.nozama.dao.UserDao;
import com.nozama.nozama.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserDao dao;

    @Autowired
    public void setDao (UserDao dao){
        this.dao = dao;
    }

    public List<User> getAllUsers() {
        return dao.findAll();
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

//    String email, String street, String city, String state, Integer id){
    public void updateUser(String name, String email, Long phone, String street, String city, String state, Integer userid){
        dao.updateUser(name, email, phone, street, city, state, userid);
    }
}
