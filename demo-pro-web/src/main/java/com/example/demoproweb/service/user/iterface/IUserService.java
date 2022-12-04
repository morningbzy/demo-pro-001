package com.example.demoproweb.service.user.iterface;

import com.example.demoproweb.common.AbstractBaseRequest;
import com.example.demoproweb.jpa.user.User;

public interface IUserService {
    User create(AbstractBaseRequest request, String account, String password);
}
