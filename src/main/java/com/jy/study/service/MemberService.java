package com.jy.study.service;

public interface MemberService {
    Boolean checkDuplicateMemberId(String memberId);
    String memberCountById(String memberId);
}
