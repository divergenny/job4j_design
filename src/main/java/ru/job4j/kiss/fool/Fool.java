package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    private int startAt = 1;

    public int getStartAt() {
        return startAt;
    }

    public void setStartAt(int startAt) {
        this.startAt = startAt;
    }

    private void incrementStartAt() {
        startAt++;
    }

    private Boolean moduloRemainderByNumberIsEqualZero(int number, int byNumber) {
        return number % byNumber == 0;
    }

    protected String checkModBy3Or5(int startAt) {
        StringBuilder result = new StringBuilder();
        if (moduloRemainderByNumberIsEqualZero(startAt, 3)) {
            result.append("Fizz");
        }
        if (moduloRemainderByNumberIsEqualZero(startAt, 5)) {
            result.append("Buzz");
        }
        if (result.isEmpty()) {
            result.append(startAt);
        }
        return result.toString();
    }

    protected Boolean checkThatAnswerIsIncorrect(String answer) {
        if (!checkModBy3Or5(getStartAt()).equals(answer)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Fool game = new Fool();
        System.out.println("Игра FizzBuzz.");
        var input = new Scanner(System.in);
        while (game.getStartAt() < 100) {
            String resultOfCheckModBy3Or5 = game.checkModBy3Or5(game.getStartAt());
            System.out.println(resultOfCheckModBy3Or5);
            game.incrementStartAt();
            var answer = input.nextLine();
            if (game.checkThatAnswerIsIncorrect(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                game.setStartAt(0);
            }
            game.incrementStartAt();
        }
    }
}
