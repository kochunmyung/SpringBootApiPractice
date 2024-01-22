package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
//GET은 RequestParam POST는 RequestBody
@RestController
@RequestMapping("/postapi")
public class PostApiController {
    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto postRequestDto){
        System.out.println(postRequestDto.toString());
    }

}
