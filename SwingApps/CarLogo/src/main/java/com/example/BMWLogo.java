package com.example;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BMWLogo extends JPanel {

    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        int radius1 = 200;
        int radius2 = 300;
        int x1 = centerX - radius1;
        int y1 = centerY - radius1;
        int x2 = centerX - radius2;
        int y2 = centerY - radius2;

        // Draw the first circle
        g.setColor(Color.BLACK);
        g.fillOval(x2, y2, radius2 * 2, radius2 * 2);

        // Draw the second circle
        g.drawOval(x1, y1, radius1 * 2, radius1 * 2);

        // Divide the second circle into 4 equal objects
        int angle = 0;
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLUE);
            }
            g.fillArc(x1, y1, radius1 * 2, radius1 * 2, angle, 90);
            angle += 90;
        }

        Graphics2D g2d = (Graphics2D) g;

        // Set the font and color for the string
        g2d.setFont(new Font("Arial", Font.BOLD, 105));
        g2d.setColor(Color.WHITE);
        
        g2d.rotate(Math.toRadians(-40), centerX, centerY);
        g2d.drawString("B", centerX - 54 , centerY - radius2 + 90);
        g2d.rotate(-Math.toRadians(-40), centerX, centerY);
        g2d.drawString("M", centerX - 54, centerY - radius2 + 90);
        g2d.rotate(Math.toRadians(40), centerX, centerY);
        g2d.drawString("W", centerX - 54, centerY - radius2 + 90);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BMW Logo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        BMWLogo circles = new BMWLogo();
        frame.add(circles);
        frame.setVisible(true);
    }

}