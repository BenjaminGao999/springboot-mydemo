package com.example.springboot.mybatis.mybatisdemo.mapper;

import com.example.springboot.mybatis.mybatisdemo.model.Village;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author benjamin
 * created at 2019/6/4
 */
@Mapper
public interface VillageMapper {
    @Results({
            @Result(property = "vid", column = "id"),
            @Result(property = "villageName", column = "name"),
            @Result(property = "district", column = "district")
    })
    @Select("SELECT id, name, district from village WHERE id = #{id}")
    Village selectVillage(int id);

    @Results({
            @Result(property = "vid", column = "id"),
            @Result(property = "villageName", column = "name"),
            @Result(property = "district", column = "district")
    })
    @Select("SELECT id, name, district from village")
    List<Village> selectVillageALL();


    /*

        批量插入和返回每条插入记录的id
     */
    @Insert("INSERT into village(name,district) VALUES(#{villageName}, #{district})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "vid")
    void insertVillage(Village village);


    @Update("UPDATE village SET name=#{villageName}, district =#{district} WHERE id =#{vid}")
    void updateVillage(Village village);

    @Delete("DELETE FROM village WHERE id =#{id}")
    void deleteVillage(int id);
}

