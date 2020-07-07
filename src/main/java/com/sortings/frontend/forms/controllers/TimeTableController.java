package com.sortings.frontend.forms.controllers;

import com.sortings.frontend.components.frame.FormController;
import com.sortings.frontend.forms.views.TimeTableView;

import javax.swing.table.DefaultTableModel;

/**
 * Контроллер для формы отображения времени сортировки
 * @author Воячек Роман
 * @version 1.0
 */
public class TimeTableController implements FormController {

    /** Представление */
    private final TimeTableView view;

    /**
     * Конструктор - создание нового объекта
     * @param timeTableModel - Табличная модель
     * @param arraySize - Размер массива текстом
     */
    public TimeTableController(DefaultTableModel timeTableModel, String arraySize) {
        view = new TimeTableView(timeTableModel, arraySize);
    }

    /**
     * Метод - закрытие окна
     * */
    @Override
    public void closeWindow() {
        view.dispose();
    }
}
