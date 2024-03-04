package com.jy.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @PostMapping("/member/duplicate")
    public String hasMemberId() {
        System.out.println("hasDataId 접근");
        return "hasDataId 접근";
    }

}
