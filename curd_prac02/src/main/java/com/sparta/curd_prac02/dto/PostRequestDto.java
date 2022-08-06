package com.sparta.curd_prac02.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;

}
