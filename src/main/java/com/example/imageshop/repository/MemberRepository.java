package com.example.imageshop.repository;

import com.example.imageshop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m.userNo, m.userId, m.userPw, m.userName, cd.codeName, m.coin, m.regDate " +
            "FROM Member m " +
            "inner join CodeDetail cd on cd.codeValue=m.job " +
            "inner join CodeGroup cg on cg.groupCode=cd.groupCode " +
            "where cg.groupCode='A01' order by m.regDate desc ")
    public List<Object[]> listAllMember();
}
