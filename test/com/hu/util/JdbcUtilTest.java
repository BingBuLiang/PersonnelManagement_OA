package com.hu.util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 9:00
 * @decription
 **/
class JdbcUtilTest {

    @Test
    void getConnection() {
        Connection connection=JdbcUtil.getConnection();
        System.out.println(connection);
    }
}