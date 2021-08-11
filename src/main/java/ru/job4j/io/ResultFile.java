package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        int[][] multiplicationTable = Matrix.multiple(6);
        try (FileOutputStream out = new FileOutputStream("data/multiplicationTable.txt")) {
            for (int row = 0; row < multiplicationTable.length; row++) {
                for (int cell = 0; cell < multiplicationTable.length; cell++) {
                    out.write((multiplicationTable[row][cell] + "\t").getBytes());
                }
                out.write("\n".getBytes());
            }
            System.out.println("Successfully done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
