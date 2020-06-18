package com.sortings.frontend.forms.controllers;

import com.sortings.frontend.components.frame.FormController;
import com.sortings.frontend.forms.views.ArrayShowingView;

import javax.swing.table.DefaultTableModel;

/**
 * Контроллер для формы отображения процесса сортировки
 * @author Воячек Роман
 * @version 1.0
 */
public final class ArrayShowingController implements FormController {

    /** Представление */
    private final ArrayShowingView view;

    /**
     * Конструктор - создание формы с отображением двух массивов
     * @param title - Название сортировки
     * @param modelUnordered - Табличная модель сортировки неупорядоченного массива
     * @param modelOrdered - Табличная модель сортировки упорядоченного в обратном направлении массива
     */
    public ArrayShowingController(String title, DefaultTableModel modelUnordered, DefaultTableModel modelOrdered) {
        view = new ArrayShowingView(title, modelUnordered, modelOrdered);
    }

    /**
     * Конструктор - создание формы с отображением одного массива
     * @param title - Название сортировки
     * @param modelArray - Табличная модель сортировки массива
     * @param label - Название типа сортировки
     */
    public ArrayShowingController(String title, DefaultTableModel modelArray, String label) {
        view = new ArrayShowingView(title, modelArray, label);
    }

    /**
     * Метод - закрытие окна
     * */
    @Override
    public void closeWindow() {
        view.dispose();
    }
}
