/*
 * BookTypeManageInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.hellozepp.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.hellozepp.dao.BookDao;
import com.hellozepp.dao.BookTypeDao;
import com.hellozepp.model.BookType;
import com.hellozepp.util.DbUtil;
import com.hellozepp.util.StringUtil;

/**
 *
 * @author  __USER__
 */
public class BookTypeManageInterFrm extends javax.swing.JInternalFrame {
	DbUtil dbUtil = new DbUtil();
	BookTypeDao bookTypeDao = new BookTypeDao();
	BookDao bookDao = new BookDao();

	/** Creates new form BookTypeManageInterFrm */
	public BookTypeManageInterFrm() {
		initComponents();
		this.setLocation(200, 50);
		this.fillTable(new BookType());
	}

	private void fillTable(BookType bookType) {
		DefaultTableModel dtm = (DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.bookTypeList(con, bookType);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
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

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		s_bookTypeNameTxt = new javax.swing.JTextField();
		jb_search = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		bookTypeTable = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		idTxt = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		bookTypeNameTxt = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		bookTypeDescTxt = new javax.swing.JTextArea();
		jb_modify = new javax.swing.JButton();
		jb_delete = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u56fe\u4e66\u7c7b\u522b\u7ef4\u62a4");

		jLabel1.setText("\u56fe\u4e66\u7c7b\u522b\u540d\u79f0\uff1a");

		jb_search.setIcon(new javax.swing.ImageIcon(
				MainFrm.imagePath+"search.png"));
		jb_search.setText("\u67e5\u8be2");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_searchActionPerformed(evt);
			}
		});

		bookTypeTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "编号", "图书类别名称", "图书类别描述" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		bookTypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				bookTypeTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(bookTypeTable);

		jPanel1.setBorder(javax.swing.BorderFactory
				.createTitledBorder("\u8868\u5355\u64cd\u4f5c"));

		jLabel2.setText("\u7f16\u53f7\uff1a");

		idTxt.setEditable(false);

		jLabel3.setText("\u56fe\u4e66\u7c7b\u522b\u540d\u79f0\uff1a");

		jLabel4.setText("\u63cf\u8ff0\uff1a");

		bookTypeDescTxt.setColumns(20);
		bookTypeDescTxt.setRows(5);
		jScrollPane2.setViewportView(bookTypeDescTxt);

		jb_modify.setIcon(new javax.swing.ImageIcon(
				MainFrm.imagePath+"modify.png"));
		jb_modify.setText("\u4fee\u6539");
		jb_modify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_modifyActionPerformed(evt);
			}
		});

		jb_delete.setIcon(new javax.swing.ImageIcon(
				MainFrm.imagePath+"delete.png"));
		jb_delete.setText("\u5220\u9664");
		jb_delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_deleteActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel4)
																						.addGap(
																								18,
																								18,
																								18)
																						.addComponent(
																								jScrollPane2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								324,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel2)
																						.addGap(
																								18,
																								18,
																								18)
																						.addComponent(
																								idTxt,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								85,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(
																								18,
																								18,
																								18)
																						.addComponent(
																								jLabel3)
																						.addGap(
																								18,
																								18,
																								18)
																						.addComponent(
																								bookTypeNameTxt)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jb_modify)
																		.addGap(
																				37,
																				37,
																				37)
																		.addComponent(
																				jb_delete)))
										.addContainerGap(6, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																idTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel3)
														.addComponent(
																bookTypeNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel4)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																106,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jb_modify)
														.addComponent(jb_delete))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(29, 29, 29)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				38,
																				38,
																				38)
																		.addComponent(
																				jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				s_bookTypeNameTxt,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				149,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				24,
																				24,
																				24)
																		.addComponent(
																				jb_search))
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																408,
																Short.MAX_VALUE)
														.addComponent(jPanel1,
																0, 408,
																Short.MAX_VALUE))
										.addContainerGap(37, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(jb_search)
														.addComponent(
																s_bookTypeNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(30, 30, 30)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												141,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jb_modifyActionPerformed(java.awt.event.ActionEvent evt) {
		String id = this.idTxt.getText();
		String bookTypeName=this.bookTypeNameTxt.getText();
		String bookTypeDesc=this.bookTypeDescTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		BookType bookType=new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = bookTypeDao.bookTypeModify(con, bookType);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new BookType());
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
				boolean flag=bookDao.getBookByBookTypeId(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null, "当前图书类别下有图书，不能删除此类别！");
					return;
				}
				int deleteNum = bookTypeDao.bookTypeDelete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new BookType());
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
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}

	private void bookTypeTableMousePressed(java.awt.event.MouseEvent evt) {
		// 获取选中的行
		int row = bookTypeTable.getSelectedRow();
		this.idTxt.setText((String) bookTypeTable.getValueAt(row, 0));
		this.bookTypeNameTxt.setText((String) bookTypeTable.getValueAt(row, 1));
		this.bookTypeDescTxt.setText((String) bookTypeTable.getValueAt(row, 2));
	}

	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
		String s_bookTypeName = this.s_bookTypeNameTxt.getText();
		BookType bookType = new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.fillTable(bookType);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea bookTypeDescTxt;
	private javax.swing.JTextField bookTypeNameTxt;
	private javax.swing.JTable bookTypeTable;
	private javax.swing.JTextField idTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_delete;
	private javax.swing.JButton jb_modify;
	private javax.swing.JButton jb_search;
	private javax.swing.JTextField s_bookTypeNameTxt;
	// End of variables declaration//GEN-END:variables

}