package com.hellozepp.dao;

import com.hellozepp.model.Lease;
import com.hellozepp.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhanglin
 * @Date: 2018/12/26
 * @Time: 12:47 AM
 */
public class LeaseDao {
    private DbUtil dbUtil = new DbUtil();

    /**
     * 获取租赁信息
     *
     * @return
     * @throws Exception
     */
    public List<Lease> getLeaseList() throws Exception {
        Connection con = null;
        List<Lease> resultUsers = new ArrayList<>();
        Lease resultUser;
        try {
            con = dbUtil.getCon();
            String sql = "select * from t_lease where deleted='0'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultUser = new Lease();
                resultUser.setId(rs.getLong("id"));
                resultUser.setBookId(rs.getLong("bookId"));
                resultUser.setDeposit(rs.getFloat("deposit"));
                resultUser.setEmployee(rs.getString("employee"));
                resultUser.setLeaseTime(rs.getDate("leaseTime"));
                resultUser.setPhoneNumber(rs.getLong("phoneNumber"));
                resultUser.setDeleted(rs.getInt("deleted"));
                resultUser.setPrice(rs.getFloat("price"));
                resultUsers.add(resultUser);
            }
            return resultUsers;
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
