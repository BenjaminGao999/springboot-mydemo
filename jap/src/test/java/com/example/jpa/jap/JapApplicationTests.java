package com.example.jpa.jap;

import com.example.jpa.jap.entity.RoleDO;
import com.example.jpa.jap.entity.RoleUserDO;
import com.example.jpa.jap.entity.RoleUserId;
import com.example.jpa.jap.entity.UserDO;
import com.example.jpa.jap.repositories.RoleDao;
import com.example.jpa.jap.repositories.RoleUserDao;
import com.example.jpa.jap.repositories.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JapApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleUserDao roleUserDao;

    @Before
    public void before() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("风清扬");
        userDO.setAccount("fengqy");
        userDO.setPwd("123456");
        userDao.save(userDO);

        userDO = new UserDO();
        userDO.setId(3L);
        userDO.setName("东方不败");
        userDO.setAccount("bubai");
        userDO.setPwd("123456");
        userDao.save(userDO);


        userDO.setId(5L);
        userDO.setName("向问天");
        userDO.setAccount("wentian");
        userDO.setPwd("123456");
        userDao.save(userDO);

        // role
        RoleDO roleDO = new RoleDO();
        roleDO.setId(1L);
        roleDO.setName("boss");
        roleDao.save(roleDO);


        // role-user
        RoleUserDO roleUserDO = new RoleUserDO();
        roleUserDO.setRoleId(1L);
        roleUserDO.setUserId(3L);
        roleUserDao.save(roleUserDO);


    }

//    @Test
//    public void testAdd() {
//        UserDO userDO = new UserDO();
//        userDO.setId(2L);
//        userDO.setName("任我行");
//        userDO.setAccount("renwox");
//        userDO.setPwd("123456");
//        userDao.save(userDO);
//
//
//        userDO = new UserDO();
//        userDO.setId(4L);
//        userDO.setName("令狐冲");
//        userDO.setAccount("linghuc");
//        userDO.setPwd("123456");
//        userDao.save(userDO);
//    }

    @After
    public void after() {
        userDao.deleteById(1L);
        userDao.deleteById(3L);
        userDao.deleteById(5L);

        roleUserDao.deleteById(new RoleUserId(1L, 3L));
    }


    @Test
    public void testLocate() {
        Optional<UserDO> userDOOptional = userDao.findById(1L);
        if (userDOOptional.isPresent()) {
            UserDO userDO = userDOOptional.get();
            System.out.println("name = " + userDO.getName());
            System.out.println("account = " + userDO.getAccount());
        }
    }

    @Test
    public void testFindAll() {
        List<UserDO> userDOList = userDao.findAll(new Sort(Sort.Direction.DESC, "account"));
        for (UserDO userDO : userDOList) {
            System.out.println("name = " + userDO.getName());
            System.out.println("account = " + userDO.getAccount());
        }
    }

    @Test
    public void testFindByAccount() {
        UserDO userDO = userDao.findByAccount("wentian");
        if (userDO != null) {
            System.out.println("name = " + userDO.getName());
            System.out.println("account = " + userDO.getAccount());
        }
    }

    @Test
    public void testByNativeSQL() {
//        List<UserDO> userDOList = userDao.findSQL("风清扬", "东方不败");
//        for (UserDO item : userDOList) {
//            System.out.println("name = " + item.getName());
//            System.out.println("account = " + item.getAccount());
//        }

        List<UserDO> users = userDao.findUsersByRole(1L);
        for (UserDO user : users) {
            System.out.println("name = " + user.getName());
            System.out.println("account = " + user.getAccount());
        }
    }


    @Autowired
    private EntityManager entityManager;

    @Test
    public void dynamicSQL() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("风清扬");
        userDO.setAccount("fengqy");
        userDO.setPwd("123456");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDO> cq = cb.createQuery(UserDO.class);
        Root<UserDO> root = cq.from(UserDO.class);
        Predicate predicate = cb.equal(root.get("name"), userDO.getName());
        cq.where(predicate);
        TypedQuery<UserDO> typedQuery =
                entityManager.createQuery(cq);

        List<UserDO> resultList = typedQuery.getResultList();

        if (CollectionUtils.isEmpty(resultList)) {
            return;
        }

        resultList.forEach(userDO1 -> {
            System.out.println(userDO1);
        });


    }
}
