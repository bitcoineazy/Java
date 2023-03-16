package com.example;

import javax.swing.*;

public class App {
   public static void main(String[] args) {
      JFrame frame = new JFrame("HelloWorldSwing");
      JLabel label = new JLabel("Hello, World!");
      frame.getContentPane().add(label);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}