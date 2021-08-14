package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("./data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            int[] numbers = new int[lines.length];
            int itr = 0;
            for (String line : lines) {
                numbers[itr++] = Integer.parseInt(line);
            }
            for (int number : numbers) {
                if (number % 2 == 0) {
                    System.out.println(number);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
