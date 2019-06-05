package com.example.springboot.mybatis.mybatisdemo.Conroller;

import com.example.springboot.mybatis.mybatisdemo.mapper.VillageMapper;
import com.example.springboot.mybatis.mybatisdemo.model.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author benjamin
 * created at 2019/6/4
 */
@RestController
public class MybatisController {

    @Autowired
    VillageMapper villageMapper;


    @GetMapping("/log")
    public String log() {

        Village village = new Village();
        village.setVillageName("柯里昂");
        village.setDistrict("10010");
        villageMapper.insertVillage02(village,"name");

        return "log";
    }
}
