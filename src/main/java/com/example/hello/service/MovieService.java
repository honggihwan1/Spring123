package com.example.hello.service;

import com.example.hello.dto.MovieDto;
import com.example.hello.utils.MyApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    // 멜론 차트를 크롤링 해서 리스트를 전달
    public List<MovieDto> getNaverMovieList() {
        return MyApi.getNaverMovieList();
    }

}