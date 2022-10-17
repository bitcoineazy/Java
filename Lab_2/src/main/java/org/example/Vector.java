package org.example;

import java.util.Arrays;

public class Vector {

    public static double[] createVector(int x, int y, int z) {
        return new double[]{x, y, z};
    }

    public static double scalarProduct(double[] v1, double[] v2) {
        int sum = 0;
        for (int i = 0; i < v1.length; i++) {
            sum += v1[i] * v2[i];
        }
        return sum;
    }

    public static double[] vectorProduct(double[] v1, double[] v2){
        return new double[]{v1[1]*v2[2]-v1[2]*v2[1], v1[2]*v2[0]-v1[0]*v2[2], v1[0]*v2[1]-v1[1]*v2[0]};
    }

    public static double[] additionVector(double[] v1, double[] v2){
        return new double[]{v1[0]+v2[0], v1[1]+v2[1], v1[2]+v2[2]};
    }

    public static double[] subtractionVector(double[] v1, double[] v2){
        return new double[]{v1[0]-v2[0], v1[1]-v2[1], v1[2]-v2[2]};
    }

    public static double moduleVector(double[] v){
        double[] vsq = new double[]{(int) Math.pow(v[0], 2), (int) Math.pow(v[1], 2), (int) Math.pow(v[2], 2)};
        double sum = 0;
        for (double j : vsq) {
            sum += j;
        }
        sum = Math.sqrt(sum);
        return sum;
    }

    public static double angleBetweenVectors(double[] v1, double[] v2){
        double sc = scalarProduct(v1, v2);
        double pr = moduleVector(v1) * moduleVector(v2);
        return Math.acos(sc/pr);
    }

    public static void main(String[] args) {
        double[] v1 = createVector(1, 2, 3);
        double[] v2 = createVector(1, 1, 1);
        double sumS = scalarProduct(v1, v2);
        double[] sumV = vectorProduct(v1, v2);
        double[] sumV2 = additionVector(v1, v2);
        double[] subV = subtractionVector(v1, v2);
        double mod = moduleVector(v1);
        double angle = angleBetweenVectors(v1, v2) * (180/Math.PI);

        System.out.println("V1: " + Arrays.toString(v1));
        System.out.println("V2: " + Arrays.toString(v2));
        System.out.println("sum scalar: " + sumS);
        System.out.println("vector sum: " + Arrays.toString(sumV));
        System.out.println("sum vector: " + Arrays.toString(sumV2));
        System.out.println("subst vector: " + Arrays.toString(subV));
        System.out.println("mod vector: " + mod);
        System.out.println("angle between vector: " + angle);
    }
}