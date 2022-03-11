package com.example.imageshop.service;

import com.example.imageshop.dto.CodeLabelValue;

import java.util.List;

public interface CodeService {

    List<CodeLabelValue> getCodeGroupList() throws Exception;

    List<CodeLabelValue> getCodeList(String classCode) throws Exception;
}
