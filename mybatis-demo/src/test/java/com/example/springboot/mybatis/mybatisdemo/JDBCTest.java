package com.example.springboot.mybatis.mybatisdemo;

import org.junit.Test;

import java.sql.*;

/**
 * @author benjamin
 * created at 2019/6/27
 */
public class JDBCTest {


    @Test
    public void test() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiibaidb", "root", "password");
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();
        String sql = "select * from  customers limit 0,5";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int customerNumber = rs.getInt("customerNumber");
            String customerName = rs.getString("customerName");

            System.out.println("customerNumber: " + customerNumber + "   customerName:  " + customerName);
        }
        conn.commit();

        rs.close();
        st.close();
        conn.close();

    }


}

