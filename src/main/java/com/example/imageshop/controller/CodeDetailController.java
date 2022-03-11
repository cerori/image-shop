package com.example.imageshop.controller;

import com.example.imageshop.service.CodeDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/codedetails")
public class CodeDetailController {

    public final CodeDetailService service;

    @GetMapping("/{groupCode}/{codeValue}")
    public ResponseEntity<?> read(@PathVariable("groupCode") String groupCode, @PathVariable("codeValue") String codeValue) throws Exception {

        return null;

    }
}
