package com.hellozepp.dao;

import com.hellozepp.model.Enum.TimeRangeEnum;
import com.hellozepp.model.Order;
import com.hellozepp.model.ProfitsDto;
import com.hellozepp.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: zhanglin
 * @Date: 2018/12/25
 * @Time: 11:47 PM
 */
public class OrderDao {
    private DbUtil dbUtil = new DbUtil();

    /**
     * 获取所有订单,按售价降序做排行榜
     *
     * @return
     * @throws Exception
     */
    public List<Order> getOrderList() throws Exception {
        Connection con = null;
        List<Order> userList = new ArrayList<>();
        Order resultUser;
        try {
            con = dbUtil.getCon();
            String sql = "select * from t_order order by total desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultUser = new Order();
                resultUser.setId(rs.getString("id"));
                resultUser.setNumbers(rs.getInt("numbers"));
                resultUser.setPrice(rs.getFloat("price"));
                resultUser.setEmployees(rs.getString("employees"));
                resultUser.setRoyalty(rs.getFloat("royalty"));
                resultUser.setTotal(rs.getFloat("total"));
                resultUser.setUpdate_time(rs.getDate("update_time"));
                resultUser.setCreate_time(rs.getDate("create_time"));
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
     * 描述:获取下一个月的第一天.
     *
     * @return
     */
    public static String getPerFirstDayOfMonth(Date date) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 获取年月周的营业金额和利润
     *
     * @return
     * @throws Exception
     */
    public ProfitsDto getProfitsByRangeTime(Date start_time, TimeRangeEnum timeRangeEnum) throws Exception {
        if (start_time == null || timeRangeEnum == null) {
            return null;
        }
        Connection con = null;
        ProfitsDto resultUser = null;
        try {
            con = dbUtil.getCon();
            String sql = "select sum(total) as 'amount',sum((price-royalty)*numbers) as profits from t_order where 1=1 ";
            switch (timeRangeEnum) {
                case YEAR:
                    sql += "and start_time between '" + start_time.getYear() + "' and '" + (start_time.getYear() + 1) + "'";
                    break;
                case MONTH:
                    sql += "and start_time between '" + start_time.getYear() + "" + start_time.getMonth() + "' and '" + getPerFirstDayOfMonth(start_time) + "'";
                    break;
                case WEEK: {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    Calendar c = new GregorianCalendar();
                    java.util.Date date = new java.util.Date();
                    c.setTime(date);
                    c.add(Calendar.SECOND, -7 * 24 * 3600);
                    java.util.Date dateBefore = c.getTime();//两种把Calendar转化成Long类型的方法（毫秒）
                    long nowDate = dateBefore.getTime();//把时间换算成毫秒
                    sql += "and start_time between '" + nowDate + "' and " + start_time.getTime();
                    break;
                }
                default:
                    return null;
            }
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                resultUser = new ProfitsDto();
                resultUser.setAmount(rs.getFloat("amount"));
                resultUser.setProfits(rs.getFloat("profits"));

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

}
