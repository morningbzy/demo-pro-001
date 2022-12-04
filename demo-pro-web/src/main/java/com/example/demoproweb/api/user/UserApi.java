package com.example.demoproweb.api.user;

import com.example.demoproweb.api.AbstractBaseApi;
import com.example.demoproweb.api.user.requests.CreateUserRequest;
import com.example.demoproweb.jpa.user.User;
import com.example.demoproweb.service.user.impl.UserService;
import com.example.demoproweb.service.user.iterface.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Slf4j
@Controller
@ResponseBody
@RequestMapping(value = "/user")
public class UserApi extends AbstractBaseApi {

    @Resource
    IUserService userService;

    @RequestMapping(value = "/create")
    public String create(@RequestBody CreateUserRequest request) {
        User result = userService.create(request, request.getAccount(), request.getPassword());
        return "OK. User[ID@" + result.getPk() + "] created.";
    }
}
