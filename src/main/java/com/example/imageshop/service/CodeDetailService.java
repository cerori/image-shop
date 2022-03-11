package com.example.imageshop.service;

import com.example.imageshop.domain.CodeDetail;

import java.util.List;

public interface CodeDetailService {

    // 등록
    public void register(CodeDetail codeDetail) throws Exception;

    // 상세 조회
    public CodeDetail read(CodeDetail codeDetail) throws Exception;

    // 수정
    public void modify(CodeDetail codeDetail) throws Exception;

    // 삭제
    public void remove(CodeDetail codeDetail) throws Exception;

    // 목록 조회
    public List<CodeDetail> list() throws Exception;
}
