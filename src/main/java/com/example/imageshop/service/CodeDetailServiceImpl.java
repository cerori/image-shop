package com.example.imageshop.service;

import com.example.imageshop.domain.CodeDetail;
import com.example.imageshop.domain.CodeDetailId;
import com.example.imageshop.repository.CodeDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class CodeDetailServiceImpl implements CodeDetailService {

    private final CodeDetailRepository repository;

    @Override
    public void register(CodeDetail codeDetail) throws Exception {
        String groupCode = codeDetail.getGroupCode();
        List<Object[]> rsList = repository.getMaxSortSeq(groupCode);

        Integer maxSortSeq = 0;
        if (rsList.size() > 0) {
            Object[] maxValues = rsList.get(0);
            System.out.println(maxValues);
            if (maxValues != null && maxValues.length > 0) {
                maxSortSeq = (Integer) maxValues[0];
            }
        }

        codeDetail.setSortSeq(maxSortSeq + 1);

        repository.save(codeDetail);
    }

    @Override
    public CodeDetail read(CodeDetail codeDetail) throws Exception {
        CodeDetailId codeDetailId = new CodeDetailId();
        codeDetailId.setGroupCode(codeDetail.getGroupCode());
        codeDetailId.setCodeValue(codeDetail.getCodeValue());

        return repository.getById(codeDetailId);
    }

    @Override
    public void modify(CodeDetail codeDetail) throws Exception {
        CodeDetailId codeDetailId = new CodeDetailId();
        codeDetailId.setGroupCode(codeDetail.getGroupCode());
        codeDetailId.setCodeValue(codeDetail.getCodeValue());

        CodeDetail codeDetailEntity = repository.getById(codeDetailId);

        codeDetailEntity.setCodeValue(codeDetail.getCodeValue());
        codeDetailEntity.setCodeName(codeDetail.getCodeName());

        repository.save(codeDetailEntity);
    }

    @Override
    public void remove(CodeDetail codeDetail) throws Exception {
        CodeDetailId codeDetailId = new CodeDetailId();
        codeDetailId.setGroupCode(codeDetail.getGroupCode());
        codeDetailId.setCodeValue(codeDetail.getCodeValue());

        repository.deleteById(codeDetailId);
    }

    @Override
    public List<CodeDetail> list() throws Exception {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "groupCode", "codeValue"));
    }
}
