package com.jy.study.controller;

import com.jy.study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @CrossOrigin(origins = "http://localhost:3000") // React 클라이언트 허용
    @PostMapping("/member/duplicate")
    public String hasMemberId(String memberId) {
        System.out.println("hasDataId 접근");

        memberService.hasMemberId(memberId);

        return "hasDataId 접근";
    }

}