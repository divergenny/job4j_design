package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    List<String> log = new ArrayList<>();
    SimpleDateFormat format = new SimpleDateFormat("dd:MM:yyyy HH:mm::ss");

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botPhrases = readPhrases();
        Scanner scanner = new Scanner(System.in);
        greeting();
        String question = scanner.nextLine();
        mainLoop:
        while (!OUT.equals(question)) {
            if (STOP.equals(question)) {
                while (!CONTINUE.equals(question)) {
                    question = scanner.nextLine();
                    logSaveWithTime(question, false);
                    if (OUT.equals(question)) {
                        break mainLoop;
                    }
                }
            }
            logSaveWithTime(question, false);
            logSaveWithTime(getRandomPhrase(botPhrases), true);
            question = scanner.nextLine();
        }
        goodBye();
        saveLog();
    }

    private String getRandomPhrase(List<String> botPhrases) {
        if (botPhrases.size() == 0) {
            return "No answers for you today!";
        }
        return botPhrases.get((int) (Math.random() * (botPhrases.size())));
    }

    private List<String> readPhrases() {
        File file = new File(this.botAnswers);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(this.path, Charset.forName("UTF-8"), false))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void greeting() {
        String greetMessage = "Здравствуй дорогой пользователь, пожалуйста, задай свой вопрос: ";
        logSaveWithTime(greetMessage, true);
    }

    private void goodBye() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        int currHours = Integer.parseInt(sdf.format(new Date()));
        String dayTime;
        String goodbyeMessage = "Было приятно пообщаться, хорошего Вам ";
        if (currHours < 11 && currHours > 1) {
            dayTime = "Утра!";
        } else if (currHours > 11 && currHours < 16) {
            dayTime = "Дня!";
        } else {
            dayTime = "Вечера!";
        }
        goodbyeMessage += dayTime;
        logSaveWithTime(goodbyeMessage, true);
    }

    private void logSaveWithTime(String message, boolean print) {
        log.add(format.format(Calendar.getInstance().getTime()) + " : " + message);
        if (print) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/consoleChat/log.txt", "./data/consoleChat/botAnswers.txt");
        cc.run();
    }
}
