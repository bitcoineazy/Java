package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {
    public static final int CANVAS_WIDTH = 640;
    public static final int CANVAS_HEIGHT = 480;

    // variable used to draw speedometer needle below
    // updates on delay
    public int currentSpeed = 0;

    private DrawCanvas canvas;

    public Main() {
        canvas = new DrawCanvas(); 
        int delay = 50; 

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                currentSpeed += 10;
                if (currentSpeed > 260) {
                    currentSpeed = 0;
                }
                canvas.repaint();
            }
        };

        // Update screen each 50 milisec
        new Timer(delay, taskPerformer).start();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH,
                CANVAS_HEIGHT));

        Container cp = getContentPane();
        cp.add(canvas);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.pack(); 
        this.setTitle("Спидометр");
        this.setVisible(true);  
    }

    private class DrawCanvas extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            setBackground(Color.WHITE);

            BasicStroke lineBold = new BasicStroke(3);
            BasicStroke lineThin = new BasicStroke(2);

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(lineBold);  // Set line thickness

            // Calculate the center of the clock
            int centerX = CANVAS_WIDTH / 2;
            int centerY = CANVAS_HEIGHT / 2;

            // Calculate the radius of the clock
            int radius = Math.min(centerX, centerY) - 20;

            // Draw the clock face
            g.setColor(Color.BLACK);
            g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

            // Draw the speedometer face
            g.setColor(Color.WHITE);
            g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
            g.setColor(Color.BLACK);
            g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

            // Draw the speedometer markings
            for (int i = 0; i <= 160; i += 1) {
                g.setColor(Color.GRAY);
                g2.setStroke(lineThin);
                double angle = (i * 1.6) * Math.PI / 180 - 2.3;
                int x1 = (int) (centerX + Math.sin(angle) * (radius - 4));
                int y1 = (int) (centerY - Math.cos(angle) * (radius - 4));
                int x2 = (int) (centerX + Math.sin(angle) * (radius - 11));
                int y2 = (int) (centerY - Math.cos(angle) * (radius - 11));
                g.drawLine(x1, y1, x2, y2);
                g.setColor(Color.BLACK);
                g2.setStroke(lineBold);
                if (i % 20 == 0) {
                    x1 = (int) (centerX + Math.sin(angle) * (radius - 10));
                    y1 = (int) (centerY - Math.cos(angle) * (radius - 10));
                    x2 = (int) (centerX + Math.sin(angle) * (radius - 30));
                    y2 = (int) (centerY - Math.cos(angle) * (radius - 30));
                    g.drawLine(x1, y1, x2, y2);
                    Font font = new Font("Arial", Font.BOLD, 20); 
                    g.setFont(font);
                    String number = Integer.toString(i);
                    FontMetrics fm = g.getFontMetrics();
                    int stringWidth = fm.stringWidth(number);
                    int stringHeight = fm.getHeight();
                    int x = (int) (centerX + Math.sin(angle) * (radius - 50) - stringWidth / 2);
                    int y = (int) (centerY - Math.cos(angle) * (radius - 50) + stringHeight / 2);
                    g.drawString(number, x, y);
                } else if (i % 10 == 0) {
                    x1 = (int) (centerX + Math.sin(angle) * (radius - 8));
                    y1 = (int) (centerY - Math.cos(angle) * (radius - 8));
                    x2 = (int) (centerX + Math.sin(angle) * (radius - 23));
                    y2 = (int) (centerY - Math.cos(angle) * (radius - 23));
                    g.drawLine(x1, y1, x2, y2);
                    Font font = new Font("Arial", Font.BOLD, 14);
                    g.setFont(font);
                    String number = Integer.toString(i);
                    FontMetrics fm = g.getFontMetrics();
                    int stringWidth = fm.stringWidth(number);
                    int stringHeight = fm.getHeight();
                    int x = (int) (centerX + Math.sin(angle) * (radius - 45) - stringWidth / 2);
                    int y = (int) (centerY - Math.cos(angle) * (radius - 45) + stringHeight / 2);
                    g.drawString(number, x, y);
                } 
            }

            // Draw the speedometer needle
            double speedAngle = 450 + (currentSpeed) * 1 * Math.PI / 180;
            int needleX = (int) (centerX + Math.sin(speedAngle) * (radius - 70));
            int needleY = (int) (centerY - Math.cos(speedAngle) * (radius - 70));
            g.setColor(Color.RED);
            g.drawLine(centerX, centerY, needleX, needleY);
            
            // Draw red circle in center like in real car speedometers
            g.setColor(Color.RED);
            int centerCircleRadius = radius / 14;
            g.fillOval(centerX - centerCircleRadius, centerY - centerCircleRadius, centerCircleRadius * 2, centerCircleRadius * 2);

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}