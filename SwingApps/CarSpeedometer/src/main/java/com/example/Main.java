package com.example;

import java.util.Calendar;

import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Класс главного окна, который содержит холст для рисования
 */
public class Main extends JFrame {
    // Задаем фиксированные размеры окна
    public static final int CANVAS_WIDTH = 640;

    public static final int CANVAS_HEIGHT = 480;

    // Холст для рисования
    private DrawCanvas canvas;

    // Инициализая Swing-объектов для вывода изображения
    public Main() {
        canvas = new DrawCanvas(); // Создаем новый холст
        int delay = 1000; // milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                canvas.repaint();
            }
        };
        new Timer(delay, taskPerformer).start();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH,
                CANVAS_HEIGHT));
        // Задаем размер холста
        // Получаем ссылку на главный холст фрейма (гдавного окна приложения)
        Container cp = getContentPane();
        // Добавляем на него созданный холст
        cp.add(canvas);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Определяем действие на кнопку "закрыть"
        this.pack(); // Размещаем компоненты и задаем размер окна
        this.setTitle("Спидометр"); // Заголовок главного окна
        this.setVisible(true); // Визуализация фрейма (гдавного окна приложения)
    }

    /**
     * Холст (JPanel) для рисования - определяем как внутренний класс
     */
    private class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            setBackground(Color.WHITE); // Set the background color

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
                // Draw big numbers
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
                    Font font = new Font("Arial", Font.BOLD, 20); // Create a font with size 16 and bold style
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
                    Font font = new Font("Arial", Font.BOLD, 14); // Create a font with size 16 and bold style
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

            // // Draw the speedometer needle
            // double speedAngle = (360 / 10.0) * 8 * Math.PI / 180;
            // int needleX = (int) (centerX + Math.sin(speedAngle) * (radius - 50));
            // int needleY = (int) (centerY - Math.cos(speedAngle) * (radius - 50));
            // g.setColor(Color.RED);
            // g.drawLine(centerX, centerY, needleX, needleY);
        }
    }

    /** в main создаем экземпляр приложения */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main(); // Вызываем конструктор класса главного окна
            }
        });
    }
}