package com.example.demo.Dto;

import com.example.demo.Entity.Member;
import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MemberForm {
    private String name;
    private Long password;
    private String email;

    public Member toEntity(){
        return new Member(null, password,email,name, new ArrayList<>());
    }
}
