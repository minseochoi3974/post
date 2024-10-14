package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
//생성자를 전부다 받아오는 역할
@AllArgsConstructor
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long password;

    @Column(nullable = false)
    private String email;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<Post> posts;

}
