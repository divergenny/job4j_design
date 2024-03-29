package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    
    protected static String generateString(int startAt) {
        StringBuilder result = new StringBuilder();
        if (startAt % 3 == 0) {
            result.append("Fizz");
        }
        if (startAt % 5 == 0) {
            result.append("Buzz");
        }
        if (result.isEmpty()) {
            result.append(startAt);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(generateString(startAt));
            startAt++;
            var answer = input.nextLine();
            if (!generateString(startAt).equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }
}
