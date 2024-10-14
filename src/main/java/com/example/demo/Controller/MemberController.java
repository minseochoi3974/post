package com.example.demo.Controller;

import com.example.demo.Dto.MemberForm;
import com.example.demo.Dto.MemberResponse;
import com.example.demo.Dto.PostResponse;
import com.example.demo.Entity.Member;
import com.example.demo.Entity.Post;
import com.example.demo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {


    private final MemberRepository memberRepository;

    @Autowired
    private MemberController(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String helloWord(){
        return "helloWord";
    }

    @GetMapping("/user")
    public List<MemberResponse> getUser(){
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> memberResponses = members.stream().map(MemberResponse::new).toList();

        return memberResponses;
    }

    @PostMapping("/user")
    public MemberResponse crateMember(@RequestBody MemberForm form){
        Member member = form.toEntity();
        Member result = memberRepository.save(member);
        return new MemberResponse(result);

    }
}
