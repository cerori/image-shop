package com.example.imageshop.controller;

import com.example.imageshop.domain.CodeGroup;
import com.example.imageshop.service.CodeGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/codegroup")
public class CodeGroupController {

    private final CodeGroupService service;

    @GetMapping("/{groupCode}")
    public ResponseEntity<?> read(@PathVariable("groupCode") String groupCode) throws Exception {
        CodeGroup codeGroup = service.read(groupCode);

        return new ResponseEntity<>(codeGroup, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> list() throws Exception {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> register(@Validated @RequestBody CodeGroup codeGroup) throws Exception {
        log.info("groupCode " + codeGroup.getGroupCode());

        service.register(codeGroup);

        return new ResponseEntity<>(codeGroup, HttpStatus.OK);
    }

    @DeleteMapping("/{groupCode}")
    public ResponseEntity<?> remove(@PathVariable("groupCode") String groupCode) throws Exception {
        service.remove(groupCode);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{groupCode}")
    public ResponseEntity<?> modify(@PathVariable("groupCode") String groupCode, @Validated @RequestBody CodeGroup codeGroup) throws Exception {

        codeGroup.setGroupCode(groupCode);

        service.modify(codeGroup);

        return new ResponseEntity<>(codeGroup, HttpStatus.OK);
    }
}
