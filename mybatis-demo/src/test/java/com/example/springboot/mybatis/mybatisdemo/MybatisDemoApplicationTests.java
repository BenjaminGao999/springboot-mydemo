package com.example.springboot.mybatis.mybatisdemo;

import com.example.springboot.mybatis.mybatisdemo.mapper.VillageMapper;
import com.example.springboot.mybatis.mybatisdemo.model.Village;
import com.google.gson.Gson;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    VillageMapper villageMapper;

    @Test
    public void insertVillage() {
        Village village = new Village();
        village.setVillageName("柯里昂");
        village.setDistrict("10010");
        villageMapper.insertVillage(village);

    }

    @Autowired
    SqlSessionFactory factory;

    @Test
    public void insertVillage02() {

        try (SqlSession sqlSession = factory.openSession();
        ) {

            VillageMapper mapper = sqlSession.getMapper(VillageMapper.class);

            Village village = new Village();
            village.setVillageName("布鲁克林");
            village.setDistrict("10020");
            mapper.insertVillage(village);
        }

    }

    /*


      @Test
  void testInsertWithMapper() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
      Mapper userMapper = sqlSession.getMapper(Mapper.class);
      User user1 = new User(null, "Pocoyo");
      userMapper.insert(user1);
      User user2 = new User(null, "Valentina");
      userMapper.insert(user2);
      sqlSession.flushStatements();
      assertEquals(Integer.valueOf(50), user1.getId());
      assertEquals(Integer.valueOf(50), user2.getId());
      sqlSession.commit();
    }

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      List<User> users = sqlSession.selectList("select");
      Assertions.assertEquals(2, users.size());
    }
  }



     */

    @Test
    public void insertBatchVillage() {

        ArrayList<Village> villages = getVillages();


        try (SqlSession sqlSession = factory.openSession(ExecutorType.BATCH)) {
            VillageMapper villageMapper = sqlSession.getMapper(VillageMapper.class);
            villages.forEach(new Consumer<Village>() {
                @Override
                public void accept(Village village) {
                    villageMapper.insertVillage(village);
                }
            });
            sqlSession.flushStatements();
            sqlSession.commit();
        }

        System.out.println(new Gson().toJson(villages));



    }

    private ArrayList<Village> getVillages() {
        ArrayList<Village> villages = new ArrayList<>();

        for (int i = 0; i < 2; i++) {

            Village village = new Village();

//            village.setVid(4 + i);

            village.setVillageName("小村庄" + i);

            village.setDistrict("100" + i + "0");

            villages.add(village);
        }
        return villages;
    }


    @Test
    public void selectVillageById() {
        Village village = villageMapper.selectVillage(2);

        String toJson = new Gson().toJson(village);

        System.out.println("village: " + toJson);

    }


    @Test
    public void selectVillageALl() {

        List<Village> villages =
                villageMapper.selectVillageALL();
        String toJson = new Gson().toJson(villages);

        System.out.println("village: " + toJson);

    }

    @Test
    public void updateVillage() {

        Village village = new Village();
        village.setVid(3);
        village.setVillageName("纽约");
        village.setDistrict("10030");

        villageMapper.updateVillage(village);
    }


}
