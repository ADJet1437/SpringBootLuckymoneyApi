package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * RequestMapping supports GET and Post
 */


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private ManiConfig maniConfig;


    @GetMapping("/hello1")
    public String hello(){
        return maniConfig.getDescription();
    }

    @GetMapping("/say/{something}")
    public String sayString(@PathVariable("something") String something){
        return something;
    }

    @GetMapping("/{id}")
    public int sayInteger(@PathVariable("id") Integer id){
        return id;
    }

    @GetMapping("/say2")
    public String sayString2(@RequestParam(value = "s", required = false, defaultValue = "") String s){
        /**
         * Need to pass param with ?s="something"
         * s is not required
         */
        return s;
    }
}
