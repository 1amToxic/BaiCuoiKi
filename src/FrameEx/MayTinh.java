package FrameEx;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MayTinh extends JFrame implements ActionListener{
    JPanel panel;
    int num1,num2,result;
    JTextField txt;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnEqual,btnAdd;
    public MayTinh(){
        txt = new JTextField();
        setLayout(new BorderLayout()); //layout frame
        add(txt,BorderLayout.NORTH);
        panel = new JPanel();
        btn1 = new JButton("1");btn1.addActionListener(this);
        btn2 = new JButton("2");btn2.addActionListener(this);
        btn3 = new JButton("3");btn3.addActionListener(this);
        btn4 = new JButton("4");btn4.addActionListener(this);
        btn5 = new JButton("5");btn5.addActionListener(this);
        btn6 = new JButton("6");btn6.addActionListener(this);
        btn7 = new JButton("7");btn7.addActionListener(this);
        btn8 = new JButton("8");btn8.addActionListener(this);
        btn9 = new JButton("9");btn9.addActionListener(this);
        btnAdd = new JButton("+");btnAdd.addActionListener(this);
        btn0 = new JButton("0");
        btnEqual = new JButton("=");btnEqual.addActionListener(this);
        panel.setLayout(new GridLayout(3,4));
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btnAdd);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btnEqual);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btn0);
        add(panel,BorderLayout.CENTER);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==btnAdd){
            String so1 = txt.getText();
            txt.setText("");
            num1 = Integer.parseInt(so1);
        }
        else if(e.getSource()==btnEqual){
            String so2 = txt.getText();
            num2 = Integer.parseInt(so2);
            result = num1+num2;
            txt.setText(String.valueOf(result));
        }
        else{
            String s = e.getActionCommand();
            txt.setText(txt.getText()+s);
        }
    }
}
