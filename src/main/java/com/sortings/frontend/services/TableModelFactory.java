package com.sortings.frontend.services;

import javax.swing.table.DefaultTableModel;

/**
 * Фабрика табличных моделей
 * @author Воячек Роман
 * @version 1.0
 */
public final class TableModelFactory {

    /**
     * Метод - создание модели пузырьковой сортировки
     * @param array - неотсортированный массив
     * @return Возвращает модель процесса сортировки массива
     * */
    public static DefaultTableModel getBubbleSortModel(int[] array) {
        DefaultTableModel model = new DefaultTableModel();

        String[] arrayInitial = new String[array.length];

        for (int i = 0; i < arrayInitial.length; i++) {
            arrayInitial[i] = Integer.toString(array[i]);
        }

        Object[] objects = new Object[array.length];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = array[i];
        }

        model.setColumnIdentifiers(arrayInitial);

        for (int i = 0; i < objects.length - 1; i++) {
            model.insertRow(i, objects);

            for (int j = (objects.length - 1); j > i; j--) {
                if ((int) objects[j - 1] > (int) objects[j]) {
                    int temp = (int) objects[j - 1];
                    objects[j - 1] = objects[j];
                    objects[j] = temp;
                }
            }
        }

        return model;
    }

    /**
     * Метод - создание модели шейкерной сортировки
     * @param array - неотсортированный массив
     * @return Возвращает модель процесса сортировки массива
     * */
    public static DefaultTableModel getShakerSortModel(int[] array) {
        DefaultTableModel model = new DefaultTableModel();

        String[] arrayInitial = new String[array.length];

        for (int i = 0; i < arrayInitial.length; i++) {
            arrayInitial[i] = Integer.toString(array[i]);
        }

        Object[] objects = new Object[array.length];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = array[i];
        }

        model.setColumnIdentifiers(arrayInitial);

        int left = 0, right = array.length - 1;
        boolean flag = true;

        int rowIterator = 0;
        while ((left < right) && flag) {
            model.insertRow(rowIterator, objects);

            flag = false;
            for (int i = left; i< right; i++) {
                if ((int) objects[i] > (int) objects[i + 1]) {
                    int t = (int) objects[i];
                    objects[i] = objects[i + 1];
                    objects[i + 1] = t;
                    flag = true;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if ((int) objects[i - 1] > (int) objects[i]) {
                    int t = (int) objects[i];
                    objects[i] = objects[i - 1];
                    objects[i - 1] = t;
                    flag = true;
                }
            }
            left++;
            rowIterator++;
        }

        return model;
    }
}
