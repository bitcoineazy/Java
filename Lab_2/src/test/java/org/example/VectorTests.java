package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTests {
    @Test
    @DisplayName("testing (MyClassApp.scalarProduct)")
    void testScalarProduct()
    {
        double[] v1 = Vector.createVector(1, 2, 3);
        double[] v2 = Vector.createVector(1, 1, 1);
        assertEquals(6, Vector.scalarProduct(v1, v2));
    }
    @Test
    @DisplayName("testing (MyClassApp.vectorProduct)")
    void testVectorProduct()
    {
        double[] v1 = Vector.createVector(1, 2, 3);
        double[] v2 = Vector.createVector(1, 1, 1);
        int[] v3 = new int[] {-1, 2, -1};

        assertEquals(Arrays.toString(v3), Arrays.toString(Vector.vectorProduct(v1, v2)));
    }
    @Test
    @DisplayName("testing (MyClassApp.additionVector)")
    void testAdditionVector()
    {
        double[] v1 = Vector.createVector(1, 2, 3);
        double[] v2 = Vector.createVector(1, 1, 1);
        int[] v3 = new int[] {2, 3, 4};
        assertEquals(Arrays.toString(v3), Arrays.toString(Vector.additionVector(v1, v2)));
    }
    @Test
    @DisplayName("testing (MyClassApp.subtractionVector)")
    void testSubtractionVector()
    {
        double[] v1 = Vector.createVector(1, 2, 3);
        double[] v2 = Vector.createVector(1, 1, 1);
        double[] v3 = Vector.createVector(0, 1, 2);
        assertEquals(Arrays.toString(v3), Arrays.toString(Vector.subtractionVector(v1, v2)));
    }
    @Test
    @DisplayName("testing (MyClassApp.moduleVector)")
    void testModuleVector()
    {
        double[] v1 = Vector.createVector(1, 2, 3);
        double t = 3.7416573867739413;
        assertEquals(Vector.moduleVector(v1), t);
    }
    @Test
    @DisplayName("testing (MyClassApp.angleBetweenVectors)")
    void testAngleBetweenVectors()
    {
        double[] v1 = Vector.createVector(1, 2, 3);
        double[] v2 = Vector.createVector(1, 1, 1);
        double t = 22.207654298596477;
        assertEquals(Vector.angleBetweenVectors(v1, v2) * (180 / Math.PI), t);
    }
}