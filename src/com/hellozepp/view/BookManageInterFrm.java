/*
 * BookManageInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.hellozepp.view;

import com.hellozepp.dao.BookDao;
import com.hellozepp.dao.BookTypeDao;
import com.hellozepp.model.Book;
import com.hellozepp.model.BookType;
import com.hellozepp.util.DbUtil;
import com.hellozepp.util.StringUtil;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * 图书管理
 */
public class BookManageInterFrm extends javax.swing.JInternalFrame {
    DbUtil dbUtil = new DbUtil();
    BookTypeDao bookTypeDao = new BookTypeDao();
    BookDao bookDao = new BookDao();

    /**
     * Creates new form BookManageInterFrm
     */
    public BookManageInterFrm() {
        initComponents();
        this.setLocation(200, 50);
        this.fillTable(new Book());
        this.fillBookType("search");
        this.s_jrbman.setSelected(true);
        this.jrb_man.setSelected(true);
        this.fillBookType("modify");
    }

    private void fillBookType(String type) {
        Connection con = null;
        BookType bookType = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = bookTypeDao.bookTypeList(con, new BookType());
            if ("search".equals(type)) {
                bookType = new BookType();
                bookType.setBookTypeName("请选择...");
                bookType.setId(-1);
                this.s_jcbBookType.addItem(bookType);
            }
            while (rs.next()) {
                bookType = new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setBookTypeName(rs.getString("bookTypeName"));
                if ("search".equals(type)) {
                    this.s_jcbBookType.addItem(bookType);
                } else if ("modify".equals(type)) {
                    this.jcb_bookType.addItem(bookType);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void fillTable(Book book) {
        DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = bookDao.bookList(con, book);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("id"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getString("sex"));
                v.add(rs.getFloat("price"));
                v.add(rs.getString("bookDesc"));
                v.add(rs.getString("bookTypeName"));
                v.add(rs.getString("press"));
                v.add(rs.getString("copies"));
                v.add(rs.getString("purchasePrice"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        s_bookNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        s_authorTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        s_jrbman = new javax.swing.JRadioButton();
        s_jrbfemale = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        s_jcbBookType = new javax.swing.JComboBox();
        jb_search = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bookNameTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        authorTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jrb_man = new javax.swing.JRadioButton();
        jrb_female = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jcb_bookType = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookDescTxt = new javax.swing.JTextArea();
        jb_modify = new javax.swing.JButton();
        jb_delete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("\u56fe\u4e66\u7ef4\u62a4");

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "编号", "图书名称", "图书作者", "作者性别", "图书价格", "图书描述", "图书类别", "出版社", "册数", "进价"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("\u641c\u7d22\u6761\u4ef6"));

        jLabel1.setText("\u56fe\u4e66\u540d\u79f0\uff1a");

        jLabel2.setText("\u56fe\u4e66\u4f5c\u8005\uff1a");

        jLabel3.setText("\u4f5c\u8005\u6027\u522b\uff1a");

        buttonGroup1.add(s_jrbman);
        s_jrbman.setText("\u7537");

        buttonGroup1.add(s_jrbfemale);
        s_jrbfemale.setText("\u5973");

        jLabel4.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");


        jb_search.setIcon(new javax.swing.ImageIcon(MainFrm.imagePath + "search.png"));
        jb_search.setText("\u67e5\u8be2");
        jb_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                .addGap(27)
                                .addComponent(jLabel2)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addGap(26)
                                .addComponent(jLabel3)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(s_jrbman, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(s_jrbfemale, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(s_jcbBookType, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(27)
                                .addComponent(jb_search, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addGap(52))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(s_jrbman)
                                        .addComponent(s_jrbfemale)
                                        .addComponent(jLabel4)
                                        .addComponent(s_jcbBookType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jb_search))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("\u8868\u5355\u64cd\u4f5c"));

        jLabel5.setText("\u7f16\u53f7\uff1a");

        idTxt.setEditable(false);

        jLabel6.setText("\u4ef7\u683c\uff1a");

        jLabel7.setText("\u56fe\u4e66\u540d\u79f0\uff1a");

        jLabel8.setText("\u56fe\u4e66\u4f5c\u8005\uff1a");

        jLabel9.setText("\u4f5c\u8005\u6027\u522b\uff1a");

        buttonGroup2.add(jrb_man);
        jrb_man.setText("\u7537");

        buttonGroup2.add(jrb_female);
        jrb_female.setText("\u5973");

        jLabel10.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");


        jLabel11.setText("\u56fe\u4e66\u63cf\u8ff0\uff1a");

        bookDescTxt.setColumns(20);
        bookDescTxt.setRows(5);
        jScrollPane2.setViewportView(bookDescTxt);

        jb_modify.setIcon(new javax.swing.ImageIcon(MainFrm.imagePath + "modify.png"));
        jb_modify.setText("\u4fee\u6539");
        jb_modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modifyActionPerformed(evt);
            }
        });

        jb_delete.setIcon(new javax.swing.ImageIcon(MainFrm.imagePath + "delete.png"));
        jb_delete.setText("\u5220\u9664");
        jb_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_deleteActionPerformed(evt);
            }
        });
        lblNewLabel = new JLabel("\u8FDB\u4EF7\uFF1A");
        purchasePriceTxt = new JTextField();
        purchasePriceTxt.setColumns(10);
        lblNewLabel_1 = new JLabel("\u518C\u6570\uFF1A");
        copiesTxt1 = new JTextField();
        copiesTxt1.setColumns(10);
        pressTxt = new JLabel("\u51FA\u7248\u793E\uFF1A");
        chubanshe = new JTextField();
        chubanshe.setColumns(10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24)
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jb_modify, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                .addGap(57)
                                                .addComponent(jb_delete, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jLabel5))
                                                        .addComponent(lblNewLabel_1))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(copiesTxt1)
                                                        .addComponent(priceTxt)
                                                        .addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                                                .addGap(27)
                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addGap(18)
                                                                .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(pressTxt))
                                                                .addGap(18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(chubanshe, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                                                        .addComponent(authorTxt))))
                                                .addGap(33)
                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(jcb_bookType, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(jrb_man, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(jrb_female, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(37)
                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel)
                                                        .addComponent(jLabel11))))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(purchasePriceTxt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(23)
                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(45)
                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(24)
                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jrb_man)
                                                        .addComponent(jrb_female)
                                                        .addComponent(lblNewLabel)
                                                        .addComponent(purchasePriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(45)
                                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(jLabel10)
                                                                .addComponent(jcb_bookType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel11)))))
                                .addGap(7)
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(copiesTxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pressTxt)
                                        .addComponent(chubanshe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jb_modify)
                                        .addComponent(jb_delete)))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>

    //GEN-END:initComponents
    private void jb_modifyActionPerformed(java.awt.event.ActionEvent evt) {
        String id = this.idTxt.getText();
        if (StringUtil.isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
            return;
        }

        String bookName = this.bookNameTxt.getText();
        String author = this.authorTxt.getText();
        String price = this.priceTxt.getText();
        String bookDesc = this.bookDescTxt.getText();
        Float purchasePrice;
        try {
            purchasePrice = Float.parseFloat(purchasePriceTxt.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "进价必须为数值！");
            return;
        }
        Integer copies;
        if (StringUtils.isNotBlank(copiesTxt1.getText()) && StringUtils.isNumeric(copiesTxt1.getText())) {
            copies = Integer.parseInt(copiesTxt1.getText());
        } else {
            JOptionPane.showMessageDialog(null, "册数必须为数值！");
            return;
        }
        String press = chubanshe.getText();
        if (StringUtil.isEmpty(press)) {
            JOptionPane.showMessageDialog(null, "出版社不能为空！");
            return;
        }
        if (StringUtil.isEmpty(bookName)) {
            JOptionPane.showMessageDialog(null, "图书名称不能为空！");
            return;
        }
        if (StringUtil.isEmpty(author)) {
            JOptionPane.showMessageDialog(null, "图书作者不能为空！");
            return;
        }
        if (StringUtil.isEmpty(price)) {
            JOptionPane.showMessageDialog(null, "图书价格不能为空！");
            return;
        }


        String sex = "";
        if (this.jrb_man.isSelected()) {
            sex = "男";
        } else if (this.jrb_female.isSelected()) {
            sex = "女";
        }

        BookType bookType = (BookType) this.jcb_bookType.getSelectedItem();
        int bookTypeId = bookType.getId();


        Book book = new Book(Integer.parseInt(id), bookName, author, sex, Float.parseFloat(price), bookDesc, bookTypeId, bookType.getBookTypeName(), press, copies, purchasePrice, 0);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int modifyNum = bookDao.bookModify(con, book);
            if (modifyNum == 1) {
                JOptionPane.showMessageDialog(null, "修改成功");
                this.resetValue();
                this.fillTable(new Book());
            } else {
                JOptionPane.showMessageDialog(null, "修改失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败");
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt) {
        String id = this.idTxt.getText();
        if (StringUtil.isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录吗？");
        if (n == 0) {
            Connection con = null;
            try {
                con = dbUtil.getCon();
                int deleteNum = bookDao.bookDelete(con, id);
                if (deleteNum == 1) {
                    JOptionPane.showMessageDialog(null, "删除成功");
                    this.resetValue();
                    this.fillTable(new Book());
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "删除失败");
            } finally {
                try {
                    dbUtil.closeCon(con);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    private void resetValue() {
        this.idTxt.setText("");
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.jrb_man.setSelected(true);
        this.priceTxt.setText("");
        this.bookDescTxt.setText("");
        if (this.jcb_bookType.getItemCount() > 0) {
            this.jcb_bookType.setSelectedIndex(0);
        }
    }

    // 获取选中的行
    private void bookTableMousePressed(java.awt.event.MouseEvent evt) {

        int row = this.bookTable.getSelectedRow();
        this.idTxt.setText((Integer) bookTable.getValueAt(row, 0) + "");
        this.bookNameTxt.setText((String) bookTable.getValueAt(row, 1));
        this.authorTxt.setText((String) bookTable.getValueAt(row, 2));
        String sex = (String) bookTable.getValueAt(row, 3);
        if ("男".equals(sex)) {
            this.jrb_man.setSelected(true);
        } else if ("女".equals(sex)) {
            this.jrb_female.setSelected(true);
        }
        this.priceTxt.setText((Float) bookTable.getValueAt(row, 4) + "");
        this.bookDescTxt.setText((String) bookTable.getValueAt(row, 5));
        String bookTypeName = (String) bookTable.getValueAt(row, 6);
        int n = this.jcb_bookType.getItemCount();
        for (int i = 0; i < n; i++) {
            BookType item = (BookType) this.jcb_bookType.getItemAt(i);
            if (item.getBookTypeName().equals(bookTypeName)) {
                this.jcb_bookType.setSelectedIndex(i);
            }
        }
        chubanshe.setText((String) bookTable.getValueAt(row, 7));
        copiesTxt1.setText((String) bookTable.getValueAt(row, 8));
        purchasePriceTxt.setText((String) bookTable.getValueAt(row, 9));
    }

    private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
        String bookName = this.s_bookNameTxt.getText();
        String author = this.s_authorTxt.getText();
        String sex = "";
        if (this.s_jrbman.isSelected()) {
            sex = "男";
        } else if (this.s_jrbfemale.isSelected()) {
            sex = "女";
        }
        BookType bookType = (BookType) this.s_jcbBookType.getSelectedItem();
        int bookTypeId = bookType.getId();

        Book book = new Book(bookName, author, sex, bookTypeId);

        this.fillTable(book);
        this.resetValue();

    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JTextField authorTxt;
    private javax.swing.JTextArea bookDescTxt;
    private javax.swing.JTextField bookNameTxt;
    private javax.swing.JTable bookTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_delete;
    private javax.swing.JButton jb_modify;
    private javax.swing.JButton jb_search;
    private javax.swing.JComboBox jcb_bookType;
    private javax.swing.JRadioButton jrb_female;
    private javax.swing.JRadioButton jrb_man;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JTextField s_authorTxt;
    private javax.swing.JTextField s_bookNameTxt;
    private javax.swing.JComboBox s_jcbBookType;
    private javax.swing.JRadioButton s_jrbfemale;
    private javax.swing.JRadioButton s_jrbman;
    private JLabel lblNewLabel;
    private JTextField purchasePriceTxt;
    private JLabel lblNewLabel_1;
    private JTextField copiesTxt1;
    private JLabel pressTxt;
    private JTextField chubanshe;
    // End of variables declaration//GEN-END:variables

}