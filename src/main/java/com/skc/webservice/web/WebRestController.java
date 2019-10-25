package com.skc.webservice.web;

import com.skc.webservice.domain.posts.Posts;
import com.skc.webservice.domain.posts.PostsRepository;
import com.skc.webservice.dto.posts.PostsMainResponseDto;
import com.skc.webservice.dto.posts.PostsSaveRequestDto;
import com.skc.webservice.service.PostsService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
