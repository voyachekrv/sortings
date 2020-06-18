package com.sortings.frontend.forms.controllers;

import com.sortings.frontend.components.frame.FormController;
import com.sortings.frontend.forms.views.TimeChartView;

/**
 * Контроллер для формы графика с отображением времени выполнения сортировки
 * @author Воячек Роман
 * @version 1.0
 */
public final class TimeChartController implements FormController {
    /** Представление */
    private final TimeChartView view;

    /**
     * Конструктор - создание нового объекта
     * @param bubbleUnordered - время сортировки пузырьком неупорядоченного массива
     * @param bubbleOrdered - время сортировки пузырьком упорядоченного в обратном порядке массива
     * @param shakerUnordered - время шейкереной сортировки неупорядоченного массива
     * @param shakerOrdered - время шейкереной сортировки упорядоченного в обратном порядке массива
     * @param arraySize - Тип размера массива
     */
    public TimeChartController(long bubbleUnordered, long bubbleOrdered, long shakerUnordered, long shakerOrdered, String arraySize) {
        view = new TimeChartView(bubbleUnordered, bubbleOrdered, shakerUnordered, shakerOrdered, arraySize);
    }

    /**
     * Метод - закрытие окна
     * */
    @Override
    public void closeWindow() {
        view.frame.dispose();
    }
}
