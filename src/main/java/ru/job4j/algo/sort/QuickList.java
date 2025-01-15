package ru.job4j.algo.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Реализован алгоритм быстрой сортировки учёного Тони Хоара (1960 год), который может работать с коллекцией,
 * реализующий java.util.List и для сравнения принимающий компаратор.
 * Важно помнить про метод compare - объекта comparator, который реализует интерфейс Comparator<T>:
 * int compare(T o1, T o2) - Метод сравнивает два объекта a и b и возвращает:
 * 1) Положительное число, если a > b;
 * 2) Ноль, если a == b;
 * 3) Отрицательное число, если a < b.
 */
public class QuickList {
    public static <T> void quickSort(List<T> sequence, Comparator<T> comparator) {
        quickSort(sequence, 0, sequence.size() - 1, comparator);
    }

    private static <T> void quickSort(List<T> sequence, int start, int end, Comparator<T> comparator) {
        if (start >= end) {
            return;
        }
        int divideIndex = breakPartition(sequence, start, end, comparator);
        quickSort(sequence, start, divideIndex - 1, comparator);
        quickSort(sequence, divideIndex + 1, end, comparator);
    }

    private static <T> int breakPartition(List<T> sequence, int start, int end, Comparator<T> comparator) {
        int beginToEnd = start + 1;
        T supportElement = sequence.get(start);
        int endToBegin = end;

        while (true) {
            while (beginToEnd < end && comparator.compare(sequence.get(beginToEnd), supportElement) < 0) {
                beginToEnd++;
            }
            while (comparator.compare(sequence.get(endToBegin), supportElement) > 0) {
                endToBegin--;
            }
            if (beginToEnd >= endToBegin) {
                break;
            }
            swap(sequence, beginToEnd++, endToBegin--);
        }
        swap(sequence, start, endToBegin);
        return endToBegin;
    }

    private static <T> void swap(List<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
