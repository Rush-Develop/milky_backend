package com.example.controller;

import com.example.dto.MemberTO;
import com.example.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestAdminController {

    private final AdminService adminService;

    @GetMapping("/api/admin/home")
    public List<MemberTO> adminHomeApi () {
        List<MemberTO> members = adminService.memberList();
        for(MemberTO m : members){
            System.out.println(m.toString());
        }
        return members;
    }


}
