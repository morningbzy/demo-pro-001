package com.example.demoproweb.api;

import com.example.demoprodata.out.utils.Utils;
import com.example.demoprodbwriter.common.TestComponent;
import com.example.demoprodbwriter.data.DemoPro001;
import com.example.demoprodbwriter.data.DemoProRepository;
import com.example.demoproweb.api.requests.TestRequest;
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
@RequestMapping(value = "/")
public class Index {

    @Resource
    TestComponent testComponent;

    @Resource
    DemoProRepository repository;

    @RequestMapping(value = "/test/component")
    public String testComponent() {
        return testComponent.testComponent();
    }


    @RequestMapping(value = "/test")
    public String test() {
        repository.findAll().forEach(i -> log.info(i.getName()));
        DemoPro001 entity = new DemoPro001();
        entity.setName("test");
        repository.saveAndFlush(entity);
        return Utils.dateString();
    }

    @RequestMapping(value = "/test01", method = RequestMethod.POST)
    public String test01(@RequestBody TestRequest request) {
        return "Today: " + request.getT() + Utils.dateString();
    }
}
