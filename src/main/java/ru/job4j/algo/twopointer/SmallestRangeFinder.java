package ru.job4j.algo.twopointer;

import java.util.Arrays;

/**
 * 2.6. Алгоритмы
 */
public class SmallestRangeFinder {

    /**
     * Метод использующий алгоритм двух указателей, принимающий на вход отсортированный массив целых чисел и число k,
     * можно найти наименьший диапазон в массиве, который содержит как минимум k различных элементов.
     * Вычислительная сложность: O(n)
     * Пространственная сложность: O(1)
     *
     * @param nums отсортированный массив
     * @param k    целочисленное значение
     * @return Массив из двух целых чисел, представляющих наименьший диапазон
     * с k различными элементами в массиве nums.
     * Если такой диапазон найти невозможно, возвращается null
     */
    public static int[] findSmallestRange(int[] nums, int k) {
        int length = nums.length;
        int quantityOfKElements = 1;
        int[] result = new int[2];
        int left = 0;
        int right = left + 1;
        while (quantityOfKElements != k && right != length) {
            if (nums[left] != nums[right]) {
                left++;
                quantityOfKElements++;
                result[1] = right;
                right = left + 1;
            } else {
                left++;
                right = left + 1;
                quantityOfKElements = 1;
                result[0] = left;
            }
        }
        if (quantityOfKElements != k) {
            return null;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
