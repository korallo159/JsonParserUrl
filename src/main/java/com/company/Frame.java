package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame implements ActionListener {
    String week[]= { "Monday","Tuesday","Wednesday",
            "Thursday","Friday","Saturday","Sunday"};
    static double result;
    JTextField t1,t2,t3;
    JButton b1,b2;
    public Frame() {
        JFrame f= new JFrame("Przelicznik waluty");
        JLabel label = new JLabel("Podaj z której waluty chcesz przeliczac");
        label.setBounds(20,20,300,20);
        t1=new JTextField("");
        t1.setBounds(50,50,150,20);

        JLabel label1 = new JLabel("Podaj walute na jaką chcesz przeliczać");
        label1.setBounds(20, 80, 300, 20);
        t2=new JTextField();
        t2.setBounds(50,100,150,20);

        t3 = new JTextField("Wynik: ");
        t3.setBounds(50,150,150,20);
        t3.setEditable(false);

        b1= new JButton("Przelicz");
        b1.setBounds(50,200,50,50);
        b1.addActionListener(this);

        f.add(t1); f.add(t2); f.add(t3); f.add(b1); f.add(label); f.add(label1);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent e){
        String currency = t1.getText();
        String base = t2.getText();
        if(e.getSource() == b1){
           result = Main.currentsApi(currency, base);
        }
        String resulttext = String.valueOf(result);
        t3.setText(resulttext);
    }
}
