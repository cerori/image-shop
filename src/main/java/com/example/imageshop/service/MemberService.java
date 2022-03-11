package com.example.imageshop.service;

import com.example.imageshop.domain.Member;

import java.util.List;

public interface MemberService {
    Member register(Member member) throws Exception;

    List<Member> list() throws Exception;

    Member read(Long userNo) throws Exception;

    void remove(Long userNo) throws Exception;

    Member modify(Member member);
}
