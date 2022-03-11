package com.example.imageshop.common.controller;

import com.example.imageshop.service.CodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/codes")
public class CodeController {

    private final CodeService codeService;

    @GetMapping("/codeGroup")
    public ResponseEntity<?> codeGroupList() throws Exception {
        return new ResponseEntity<>(codeService.getCodeGroupList(), HttpStatus.OK);
    }
}
