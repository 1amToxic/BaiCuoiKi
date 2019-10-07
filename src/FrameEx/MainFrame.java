package FrameEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ItemListener{
    JButton btnSearch;
    JTextField txt;
    JComboBox cbb;
    JPanel panel;
    public MainFrame(){
        setSize(300,400); //set kich thuoc
        setLayout(new BorderLayout());
//        btnSearch = new JButton("Search");
//        btnSearch.setSize(100, 50);
//        txt = new JTextField("asdkjasdhkjhskjadf");
//        txt.setSize(100, 60);
//        add(btnSearch);
//        add(txt);
        init();
        add(panel,BorderLayout.CENTER);
         //them su kien vao combobox
        add(cbb,BorderLayout.SOUTH);
        sukien();
        setVisible(true); //cho phep hien thi
        setLocationRelativeTo(null); // cho ra giua man hinh
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cho phim tat
    }
    public void init(){
        panel = new JPanel();
        cbb = new JComboBox();
        cbb.addItem("Xanh"); //them item
        cbb.addItem("Do");
        cbb.addItem("Vang");
        cbb.addItem("Cam");
    }
    public void sukien(){
        cbb.addItemListener(this);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String color = (String) cbb.getSelectedItem();
        if(color.equals("Xanh")) panel.setBackground(Color.GREEN);
        if(color.equals("Do")) panel.setBackground(Color.RED);
        if(color.equals("Vang")) panel.setBackground(Color.YELLOW);
        if(color.equals("Cam")) panel.setBackground(Color.ORANGE);
    }
}
