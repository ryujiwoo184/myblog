package com.sparta.curd_prac02.controller;

import com.sparta.curd_prac02.dto.PostRequestDto;
import com.sparta.curd_prac02.dto.ResponseDto;
import com.sparta.curd_prac02.entity.Post;
import com.sparta.curd_prac02.repository.PostRepository;
import com.sparta.curd_prac02.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    public final PostRepository postRepository;
    public final PostService postService;

    // 생성
    @PostMapping("/api/post")
    public ResponseDto<?> createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    // 상세조회
    @GetMapping("/api/post/{id}")
    public ResponseDto<?> getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    //전체조회
    @GetMapping("/api/post")
    public ResponseDto<?> getAllPosts() {
        return postService.getAllPost();
    }

    // 수정
    @PutMapping("/api/post/{id}")
    public ResponseDto<?> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }

    //삭제
    @DeleteMapping("/api/post/{id}")
    public ResponseDto<?> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @PostMapping("/api/post/{id}")
    public ResponseDto<?> validateAuthorByPassword(@PathVariable Long id, @RequestBody String password){
        return postService.validateAuthorByPassword(id, password);
    }
}
