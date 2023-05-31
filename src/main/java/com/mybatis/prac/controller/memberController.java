package com.mybatis.prac.controller;

import com.mybatis.prac.mybatis.TestMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/test")
public class memberController {

    private final TestMapper testMapper;

    @GetMapping("/get")
    public String home(){
        return "home";
    }


    @PostMapping("/post")
    public void home(@RequestParam String joinName){
        testMapper.insert(joinName);
        log.info("저장 완료. H2 DB 새로 고침을 해보세요");
    }

    @GetMapping("/get1")
    public String home1(){
        List list = new ArrayList<>(testMapper.list());
        log.info("DB에 저장된 전체 컬럼 조회 완료. 아래 로그를 확인하세요");
        log.info("{}", list);
        return "home1";
    }

    @GetMapping("/getOne/{findName}")
    public String listOne(@PathVariable String findName){
        String listOne = testMapper.listOne(findName);
        log.info("DB에 저장된 특정 컬럼 조회 완료. 아래 로그를 확인하세요");
        log.info("{}",listOne);
        return "home1";
    }


    @GetMapping("/update/{updateName}/{joinName}")
    public void update(@PathVariable String updateName
                        ,@PathVariable String joinName){
        testMapper.update(updateName,joinName);
        log.info("수정 완료. H2 DB 새로 고침을 해보세요");
    }

    @GetMapping("/delete/{joinName}")
    public void delete(@PathVariable String joinName){
        testMapper.delete(joinName);
        log.info("삭제 완료. H2 DB 새로 고침을 해보세요");
    }

}
