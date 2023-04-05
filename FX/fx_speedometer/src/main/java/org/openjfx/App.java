package org.openjfx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

    public static final int CANVAS_WIDTH = 640;
    public static final int CANVAS_HEIGHT = 480;

    // variable used to draw speedometer needle below
    // updates on delay
    public int currentSpeed = 0;
    public boolean isIncreasing = true;

    private Canvas canvas;
    private GraphicsContext gc;

    Color green = Color.rgb(0, 255, 0);
    Color red = Color.rgb(255, 0, 0);

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        Group root = new Group();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Спидометр JavaFX");
        primaryStage.show();

        // Update screen each 50 milisec
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), e -> {
            // Increase speed to max then to min and again..
            if (isIncreasing) {
                currentSpeed += 1;
                if (currentSpeed > 260) {
                    isIncreasing = false;
                }
            } else {
                currentSpeed -= 1;
                if (currentSpeed < 0) {
                    isIncreasing = true;
                }
            }
            drawSpeedometer();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void drawSpeedometer() {
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        
        // Calculate the center of the clock
        int centerX = CANVAS_WIDTH / 2;
        int centerY = CANVAS_HEIGHT / 2;

        // Calculate the radius of the clock
        int radius = Math.min(centerX, centerY) - 20;

        // Draw the speedometer face
        gc.setFill(Color.WHITE);
        gc.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // Draw the speedometer markings
        for (int i = 0; i <= 160; i += 1) {
            double angle = (i * 1.6) * Math.PI / 180 - 2.3;
            int x1 = (int) (centerX + Math.sin(angle) * (radius - 4));
            int y1 = (int) (centerY - Math.cos(angle) * (radius - 4));
            int x2 = (int) (centerX + Math.sin(angle) * (radius - 11));
            int y2 = (int) (centerY - Math.cos(angle) * (radius - 11));
            gc.setStroke(Color.GRAY);
            gc.setLineWidth(2);
            gc.strokeLine(x1, y1, x2, y2);

            if (i % 20 == 0) {
                x1 = (int) (centerX + Math.sin(angle) * (radius - 10));
                y1 = (int) (centerY - Math.cos(angle) * (radius - 10));
                x2 = (int) (centerX + Math.sin(angle) * (radius - 30));
                y2 = (int) (centerY - Math.cos(angle) * (radius - 30));
                gc.setFill(Color.BLACK);
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(3);
                gc.strokeLine(x1, y1, x2, y2);
                gc.setFont(new Font("Arial", 20));
                String number = Integer.toString(i);
                double stringWidth = gc.getFont().getSize() * number.length() / 2;
                double stringHeight = gc.getFont().getSize();
                double x = centerX + Math.sin(angle) * (radius - 50) - stringWidth;
                double y = centerY - Math.cos(angle) * (radius - 50) + stringHeight / 2;
                gc.fillText(number, x, y);
            } else if (i % 10 == 0) {
                x1 = (int) (centerX + Math.sin(angle) * (radius - 8));
                y1 = (int) (centerY - Math.cos(angle) * (radius - 8));
                x2 = (int) (centerX + Math.sin(angle) * (radius - 23));
                y2 = (int) (centerY - Math.cos(angle) * (radius - 23));
                gc.setFill(Color.BLACK);
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(2);
                gc.strokeLine(x1, y1, x2, y2);
                gc.setFont(new Font("Arial", 14));
                String number = Integer.toString(i);
                double stringWidth = gc.getFont().getSize() * number.length() / 2;
                double stringHeight = gc.getFont().getSize();
                double x = centerX + Math.sin(angle) * (radius - 45) - stringWidth;
                double y = centerY - Math.cos(angle) * (radius - 45) + stringHeight / 2;
                gc.fillText(number, x, y);
            }
        }
        
        // // Draw current speed
        // gc.setFill(Color.BLACK);
        // gc.setFont(new Font("Arial", 30));
        // gc.fillText(Integer.toString(currentSpeed), centerX - 25, centerY + 120);

        double boxWidth = 80;
        double boxHeight = 40;
        double boxX = centerX - boxWidth / 2;
        double boxY = centerY + 100;

        double percent = (double) currentSpeed / 240; // определяем процент текущей скорости от максимальной

        Color currentColor = green.interpolate(red, percent); // создаем плавный переход между зеленым и красным цветами на основе процента

        gc.setFill(currentColor);
        gc.fillRect(boxX, boxY, boxWidth, boxHeight);

        // gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        // gc.fillRect(boxX, boxY, boxWidth, boxHeight);
        gc.strokeRect(boxX, boxY, boxWidth, boxHeight);

        double textX = boxX + boxWidth / 2 - 25;
        double textY = boxY + boxHeight / 2 + 10;
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 30));
        gc.fillText(Integer.toString((int) Math.round(currentSpeed / 1.6)), textX, textY);

        

        // Draw the speedometer needle
        double speedAngle = 450 + (currentSpeed) * 1 * Math.PI / 180;
        int needleX = (int) (centerX + Math.sin(speedAngle) * (radius - 70));
        int needleY = (int) (centerY - Math.cos(speedAngle) * (radius - 70));
        gc.setStroke(currentColor);
        gc.setLineWidth(5);
        gc.strokeLine(centerX, centerY, needleX, needleY);

        // Draw red circle in center like in real car speedometers
        gc.setFill(currentColor);
        int centerCircleRadius = radius / 14;
        gc.fillOval(centerX - centerCircleRadius, centerY - centerCircleRadius, centerCircleRadius * 2, centerCircleRadius * 2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}