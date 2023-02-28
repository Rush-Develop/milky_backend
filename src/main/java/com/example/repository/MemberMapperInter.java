package com.example.repository;

import com.example.dto.MemberTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapperInter {

    @Insert("insert into member values (#{id},#{name},#{age},#{birth},#{email},#{password},#{goon},#{role},#{point},#{avatar})")
    int saveMember(MemberTO to);

    @Select("select * from member where name = #{username}")
    MemberTO checkMemberInfo(String username);

    @Select("select id, name, age, birth, email, goon, role, point, avatar from member where id = #{id}")
    MemberTO findOneById(String id);

    @Select("select id, name, age, birth, email, goon, role, point, avatar from member where id = #{id}")
    MemberTO checkMemberInfoOauth(String id);

    @Update("update member set avatar = #{avatar} where id = #{id}")
    int updateAvatar(String id, String avatar);

    @Update("update member set goon = #{goon}, age = #{age}, name = #{name} where id = #{id}")
    int updateMemberInfoById(String goon, String age, String name, String id);

}
