package com.jy.study.controller;

import com.jy.study.domain.member.MemberDto;
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


    @Autowired
    private MemberService memberService;

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);


    @CrossOrigin(origins = "http://localhost:3000") // React 클라이언트 허용
    @PostMapping("/member/duplicate")
    public String getDuplicateCheckMessage(@RequestBody MemberDto memberDto) {
        logger.info("memberId : {}" , memberDto.getId());
        String memberId = memberDto.getId();
        logger.info("return messages : {}" , memberService.memberCountById(memberId));
        return memberService.memberCountById(memberId);
    }

}