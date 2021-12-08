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

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        String timeStamp = "";
        validatePath(this.path);
        validatePath(this.botAnswers);
        List<String> botPhrases = readPhrases();
        List<String> log = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String question = "";
        while (!OUT.equals(question)) {
            timeStamp = new SimpleDateFormat("dd:MM:yyyy HH::mm::ss")
                    .format(Calendar.getInstance().getTime());
            question = greeting(scanner, log, timeStamp);
            log.add(question + ", " + timeStamp);
            if (STOP.equals(question)) {
                while (!CONTINUE.equals(question)) {
                    question = scanner.nextLine();
                    timeStamp = new SimpleDateFormat("dd:MM:yyyy HH::mm::ss")
                            .format(Calendar.getInstance().getTime());
                    log.add(question + ", " + timeStamp);
                    if (OUT.equals(question)) {
                        question = STOP;
                        break;
                    }
                }
            }
            if (STOP.equals(question)) {
                break;
            }
            String phrase = getRandomPhrase(botPhrases);
            log.add(phrase + ", " + timeStamp);
            System.out.println(phrase);
        }
        System.out.println(goodBye(log, timeStamp));
        saveLog(log);
    }

    private String getRandomPhrase(List<String> botPhrases) {
        if (botPhrases.size() == 0) {
            return "No answers for you today!";
        }
        return botPhrases.get((int) (Math.random() * (botPhrases.size())));
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void validatePath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(this.path, Charset.forName("UTF-8"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String greeting(Scanner scanner, List<String> log, String currTime) {
        String greetMessage = "Здравствуй дорогой пользователь, пожалуйста, задай свой вопрос: ";
        System.out.println(greetMessage);
        log.add(greetMessage + ", " + currTime);
        return scanner.nextLine();
    }

    private String goodBye(List<String> log, String currTime) {
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
        log.add(goodbyeMessage + ", " + currTime);
        return goodbyeMessage;
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/consoleChat/log.txt", "./data/consoleChat/botAnswers.txt");
        cc.run();
    }
}
