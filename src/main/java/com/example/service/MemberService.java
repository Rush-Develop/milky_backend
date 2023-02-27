package com.example.service;

import com.example.dto.MemberTO;
import com.example.repository.MemberMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberMapperInter memberMapperInter;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public int saveMember(MemberTO to) {
        to.setPassword(passwordEncoder.encode(to.getPassword()));
        to.setRole("ROLE_USER");
        int result = memberMapperInter.saveMember(to);
        int flag = 1;

        if (result == 1) {
            flag = 0;
        } else {
            flag = 1;
        }
        return flag;
    }

    public MemberTO findMemberById(String id) {
        MemberTO to = memberMapperInter.findOneById(id);
        return to;
    }

}
