package com.example.imageshop.service;

import com.example.imageshop.domain.CodeGroup;
import com.example.imageshop.dto.CodeLabelValue;
import com.example.imageshop.repository.CodeGroupReposigory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CodeServiceImpl implements CodeService {

    private final CodeGroupReposigory repository;

    @Override
    public List<CodeLabelValue> getCodeGroupList() throws Exception {
        List<CodeGroup> codeGroups = repository.findAll(Sort.by(Sort.Direction.ASC, "groupCode"));

        List<CodeLabelValue> codeGroupList = new ArrayList<CodeLabelValue>();

        for (CodeGroup codeGroup : codeGroups) {
            codeGroupList.add(new CodeLabelValue(codeGroup.getGroupCode(), codeGroup.getGroupName()));
        }

        return codeGroupList;
    }
}
