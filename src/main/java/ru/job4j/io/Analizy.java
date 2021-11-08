package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
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
                        writer.print(";" + twoData[1] + System.lineSeparator());
                    } else {
                        writer.print(";error" + System.lineSeparator());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sourceOne = "./data/analazy/sample_1.csv";
        String sourceTwo = "./data/analazy/sample_2.csv";
        String targetOne = "./data/analazy/result_1.csv";
        String targetTwo = "./data/analazy/result_2.csv";
        Analizy analise = new Analizy();
        analise.unavailable(sourceOne, targetOne);
        analise.unavailable(sourceTwo, targetTwo);
    }
}
