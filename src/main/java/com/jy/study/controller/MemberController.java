package com.jy.study.controller;

import com.jy.study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/member/duplicate")
    public String hasMemberId(String memberId) {
        System.out.println("hasDataId 접근");

        memberService.hasMemberId(memberId);

        return "hasDataId 접근";
    }

}
