package com.example.controller;

import com.example.dto.MemberTO;
import com.example.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/admin/home")
    public String adminHome(Model model) {
        List<MemberTO> allMembers = adminService.memberList();
        model.addAttribute("allMembers", allMembers);
        return "adminhome";
    }


}
