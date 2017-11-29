package com.paper.demo;

import java.sql.*;
import java.util.Arrays;

/**
 * Created by zhangzhibo-dell on 17-11-28.
 */
public class Test {
    public static void main(String[] args) throws SQLException  {
        System.out.println( "Hello World!" );
        Connection conn = null;
        String sql;

        String conn_str = "jdbc:mysql://192.168.3.111:3306/mydatabase?"
                + "user=zzb&password=123&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            System.out.println("成功加载MySQL驱动程序");

            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(conn_str);
            Statement stmt = conn.createStatement();
//            sql = "show tables;";
            sql = "select * from user;";
            ResultSet result = stmt.executeQuery(sql);
            StringBuffer sb = new StringBuffer("");
            if (result != null) {
                while (result.next()) {
//                    System.out.println(result.getString(2) + "\t");
                    sb.append(result.getString(1));
                    sb.append(" ");
                    sb.append(result.getString(2));
                    sb.append(" ");
                    sb.append(result.getString(3));
                    sb.append(" ");
                    sb.append(result.getString(4));
                    sb.append(" ");
                    sb.append(result.getString(5));
                    sb.append(" ");
                    sb.append(result.getString(6));
                    sb.append(" ");
                    sb.append(result.getString(7));
                    sb.append(" ");
                    sb.append(result.getString(8));
                    sb.append(" ");
                    sb.append(result.getString(9));
                    sb.append(" ");
                    sb.append(result.getString(10));
                    sb.append(" ");
                    sb.append(result.getString(11));
                    sb.append(" ");
                    sb.append(result.getString(12));
                    sb.append(" ");
                    sb.append(result.getString(13));
                    sb.append(" ");
                    sb.append(result.getString(14));
                    sb.append(" ");
                    sb.append(result.getString(15));
                    sb.append(" ");
                    sb.append(result.getString(16));
                    sb.append(" ");
                    sb.append(result.getString(17));
                    sb.append(" ");
                    sb.append(result.getString(18));
                    sb.append(" ");
                    sb.append(result.getString(19));
                    sb.append(" ");
                    sb.append(result.getString(20));
                    sb.append(" ");
                    sb.append(result.getString(21));
                    sb.append(" ");
                    sb.append(result.getString(22));
                    sb.append(" ");
                    sb.append(result.getString(23));
                    sb.append(" ");
                    sb.append(result.getString(24));
                    sb.append(" ");
                    sb.append(result.getString(25));
                    sb.append(" ");
                    sb.append(result.getString(26));
                    sb.append(" ");
                    sb.append(result.getString(27));
                    sb.append(" ");
                    sb.append(result.getString(28));
                    sb.append(" ");
                    sb.append(result.getString(29));
                    sb.append(" ");
                    sb.append(result.getString(30));
                    sb.append(" ");
                    sb.append(result.getString(31));
                    sb.append(" ");
                    sb.append(result.getString(32));
                    sb.append(" ");
                    sb.append(result.getString(33));
                    sb.append(" ");
                    sb.append(result.getString(34));
                    sb.append(" ");
                    sb.append(result.getString(35));
                    System.out.println(sb+ "\t");
                    sb.delete(0,sb.length()-1);
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

    }
}
