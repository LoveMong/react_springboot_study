package com.jy.study.controller;

import com.jy.study.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);


    @Autowired
    MemberService memberService;

    @CrossOrigin(origins = "http://localhost:3000") // React 클라이언트 허용
    @PostMapping("/member/duplicate")
    public String hasMemberId(@RequestBody String memberId) {

        logger.info("memberId : {}" , memberId);

        memberService.hasMemberId(memberId);

        return "hasDataId 접근";
    }

}