package com.sortings.frontend.forms.views;

import com.sortings.frontend.components.frame.BaseView;
import com.sortings.frontend.components.table.JTableComplex;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Представление формы отображения времени сортировки
 * @author Воячек Роман
 * @version 1.0
 */
public class TimeTableView extends BaseView {

    /**
     * Конструктор - создание нового объекта
     * @param timeTableModel - Табличная модель
     * @param arraySize - Размер массива текстом
     */
    public TimeTableView(DefaultTableModel timeTableModel, String arraySize) {
        super("Время сортировки " + arraySize, new Rectangle(
                ((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - 170),
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 3 + 75),
                1100,
                140
                ),
                JFrame.DISPOSE_ON_CLOSE
        );

        JTableComplex table = new JTableComplex(timeTableModel, new Rectangle(12, 12, 1060, 80));
        add(table);
    }
}
