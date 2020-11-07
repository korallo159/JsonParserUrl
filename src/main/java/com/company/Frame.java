package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Frame extends JFrame implements ActionListener {
    static double result;
    static BufferedImage image;
    static BufferedImage image2;
    JTextField t1,t2,t3;
    JButton b1;
    public Frame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        JFrame f= new JFrame("Przelicznik waluty");
        f.setIconImage(imageURL());
        //Basics

        JLabel label = new JLabel("Podaj walute na jaka chcesz przeliczac");
        label.setBounds(20,20,300,20);
        t1=new JTextField("");
        t1.setBounds(50,50,150,20);
        JLabel label1 = new JLabel("Podaj z której waluty chcesz przeliczac");
        label1.setBounds(20, 80, 300, 20);
        t2=new JTextField();
        t2.setBounds(50,100,150,20);

        t3 = new JTextField("Wynik: ");
        t3.setBounds(50,150,150,20);
        t3.setEditable(false);

        b1= new JButton("Przelicz");
        b1.setBounds(50,200,150,50);
        b1.addActionListener(this);

        f.add(t1); f.add(t2); f.add(t3); f.add(b1); f.add(label); f.add(label1);
        //background
        JLabel labelbackground = new JLabel(new ImageIcon(imageURL2()));
        f.getContentPane().add(labelbackground);
        labelbackground.setSize(270,300);
        //
        f.setSize(270,330);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setResizable(true);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent e){
        String currency = t1.getText();
        String base = t2.getText();
        if(e.getSource() == b1){
           result = currencyApi.currentsApi(currency, base);
        }
        String resulttext = String.valueOf(result);
        t3.setText(resulttext);
    }

    public BufferedImage imageURL(){
        image = null;
        try {
            String path = "https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/14204202991579060769-512.png";
            URL url = new URL(path);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public BufferedImage imageURL2(){
        image2 = null;
        try {
            String path = "https://image.freepik.com/free-photo/pile-paper-euro-banknotes-as-part-united-country-s-payment-system_153977-12.jpg";
            URL url = new URL(path);
            image2 = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image2;
    }
}
