package com.example.hello;

import com.example.hello.dto.MovieDto;
import com.example.hello.dto.MusicDto;
import com.example.hello.service.MenuService;
import com.example.hello.service.MovieService;
import com.example.hello.service.MusicService;
import com.example.hello.vo.MenuVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class HelloApiController {

    @Autowired
    private MenuService menuService;
    private MusicService musicService;
    private MovieService movieService;

    public HelloApiController(MusicService musicService, MovieService movieService) {
        this.musicService = musicService;
        this.movieService = movieService;
    }

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }
    @RequestMapping("/hellokr")
    String hello() {
        return "헬로 월드!";
    }


    //@PostMapping("/insert")
    //public ResponseEntity<MenuVo> save(MenuVo menu) {
    //    return new ResponseEntity<MenuVo>(menuService.save(menu), HttpStatus.OK);
    //}
    @PostMapping("/api/v1/insert")
    public Long save(@RequestBody MenuVo menu){
        return menuService.save(menu);
    }
    @Transactional(readOnly = true)
    @GetMapping("/api/v1/menulist")
    public ResponseEntity<List<MenuVo>> getAllMenu () {
        List<MenuVo> list = menuService.findAll();
        return new ResponseEntity<List<MenuVo>>(list, HttpStatus.OK);
    }


    // 모든 회원 조회
    @GetMapping("/menulist")
    public ResponseEntity<List<MenuVo>> getAllmembers() {
        List<MenuVo> menu = menuService.findAll();
        return new ResponseEntity<List<MenuVo>>(menu, HttpStatus.OK);
    }

    // 무자위 메뉴 추천 조회
    @GetMapping("/api/v1/best")
    public ResponseEntity<List<MenuVo>> getBestMenu() {
        List<MenuVo> list = menuService.findRandMenu();
        return new ResponseEntity<List<MenuVo>>(list, HttpStatus.OK);
    }

    // 네이버 검색 조회회
    @GetMapping("/api/v1/blogmenu")
    public ResponseEntity<String> getBlogMenu(@RequestParam String keyword) {
        String json = menuService.blogSearch(keyword);
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }
    @GetMapping("/api/v1/melon")
    public ResponseEntity<List<MusicDto>> getMelonList() {
        List<MusicDto> list = musicService.getMelonMusicList();
        return new ResponseEntity<List<MusicDto>>(list, HttpStatus.OK);
    }
    @GetMapping("/api/v1/movie")
    public ResponseEntity<List<MovieDto>> getMoiveList() {
        List<MovieDto> list = movieService.getNaverMovieList();
        return new ResponseEntity<List<MovieDto>>(list, HttpStatus.OK);
    }

}