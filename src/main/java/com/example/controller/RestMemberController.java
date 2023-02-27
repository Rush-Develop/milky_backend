package com.example.controller;

import com.example.dto.MemberTO;
import com.example.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RestMemberController {

    private final MemberService memberService;

    @PostMapping("/api/join")
    public int joinApi(MemberTO to) {
        int flag = memberService.saveMember(to);
        return flag;
    } // 멤버 회원가입 로직

    @GetMapping("/api/member/mypage/{id}")
    public MemberTO myinfoApi(@PathVariable("id") String id) {
        MemberTO to = memberService.findMemberById(id);
        return to;
    }

}
