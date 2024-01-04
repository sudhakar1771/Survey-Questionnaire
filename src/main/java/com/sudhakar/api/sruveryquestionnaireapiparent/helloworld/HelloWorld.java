package com.sudhakar.api.sruveryquestionnaireapiparent.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@Controller
public class HelloWorld {

    @RequestMapping("/helloworld")
    //@ResponseBody
    public String returnhelloworld(){
        return "my first api";
    }

    @RequestMapping("/helloworldbean/{name}/{message}")
    public HelloWorldBean returnbean(@PathVariable Map<String,String> multipleparams){
        String name = multipleparams.get("name");
        String message = multipleparams.get("message");
        return new HelloWorldBean("hello world " + name + " " +message);
    }



}
