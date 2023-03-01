package com.example.service;

import com.example.dto.MemberTO;
import com.example.repository.HomeMapperInter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HomeService {

    private final HomeMapperInter homeMapperInter;

    public List<MemberTO> findPointRanking () {
        return homeMapperInter.findMemberOrderByPoint();
    }

}
