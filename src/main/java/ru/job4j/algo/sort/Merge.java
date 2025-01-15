package ru.job4j.algo.sort;

import java.util.Arrays;

/**
 * Реализован алгоритм сортировки слиянием.
 * Относится к классу алгоритмов, использующих принцип "разделяй и властвуй".
 * Данный алгоритм разбивает список на две части, каждую из них он разбивает ещё на две и так далее,
 * пока не останутся единичные элементы. Массив из одного элемента считается упорядоченным.
 * Затем производится процедура слияния отсортированных массивов.
 * Соседние элементы сравниваются и соединяются вместе.
 * Так происходит до тех пор, пока все элементы не будут отсортированы.
 */
public class Merge {
    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int indexLeft = 0;
        int indexRight = 0;
        for (int itr = 0; itr < result.length; itr++) {
            if (indexLeft == left.length) {
                for (int itrRiEl = indexRight; itrRiEl < right.length; itrRiEl++) {
                    result[itr] = right[itrRiEl];
                    itr++;
                }
                break;
            } else if (indexRight == right.length) {
                for (int itrLeEl = indexLeft; itrLeEl < left.length; itrLeEl++) {
                    result[itr] = left[itrLeEl];
                    itr++;
                }
                break;
            }
            if (left[indexLeft] <= right[indexRight]) {
                result[itr] = left[indexLeft];
                indexLeft++;
            } else if (left[indexLeft] >= right[indexRight]) {
                result[itr] = right[indexRight];
                indexRight++;
            }
        }
        return result;
    }
}
