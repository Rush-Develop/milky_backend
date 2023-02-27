package com.example.repository;

import com.example.dto.MemberTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapperInter {

    @Insert("insert into member values (#{id},#{name},#{age},#{birth},#{email},#{password},#{goon},#{role},#{point})")
    int saveMember(MemberTO to);

    @Select("select * from member where name = #{username}")
    MemberTO checkMemberInfo(String username);

    @Select("select id, name, age, birth, email, goon, role, point from member where id = #{id}")
    MemberTO findOneById(String id);
}
