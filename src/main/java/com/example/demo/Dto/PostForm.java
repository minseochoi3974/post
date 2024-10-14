package com.example.demo.Dto;

import com.example.demo.Entity.Member;
import com.example.demo.Entity.Post;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostForm {
    private String title;
    private String content;

    public Post toEnitiy(Member member){
        return new Post(null, title, content, member);
    }
}
