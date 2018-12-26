package com.hellozepp.dao;

import com.hellozepp.model.Book;
import com.hellozepp.model.Enum.UserTypeEnum;
import com.hellozepp.model.User;
import com.hellozepp.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    private DbUtil dbUtil = new DbUtil();

    /**
     * 登录
     *
     * @param user
     * @return
     * @throws Exception
     */
    public User login(User user) throws Exception {
        Connection con = null;
        User resultUser = null;
        try {
            con = dbUtil.getCon();
            String sql = "select * from t_user where userName=? and password=? and userType=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUserType());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                resultUser = new User();
                resultUser.setUserName(rs.getString("userName"));
                resultUser.setPassword(rs.getString("password"));
                resultUser.setUserType(rs.getString("userType"));
            }
            return resultUser;
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取所有店员
     *
     * @return
     * @throws Exception
     */
    public List<User> getUserList() throws Exception {
        Connection con = null;
        List<User> userList = new ArrayList<>();
        User resultUser;
        try {
            con = dbUtil.getCon();
            String sql = "select * from t_user where userType='" + UserTypeEnum.USER.getName()+"'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultUser = new User();
                resultUser.setUserName(rs.getString("userName"));
                resultUser.setId(rs.getInt("id"));
                resultUser.setName(rs.getString("name"));
                resultUser.setPassword(rs.getString("password"));
                resultUser.setUserType(rs.getString("userType"));
                userList.add(resultUser);

            }
            return userList;
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
  /**
     * 添加店员
     *
     * @param con
     * @param book
     * @return
     * @throws Exception
     */
    public int Add(Connection con, User book) throws Exception {
        String sql = "insert into t_user values(null,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, book.getUserName());
        pstmt.setString(2, book.getPassword());
        pstmt.setString(3, UserTypeEnum.USER.getName());
        pstmt.setString(4, book.getName());
        return pstmt.executeUpdate();
    }
    /**
     * 检测用户权限
     *
     * @param user
     * @return
     */
    public boolean checkVerify(User user) {
        if (user == null || UserTypeEnum.get(user.getUserType()) != UserTypeEnum.ADMIN) {
            return false;
        }
        return true;
    }

}
