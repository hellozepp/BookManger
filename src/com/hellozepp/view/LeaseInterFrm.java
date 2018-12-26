/*
 * BookManageInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.hellozepp.view;

import com.hellozepp.dao.BookDao;
import com.hellozepp.dao.BookTypeDao;
import com.hellozepp.dao.LeaseDao;
import com.hellozepp.model.Book;
import com.hellozepp.model.BookType;
import com.hellozepp.model.Lease;
import com.hellozepp.util.DbUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

/**
 * @author __USER__
 */
public class LeaseInterFrm extends javax.swing.JInternalFrame {
    DbUtil dbUtil = new DbUtil();
    LeaseDao leaseDao = new LeaseDao();

    /**
     * Creates new form BookManageInterFrm
     */
    public LeaseInterFrm() {
        initComponents();
        this.setLocation(200, 50);
        this.fillTable();
    }

    private void fillTable() {
        DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            List<Lease> leaseList = leaseDao.getLeaseList();
//            "ͼ����", "Ѻ��", "���޼۸�", "�����ֻ���", "��Ա", "����ʱ��"
            for (Lease lease : leaseList) {
                 Vector v = new Vector();
                 v.add(lease.getId());
                 v.add(lease.getDeposit());
                 v.add(lease.getPrice());
                 v.add(lease.getPhoneNumber());
                 v.add(lease.getEmployee());
                 v.add(lease.getLeaseTime());
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

        setClosable(true);
        setIconifiable(true);
        setTitle("\u79DF\u8D41\u4FE1\u606F");

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ͼ����", "Ѻ��", "���޼۸�", "�����ֻ���", "��Ա", "����ʱ��"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(bookTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>



    private javax.swing.JTable bookTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}