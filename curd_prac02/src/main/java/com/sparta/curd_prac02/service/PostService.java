package com.sparta.curd_prac02.service;

import com.sparta.curd_prac02.dto.PostRequestDto;
import com.sparta.curd_prac02.dto.ResponseDto;
import com.sparta.curd_prac02.entity.Post;
import com.sparta.curd_prac02.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public ResponseDto<?> createPost(PostRequestDto requestDto){
        Post post = new Post(requestDto);
        postRepository.save(post);
        return ResponseDto.success(post);
    }

    @Transactional
    public ResponseDto<?> getPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if(optionalPost == null){
            return ResponseDto.fail("NULL POST ID","post id isn't exist");
        }
        return ResponseDto.success(optionalPost.get());
    }

    @Transactional
    public ResponseDto<?> getAllPost(){
        return ResponseDto.success(postRepository.findAllByOrderByModifiedAtDesc());
    }

    @Transactional
    public ResponseDto<?> updatePost(Long id, PostRequestDto requestDto) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost == null){
            return ResponseDto.fail("NULL POST ID","post id isn't exist");
        }
        Post post = optionalPost.get();
        post.update(requestDto);

        return ResponseDto.success(post);
    }

    @Transactional
    public ResponseDto<?> deletePost(Long id){
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost == null){
            return ResponseDto.fail("NULL POST ID","post id isn't exist");
        }
        Post post = optionalPost.get();

        postRepository.delete(post);
        return ResponseDto.success(true);
    }

    @Transactional
    public ResponseDto<?> validateAuthorByPassword(Long id, String password) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if(optionalPost == null){
            return ResponseDto.fail("NOT FOUND","post id is not exist");
        }
        Post post = optionalPost.get();

        if(post.getPassword().equals(password)){
            return ResponseDto.fail("PASSWORD NOT CORRECT", "password is not correct");
        }
        return ResponseDto.success(true);
    }
}
