package com.example.demoproweb.api;

import com.example.demoproweb.api.requests.LoginRequest;
import com.example.demoproweb.api.requests.TestRequest;
import com.example.demoproweb.common.BaseResponse;
import com.example.demoproweb.jpa.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Slf4j
@Controller
@ResponseBody
@RequestMapping(value = "/api")
public class Index extends AbstractBaseApi {

    @Resource
    UserRepository repository;

    @RequestMapping(value = "/test/component")
    public String testComponent() {
        return "...";
    }


    @RequestMapping(value = "/test")
    public String test() {
        repository.findAll().forEach(i -> log.info(i.getAccount()));
        return "test";
    }

    @RequestMapping(value = "/test01", method = RequestMethod.POST)
    public String test01(@RequestBody TestRequest request) {
        return "Today: " + request.getT();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse<Object> login(@RequestBody LoginRequest request) {
        log.info(request.getUsername());
        log.info(request.getPassword());

        return BaseResponse.success();
    }
}
