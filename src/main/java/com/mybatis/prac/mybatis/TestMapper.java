package com.mybatis.prac.mybatis;



import com.mybatis.prac.vo.testVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {
     void insert(String joinName);

     List<testVo> list();

     String listOne(String findName);
     void update(String updateName , String joinName);

     void delete(String joinName);
}
