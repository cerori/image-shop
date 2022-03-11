package com.example.imageshop.service;

import com.example.imageshop.domain.CodeDetail;
import com.example.imageshop.domain.CodeGroup;
import com.example.imageshop.dto.CodeLabelValue;
import com.example.imageshop.repository.CodeDetailRepository;
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
    private final CodeDetailRepository codeDetailRepository;

    @Override
    public List<CodeLabelValue> getCodeGroupList() throws Exception {
        List<CodeGroup> codeGroups = repository.findAll(Sort.by(Sort.Direction.ASC, "groupCode"));

        List<CodeLabelValue> codeGroupList = new ArrayList<CodeLabelValue>();

        for (CodeGroup codeGroup : codeGroups) {
            codeGroupList.add(new CodeLabelValue(codeGroup.getGroupCode(), codeGroup.getGroupName()));
        }

        return codeGroupList;
    }

    @Override
    public List<CodeLabelValue> getCodeList(String groupCode) throws Exception {
        List<CodeDetail> codeDetails = codeDetailRepository.getCodeList(groupCode);

        List<CodeLabelValue> codeList = new ArrayList<>();

        for (CodeDetail codeDetail : codeDetails) {
            codeList.add(new CodeLabelValue(codeDetail.getCodeValue(), codeDetail.getCodeName()));
        }
        return codeList;
    }
}
