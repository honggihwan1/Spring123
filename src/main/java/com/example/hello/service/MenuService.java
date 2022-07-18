package com.example.hello.service;

import com.example.hello.Crawling;
import com.example.hello.repo.MenuRepository;
import com.example.hello.utils.NaverApi;
import com.example.hello.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    private  Crawling crawling;

    //전체 데이터 조회
    public List<MenuVo> findAll() {
        List<MenuVo> menu = new ArrayList<>();
        menuRepository.findAll().forEach(e -> menu.add(e));
        return menu;
    }

    //데이터 넣기(insert)
    public Long save(MenuVo menu) {
        return menuRepository.save(menu).getId();
     //   return menu;
    }

    // 랜덤 데이터 값 하나 추출
    public List<MenuVo> findRandMenu(){
        return menuRepository.findRandMenu();
    }

    // 네이버 블로그 검색
    public  String blogSearch(String keyword){
        return  NaverApi.blogSearch(keyword);
    }

}
