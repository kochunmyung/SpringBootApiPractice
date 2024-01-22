package com.example.hello.controller;

import ch.qos.logback.core.CoreConstants;
import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path = "/hello") // http:// ~/api/get/hello
    public String Hello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // 모든메소드 다 맵핑 get post put delete ~ api/get/hi
    public String hi(){
        return "Hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    // QueryParameter..! search? << 물음표다음부터 &기준으로 &key = value & key2 = value2
    // http://~/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry-> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+ " " + email+" " + age;
    }

    //물음표 key=value앤
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest)
    {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
