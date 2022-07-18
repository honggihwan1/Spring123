package com.example.hello.repo;

import com.example.hello.vo.MenuVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuVo, Long> {

    // 랜덤값 쿼리문
    @Query(value = "SELECT * FROM `mydb`.`tb_menu` ORDER BY RAND() LIMIT 1", nativeQuery=true)
    List<MenuVo> findRandMenu();
}
