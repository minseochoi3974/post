package com.example.demo.Controller;

import com.example.demo.Dto.PostForm;
import com.example.demo.Dto.PostResponse;
import com.example.demo.Entity.Member;
import com.example.demo.Entity.Post;
import com.example.demo.Repository.MemberRepository;
import com.example.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PostController {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public PostController(PostRepository postRepository, MemberRepository memberRepository){
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/post")
    public List<PostResponse> getPosts(){
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponses = posts.stream().map(post->new PostResponse(post)).toList();
        return postResponses;
    }

    @PostMapping("/post")
    public PostResponse addPost(@RequestParam("id") Long id, @RequestBody PostForm form){

        Member member = memberRepository.findById(id).orElse(null);
        Post post = form.toEnitiy(member);
        Post result = postRepository.save(post);

        PostResponse postResponse = new PostResponse(result);
        System.out.println(postResponse.toString());

        return postResponse;
    }

}
