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

    @Insert("insert into member values (#{id},#{name},#{age},#{birth},#{email},#{password},#{goon},#{role},#{point},#{avatar},#{pcolor})")
    int saveMember(MemberTO to);

    @Select("select * from member where name = #{username}")
    MemberTO checkMemberInfo(String username);

    @Select("select id, name, age, birth, email, goon, role, point, avatar, pcolor from member where id = #{id}")
    MemberTO findOneById(String id);

    @Select("select id, name, age, birth, email, goon, role, point, avatar, pcolor from member where id = #{id}")
    MemberTO checkMemberInfoOauth(String id);

    @Update("update member set avatar = #{avatar} where id = #{id}")
    int updateAvatar(String id, String avatar);

    @Update("update member set goon = #{goon}, age = #{age}, name = #{name}, pcolor = #{pcolor} where id = #{id}")
    int updateMemberInfoById(MemberTO to);

    @Update("update member set role = #{role}, email = #{email}, password = #{password}, avatar = #{avatar} where id = #{id}")
    int updateJoinDiscordInfo(MemberTO to);

}
