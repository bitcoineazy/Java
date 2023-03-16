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
public class SimpleGraphicExample extends JFrame {
    // Задаем фиксированные размеры окна
    public static final int CANVAS_WIDTH = 640;

    public static final int CANVAS_HEIGHT = 480;

    // Холст для рисования
    private DrawCanvas canvas;

    // Инициализая Swing-объектов для вывода изображения
    public SimpleGraphicExample() {
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
        this.setTitle("Компьютерная графика"); // Заголовок главного окна
        this.setVisible(true); // Визуализация фрейма (гдавного окна приложения)
    }

    /**
     * Холст (JPanel) для рисования - определяем как внутренний класс
     */
    private class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            // super.paintComponent(g);

            // setBackground(Color.WHITE); // Устанавливаем цвет фона холста

            // // Координаты "первой" точки стрелки
            // final int X = 200;
            // final int Y = 200;
            // // Координаты 4 точек первой стрелки
            // int[] x = { X, X, X - 10, X + 10 };
            // int[] y = { Y, Y + 30, Y + 20, Y + 20 };
            // // Угол 6 градусов
            // final int phi = 24;
            // final double a = phi * Math.PI / 180;
            // // Цвет стрелки
            // g.setColor(Color.BLUE);
            // for (int i = 0; i < 15; i++) {
            //     int j;
            //     // Рисуем стрелку
            //     for (j = 0; j < 3; j++) {
            //         g.drawLine(x[j], y[j], x[j + 1], y[j + 1]);
            //     }
            //     g.drawLine(x[3], y[3], x[1], y[1]);
            //     // Поворачиваем на 6 градусов
            //     for (j = 0; j <= 3; j++) {
            //         int XX = x[j];
            //         int YY = y[j];
            //         x[j] = (int) (XX * Math.cos(a) - YY * Math.sin(a));
            //         y[j] = (int) (XX * Math.sin(a) + YY * Math.cos(a));
            //     }
            // }
            super.paintComponent(g);

            setBackground(Color.WHITE); // Set the background color

            // Get the current time
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);

            // Calculate the center of the clock
            int centerX = CANVAS_WIDTH / 2;
            int centerY = CANVAS_HEIGHT / 2;

            // Calculate the radius of the clock
            int radius = Math.min(centerX, centerY) - 20;

            // Draw the clock face
            g.setColor(Color.BLACK);
            g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

            // Draw the hour markers
            for (int i = 1; i <= 12; i++) {
                double angle = i * Math.PI / 6;
                int x = (int) (centerX + Math.sin(angle) * (radius - 10));
                int y = (int) (centerY - Math.cos(angle) * (radius - 10));
                g.fillOval(x - 5, y - 5, 10, 10);
            }

            // Draw the hour hand
            double hourAngle = (hour + minute / 60.0) * Math.PI / 6;
            int hourX = (int) (centerX + Math.sin(hourAngle) * (radius - 50));
            int hourY = (int) (centerY - Math.cos(hourAngle) * (radius - 50));
            g.drawLine(centerX, centerY, hourX, hourY);
            g.setColor(Color.RED);

            // Draw the minute hand
            double minuteAngle = minute * Math.PI / 30;
            int minuteX = (int) (centerX + Math.sin(minuteAngle) * (radius - 30));
            int minuteY = (int) (centerY - Math.cos(minuteAngle) * (radius - 30));
            g.setColor(Color.BLUE);
            g.drawLine(centerX, centerY, minuteX, minuteY);

            // Draw the second hand
            double secondAngle = second * Math.PI / 30;
            int secondX = (int) (centerX + Math.sin(secondAngle) * (radius - 10));
            int secondY = (int) (centerY - Math.cos(secondAngle) * (radius - 10));
            g.setColor(Color.GREEN);
            g.drawLine(centerX, centerY, secondX, secondY);
        }
    }

    /** в main создаем экземпляр приложения */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleGraphicExample(); // Вызываем конструктор класса главного окна
            }
        });
    }
}