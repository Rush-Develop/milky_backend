package com.example.repository;

import com.example.dto.MemberTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapperInter {

    @Insert("insert into member values (0,#{name},#{age},#{birth},#{email},#{password},#{goon},#{role})")
    int saveMember(MemberTO to);

    @Select("select * from member where name = #{username}")
    MemberTO checkMemberInfo(String username);
}
