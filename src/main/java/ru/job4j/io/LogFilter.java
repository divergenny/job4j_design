package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            return in.lines().filter(line -> line.contains("404")).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void save(List<String> log, String file) {
        if (log != null && file.length() > 0) {
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            )) {
                for (var data : log) {
                    out.println(data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong input parameters!");
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("./data/log.txt");
        if (log != null) {
            for (String errorLog : log) {
                System.out.println(errorLog);
            }
        }
        save(log, "./data/404.txt");
    }
}
