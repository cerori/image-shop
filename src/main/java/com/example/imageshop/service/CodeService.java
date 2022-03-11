package com.example.imageshop.service;

import com.example.imageshop.dto.CodeLabelValue;

import java.util.List;

public interface CodeService {

    public List<CodeLabelValue> getCodeGroupList() throws Exception;

}
