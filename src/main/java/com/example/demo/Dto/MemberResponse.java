package com.example.demo.Dto;

import com.example.demo.Entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class MemberResponse {

    private Long id;
    private String name;
    private Long password;
    private String email;
    private List<PostResponse> Posts;


    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
        this.email = member.getEmail();
        this.Posts = member.getPosts().stream().map(post -> new PostResponse(post)).toList();
    }
}
