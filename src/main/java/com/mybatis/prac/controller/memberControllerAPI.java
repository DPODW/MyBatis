package com.mybatis.prac.controller;

import com.mybatis.prac.mybatis.TestMapper;
import com.mybatis.prac.vo.testVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/API")
public class memberControllerAPI {
    private final TestMapper testMapper;

    @PostMapping("/1")
    public String insert(@RequestBody testVo testVo1){
        log.info("{}",testVo1);
        JSONObject jsonObject = new JSONObject(testVo1);
        log.info("{}",testVo1);
        String joinName = jsonObject.getString("joinName");
        log.info("API 입력 정상 작동");
        testMapper.insert(joinName);
        return "OK";
    }
}
