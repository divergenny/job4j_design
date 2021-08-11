package ru.job4j.io;

public class Matrix {
    public static int[][] multiple(int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                matrix[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return matrix;
    }

    public static void showMatrix(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int cell = 0; cell < array.length; cell++) {
                System.out.print(array[row][cell] + "\t");
            }
            System.out.println();
        }
    }
}
