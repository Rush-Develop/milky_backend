package com.example.repository;

import com.example.dto.MemberTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HomeMapperInter {

    @Select("select name, goon, point from member order by point desc limit 5")
    List<MemberTO> findMemberOrderByPoint();
}
