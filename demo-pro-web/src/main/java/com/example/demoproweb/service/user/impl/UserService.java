package com.example.demoproweb.service.user.impl;


import com.example.demoproweb.common.AbstractBaseRequest;
import com.example.demoproweb.jpa.user.User;
import com.example.demoproweb.jpa.user.UserRepository;
import com.example.demoproweb.service.user.iterface.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Resource
    protected UserRepository repository;

    @Override
    public User create(AbstractBaseRequest request, String account, String password) {
        User user = new User();
        user.setPk(UUID.randomUUID().toString());
        user.setAccount(account);
        user.setPassword(password);

        return repository.save(user);
    }
}
