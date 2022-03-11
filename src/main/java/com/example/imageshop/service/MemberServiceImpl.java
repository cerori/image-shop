package com.example.imageshop.service;

import com.example.imageshop.domain.Member;
import com.example.imageshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;

    @Override
    public Member register(Member member) throws Exception {
        return null;
    }

    @Override
    public List<Member> list() throws Exception {
        return null;
    }

    @Override
    public Member read(Long userNo) throws Exception {
        return null;
    }

    @Override
    public void remove(Long userNo) throws Exception {

    }

    @Override
    public Member modify(Member member) {
        return null;
    }

}
