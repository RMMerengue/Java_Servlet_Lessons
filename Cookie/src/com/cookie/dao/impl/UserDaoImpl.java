package com.cookie.dao.impl;

import com.cookie.dao.UserDao;
import com.cookie.entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {


    @Override
    public User checkUser(User user) {
        //define connection
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User u = null;
        try{
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_person?useSSL=false&serverTimezone=UTC", "root", "wty7220898");
            pstmt = conn.prepareStatement("select * from person where name = ? and pwd = ?");
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPwd());
            rs = pstmt.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("pwd"));
                System.out.println(u.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return u;
    }

    @Override
    public User getUserById(int id) {
        //define connection
        System.out.println("enter getUserById");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User u = null;
        try{
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_person?useSSL=false&serverTimezone=UTC", "root", "wty7220898");
            pstmt = conn.prepareStatement("select * from person where id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("pwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return u;
    }


}
