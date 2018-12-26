package com.hellozepp.dao;

import com.hellozepp.model.Book;
import com.hellozepp.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDao {

    /**
     * ÃÌº”Õº È
     *
     * @param con
     * @param book
     * @return
     * @throws Exception
     */
    public int bookAdd(Connection con, Book book) throws Exception {
        String sql = "insert into t_book values(null,?,?,?,?,?,?,?,?,?,0)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setString(2, book.getAuthor());
        pstmt.setString(3, book.getSex());
        pstmt.setFloat(4, book.getPrice());
        pstmt.setString(5, book.getBookDesc());
        pstmt.setInt(6, book.getBookTypeId());
        pstmt.setString(7, book.getPress());
        pstmt.setInt(8, book.getCopies());
        pstmt.setFloat(9, book.getPurchasePrice());
        return pstmt.executeUpdate();
    }

    public ResultSet bookList(Connection con, Book book) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id and b.deleted ='0' ");
        if (StringUtil.isNotEmpty(book.getBookName())) {
            sb.append(" and b.bookName like '%" + book.getBookName() + "%'");
        }
        if (StringUtil.isNotEmpty(book.getAuthor())) {
            sb.append(" and b.author like '%" + book.getAuthor() + "%'");
        }
        if (StringUtil.isNotEmpty(book.getSex())) {
            sb.append(" and b.sex = '" + book.getSex() + "'");
        }
        if (book.getBookTypeId() != -1) {
            sb.append(" and b.bookTypeId = " + book.getBookTypeId());
        }

        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    public int bookDelete(Connection con, String id) throws Exception {
        String sql = "update t_book set deleted = '1' where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        return pstmt.executeUpdate();
    }

    public int bookModify(Connection con, Book book) throws Exception {
        String sql = "update t_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=?,press=?,copies=?,purchasePrice=? where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setString(2, book.getAuthor());
        pstmt.setString(3, book.getSex());
        pstmt.setFloat(4, book.getPrice());
        pstmt.setString(5, book.getBookDesc());
        pstmt.setInt(6, book.getBookTypeId());
        pstmt.setInt(10, book.getId());
        pstmt.setString(7, book.getPress());
        pstmt.setInt(8, book.getCopies());
        pstmt.setFloat(9, book.getPurchasePrice());
        return pstmt.executeUpdate();
    }

    public boolean getBookByBookTypeId(Connection con, String bookTypeId) throws Exception {
        String sql = "select * from t_book where bookTypeId=? and delete ='0'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, bookTypeId);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
     public boolean needNotice(int count){
        return count <= 1;
     }
}
