package com.example.service;

import com.example.dto.MemberTO;
import com.example.repository.AdminMapperInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    
    private final AdminMapperInter adminMapperInter;
    
    public List<MemberTO> memberList () {
        List<MemberTO> allMembers = adminMapperInter.findAll();
        return allMembers;
    }

}
