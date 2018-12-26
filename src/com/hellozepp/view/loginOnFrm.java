package com.hellozepp.view;

import com.hellozepp.dao.UserDao;
import com.hellozepp.model.Enum.UserTypeEnum;
import com.hellozepp.model.User;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginOnFrm extends JFrame {
    Logger log = Logger.getLogger(loginOnFrm.class);
    private JTextField userName;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JPasswordField password;
    private JRadioButton dianyuan;
    private JRadioButton guanliyuan;
    static loginOnFrm frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    frame = new loginOnFrm();
                    frame.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public loginOnFrm() throws InterruptedException {
        Font font = new Font("Dialog", Font.PLAIN, 12);
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, font);
            }
        }
        initComponents();
//		设置窗体居中
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 300, 529, 382);
        setResizable(false);//设置不可变大小

        final JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel lblNewLabel_1 = new JLabel("用户名：");
        lblNewLabel_1.setIcon(new javax.swing.ImageIcon(MainFrm.imagePath+"userName.png"));
        lblNewLabel_1.setBounds(149, 194, 76, 16);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("密   码：");
        lblNewLabel_2.setIcon(new javax.swing.ImageIcon(MainFrm.imagePath+"password.png"));
        lblNewLabel_2.setBounds(149, 242, 76, 16);
        panel.add(lblNewLabel_2);

        userName = new JTextField();
        userName.setBounds(237, 189, 130, 26);
        panel.add(userName);
        userName.setColumns(10);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (null == userName.getText() || "".equals(userName.getText())) {
                    JOptionPane.showMessageDialog(null, "用户名不能为空！");
                    return;
                }
                if (null == password.getText() || "".equals(password.getText())) {
                    JOptionPane.showMessageDialog(null, "密码不能为空！");
                    return;
                }
                User user = new User(userName.getText(), new String(password.getPassword()));
                 UserDao userDao = new UserDao();
                if(dianyuan.getModel().isSelected()) {
                    log.info("your choose the " + dianyuan.getText());
                     user.setUserType(UserTypeEnum.USER.getName());
                }else{
                      log.info("your choose the " + guanliyuan.getText());
                       user.setUserType(UserTypeEnum.ADMIN.getName());
                }

                try {
                    user = userDao.login(user);
                } catch (Exception e1) {
                    log.error("e:{}", e1);
                    JOptionPane.showMessageDialog(null, "报错了！");
                }
                if (user != null) {
                    frame.dispose();
                    new MainFrm(user).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "您输入的用户名或密码有误！");
                }
            }
        });
        btnNewButton.setIcon(new javax.swing.ImageIcon(MainFrm.imagePath+"login.png"));
        btnNewButton.setBounds(145, 309, 117, 29);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userName.setText("");
                password.setText("");
            }
        });
        btnNewButton_1.setIcon(new javax.swing.ImageIcon(MainFrm.imagePath+"reset.png"));
        btnNewButton_1.setBounds(274, 309, 117, 29);
        panel.add(btnNewButton_1);

        dianyuan = new JRadioButton("\u5E97\u5458\u5165\u53E3");
        dianyuan.setBounds(284, 280, 107, 23);
        panel.add(dianyuan);

        guanliyuan = new JRadioButton("\u7BA1\u7406\u5458\u5165\u53E3");
        guanliyuan.setSelected(true);
        guanliyuan.setBounds(149, 280, 95, 23);
        panel.add(guanliyuan);
        ButtonGroup group = new ButtonGroup();
        group.add(dianyuan);
        group.add(guanliyuan);

        JLabel lblNewLabel_4 = new JLabel(" ");
        lblNewLabel_4.setIcon(new javax.swing.ImageIcon(MainFrm.imagePath+"loginBanner.jpg"));
        lblNewLabel_4.setBounds(0, 5, 523, 174);
        panel.add(lblNewLabel_4);

        password = new JPasswordField();
        password.setBounds(237, 237, 130, 26);
        panel.add(password);

        setContentPane(panel);
    }
}
