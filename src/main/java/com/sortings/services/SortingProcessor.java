package com.sortings.services;

/**
 * Класс, обеспечивающий методы сортировки
 * @author Воячек Роман
 * @version 1.0
 */
public final class SortingProcessor {

    /**
     * Метод - сортировка простым обменом (метод "пузырька")
     * @param array - Неотсортированный массив чисел типа int */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = (array.length - 1); j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * Метод - шейкерная сортировка
     * @param array - Неотсортированный массив чисел типа int */
    public static void shakerSort(int[] array) {
        int left = 0, right = array.length - 1;
        boolean flag = true;

        while ((left < right) && flag) {
            flag = false;
            for (int i = left; i< right; i++) {
                if (array[i] > array[i + 1]) {
                    int t = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = t;
                    flag = true;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i - 1] > array[i]) {
                    int t = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = t;
                    flag = true;
                }
            }
            left++;
        }

    }
}
