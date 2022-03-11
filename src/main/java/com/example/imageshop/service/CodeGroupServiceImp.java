package com.example.imageshop.service;

import com.example.imageshop.domain.CodeGroup;
import com.example.imageshop.repository.CodeGroupReposigory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CodeGroupServiceImp implements CodeGroupService {

    private final CodeGroupReposigory reposigory;

    @Override
    public void register(CodeGroup codeGroup) throws Exception {
        reposigory.save(codeGroup);
    }

    @Override
    public CodeGroup read(String codeGroup) throws Exception {
        return reposigory.getById(codeGroup);
    }

    @Override
    public void modify(CodeGroup codeGroup) throws Exception {
        CodeGroup foundCodeGroup = reposigory.getById(codeGroup.getGroupCode());
        foundCodeGroup.setGroupName(codeGroup.getGroupName());

        reposigory.save(foundCodeGroup);
    }

    @Override
    public void remove(String codeGroup) throws Exception {
        reposigory.deleteById(codeGroup);
    }

    @Override
    public List<CodeGroup> list() throws Exception {
        return reposigory.findAll(Sort.by(Sort.Direction.DESC, "groupCode"));
    }
}
