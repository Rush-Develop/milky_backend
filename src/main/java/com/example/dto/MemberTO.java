package com.example.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberTO {
    private String id;
    private String name;
    private String age;
    private String birth;
    private String email;
    private String password;
    private String goon;
    private String role;
}
