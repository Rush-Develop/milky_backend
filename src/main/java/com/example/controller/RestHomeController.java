package com.example.controller;

import com.example.dto.MemberTO;
import com.example.service.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestHomeController {

    private final HomeService homeService;

    @GetMapping("/api/home/pointrank")
    public ResponseEntity<?> showPointRank () {
        List<MemberTO> pointRankingList = homeService.findPointRanking();
        return new ResponseEntity<>(pointRankingList, HttpStatus.OK);
    }
}
