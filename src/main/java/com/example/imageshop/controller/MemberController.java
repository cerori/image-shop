package com.example.imageshop.controller;

import com.example.imageshop.domain.Member;
import com.example.imageshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class MemberController {

    private final MemberService service;

    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> register(@Validated @RequestBody Member member) throws Exception {

        String inputPassword = member.getUserPw();
        member.setUserPw(passwordEncoder.encode(inputPassword));

        service.register(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> list() throws Exception {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{userNo}")
    public ResponseEntity<?> read(@PathVariable("userNo") Long userNo) throws Exception {
        Member member = service.read(userNo);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @DeleteMapping("/{userNo}")
    public ResponseEntity<?> remove(@PathVariable("userNo") Long userNo) throws Exception {
        service.remove(userNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{userNo}")
    public ResponseEntity<?> modify(@PathVariable("userNo") Long userNo, @Validated @RequestBody Member member) throws Exception {

        member.setUserNo(userNo);
        service.modify(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }



}
