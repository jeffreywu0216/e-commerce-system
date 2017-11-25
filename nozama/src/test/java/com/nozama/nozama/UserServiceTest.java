package com.nozama.nozama;

import com.nozama.nozama.dao.UserDao;
import com.nozama.nozama.domain.User;
import com.nozama.nozama.service.UserService;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserService userService;
    private UserDao userDao;
    private User user;

    @Before
    public void setupMock() {
        userService = new UserService();
        user = mock(User.class);
        userDao = mock(UserDao.class);
        userService.setDao(userDao);
    }

    @Test
    public void shouldReturnUser_whenGetUserByEmailIsCalled() {
        when(userDao.findByEmail("abc@def.com")).thenReturn(user);
        User retrievedUser = userService.getUserByEmail("abc@def.com");
        assertThat(retrievedUser, is(equalTo(user)));
    }
}
