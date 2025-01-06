package ru.job4j.algo.hash;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestUniqueSubstring {

    /**
     * Метод находит самую длинную подстроку состоящую из уникальных элементов.
     * O(n) = n * (n * logN + logN) + n = N^2logN
     * Объём используемой памяти в виде зависимости от длины строки: O(m), где m - длина входящей строки
     *
     * @param str строка
     * @return самая длинная подстрока состоящая из уникальных элементов
     */
    public static String longestUniqueSubstring(String str) {
        Set<Character> resultUC = new LinkedHashSet<Character>();
        Set<Character> uniqueCharacters = new LinkedHashSet<Character>();
        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            while (uniqueCharacters.contains(str.charAt(right))) {
                Character leftChar = str.charAt(left);
                uniqueCharacters.remove(leftChar);
                left += 1;
            }
            uniqueCharacters.add(str.charAt(right));
            resultUC = (right - left + 1) > resultUC.size() ? new LinkedHashSet<Character>(uniqueCharacters) : resultUC;
        }
        StringBuilder rslString = new StringBuilder();
        for (Character ch : resultUC) {
            rslString.append(ch);
        }
        return rslString.toString();
    }
}
