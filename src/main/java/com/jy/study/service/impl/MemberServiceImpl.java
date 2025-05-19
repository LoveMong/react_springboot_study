package com.jy.study.service.impl;


import com.jy.study.mapper.member.MemberMapper;
import com.jy.study.service.MemberService;
import com.jy.study.utill.MessagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MessagesUtil messagesUtil;


    @Override
    public String memberCountById(String memberId) {
        int membeExistCnt = memberMapper.memberCountById(memberId);
        if(membeExistCnt > 0) {
            return messagesUtil.getMessage("ID_DUPLICATE", null);
        } else {
            return messagesUtil.getMessage("ID_AVAILABLE", null);
        }
    }
}