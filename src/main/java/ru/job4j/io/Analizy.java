package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            PrintWriter writer = new PrintWriter(new FileOutputStream(target));
            while (read.ready()) {
                String line = read.readLine();
                String[] twoData = line.split(" ");
                if (twoData[0].contains("400") || twoData[0].contains("500")) {
                    writer.print(twoData[1]);
                    boolean statusChanged = twoData[0].contains("200") || twoData[0].contains("300");
                    while (read.ready() && !statusChanged) {
                        line = read.readLine();
                        twoData = line.split(" ");
                        statusChanged = twoData[0].contains("200") || twoData[0].contains("300");
                    }
                    if (statusChanged) {
                        writer.println(";" + twoData[1]);
                    } else {
                        writer.println(";error");
                    }
                }
            }
            read.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
