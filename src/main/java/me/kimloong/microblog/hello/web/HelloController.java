package me.kimloong.microblog.hello.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例请求
 * Created by Kimloong on 2017-04-24.
 */
@RestController
@RequestMapping
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello by hello";
    }
}
