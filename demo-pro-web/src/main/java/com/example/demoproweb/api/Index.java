package com.example.demoproweb.api;

import com.example.demoprodata.out.utils.Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class Index {

    @RequestMapping(value = "/test")
    public String test() {
        return Utils.dateString();
    }

    @RequestMapping(value = "/test01")
    public String test01() {
        return "Today: " + Utils.dateString();
    }
}
