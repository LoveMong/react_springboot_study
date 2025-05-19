package com.jy.study.mapper.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    int memberCountById(String memberId);

}
