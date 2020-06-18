package com.sortings.services;

import java.util.Random;

/**
 * Генератор массивов
 * @author Воячек Роман
 * @version 1.0
 */
public final class ArrayGenerator {
    /**
     * Метод - генерация значения в пределах
     * @param min - минимальное значене
     * @param max - маскисмальное значение
     * @return Возвращает сгенерированное число
     * */
    private static int randomFromRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Метод - генерация неупорядоченного массива
     * @param min - минимальное значене
     * @param max - маскисмальное значение
     * @param length - длина массива
     * @return Возвращает неупорядоченный массив
     * */
    public static int[] getUnorderedArray(int min, int max, int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = randomFromRange(min, max);
        }

        return array;
    }

    /**
     * Метод - генерация упорядоченного в обратном порядке массива
     * @param min - минимальное значене
     * @param max - маскисмальное значение
     * @param length - длина массива
     * @return Возвращает упорядоченный в обратном порядке массив
     * */
    public static int[] getOrderedArray(int min, int max, int length) {
        int[] array = new int[length];

        array[0] = max - randomFromRange(1, min);

        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] - randomFromRange(1, 5);
        }

        return array;
    }
}
