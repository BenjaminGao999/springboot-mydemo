package com.example.springboot.mybatis.mybatisdemo.service;

import com.example.springboot.mybatis.mybatisdemo.mapper.VillageMapper;
import com.example.springboot.mybatis.mybatisdemo.model.Village;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author benjamin
 * created at 2019/6/12
 */
@Service
public class VillageService {

    @Autowired
    VillageMapper villageMapper;


    @Transactional
    public void insertOne() {
        doActuallyInsert();
    }

    public void doActuallyInsert() {
        Village village = new Village();
        village.setVillageName("柯里昂");
        village.setDistrict("0612");
        villageMapper.insertVillage02(village, "name");
        makeRuntimeException();
    }

    private void makeRuntimeException() {
//        int i = 10 / 0;
    }
}
