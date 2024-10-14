package com.example.demo.Dto;

import com.example.demo.Entity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String memberName;

    public PostResponse(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.memberName = post.getMember().getName();
    }
 }
