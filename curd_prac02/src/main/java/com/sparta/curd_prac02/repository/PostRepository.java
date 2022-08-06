package com.sparta.curd_prac02.repository;

import com.sparta.curd_prac02.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
    List<Post> findAllByOrderByModifiedAtDesc();
}
