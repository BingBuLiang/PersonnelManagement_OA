package com.hu.util;

import java.sql.*;
import java.util.*;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-07 19:16
 * @decription
 **/
public class JdbcUtil {
    private static String driver;
    private static String jdbcUrl;
    private static String username;
    private static String password;
    /**
     * 定义一个ThreadLocal变量，存放的是Connection
     * 可以保证在同一个线程中，不同层次、不同方法都使用ThreadLocal的Connection，使用的是同一个Connection
     * JavaEE中，客户端的一个请求就是一个线程
     *  private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
     */


    // 读取属性文件properties并获取内容
    static {
        //读取properties文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        /**准备一个空的map，没有key-value*/
        //Properties bundle = new Properties();

       /* InputStream is = JdbcUtil.class.getResourceAsStream("/jdbc.properties"); //classpath
        try {
            bundle.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        driver = bundle.getString("driver");
        jdbcUrl = bundle.getString("url");
        username = bundle.getString("username");
        password = bundle.getString("password");
       /* driver = bundle.getProperty("driver");
        //driver = prop.get("driver");
        jdbcUrl = bundle.getProperty("url");
        username = bundle.getProperty("username");
        password = bundle.getProperty("password");*/
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用增删改 insert  update  delete
     */
    public static int executeUpdate(String sql, Object... params) {
        int flag = 0;
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            int result = ps.executeUpdate();
            if (result > 0) {
                flag = 1;
            }
            closeAll(con, ps, null);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return flag;
    }

    /**
     * 针对 select
     * @param sql sql语句
     * @param params 参数 #{0}
     * @return list
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object... params) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < ps.getParameterMetaData().getParameterCount(); i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            while (rs.next()) {
                Map<String, Object> map = new TreeMap<>();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String name = rsmd.getColumnLabel(i + 1);
                    map.put(name, rs.getObject(i + 1));
                }
                list.add(map);
            }
            closeAll(con, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Connection getConnection() {
        Connection connection = null;
        //不是直接创建新的连接，而是首先从ThreadLocal中获取
      /*  connection = threadLocal.get();*/
        //如果threadLocal中不存在，说明是当前线程第一次获取连接，需要先创建再放入threadLocal
      /*  if (connection == null) {*/
            try {
                //建立数据库连接
                connection = (Connection) DriverManager.getConnection(jdbcUrl, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
          /*  //再放入threadLocal
            threadLocal.set(connection);
        }*/
        return connection;
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
