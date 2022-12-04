package com.example.demoproweb.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@ResponseBody
@RequestMapping(value = "/auth")
public class AuthenticateApi extends AbstractBaseApi {

    @RequestMapping(value = "/login")
    public String login() {
        return "OK";
    }
}
