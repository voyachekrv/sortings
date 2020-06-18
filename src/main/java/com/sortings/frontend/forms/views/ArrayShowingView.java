package com.sortings.frontend.forms.views;

import com.sortings.frontend.components.frame.BaseView;
import com.sortings.frontend.components.table.JTableComplex;
import com.sortings.frontend.services.ComponentFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Представление формы отображения работы сортировок
 * @author Воячек Роман
 * @version 1.0
 */
public final class ArrayShowingView extends BaseView {

    /**
     * Конструктор - создание формы с отображением двух массивов
     * @param title - Название сортировки
     * @param modelUnordered - Табличная модель сортировки неупорядоченного массива
     * @param modelOrdered - Табличная модель сортировки упорядоченного в обратном направлении массива
     */
    public ArrayShowingView(String title, DefaultTableModel modelUnordered, DefaultTableModel modelOrdered) {
        super("Отображение работы сортировки - " + title, new Rectangle(
                0,
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 14 - 20),
                900, 950
        ), JFrame.DISPOSE_ON_CLOSE);

        JLabel lUnordered = ComponentFactory.newLabel("Неупорядоченный массив: ", new Rectangle(12, 12, 350, 16));
        add(lUnordered);

        JTableComplex panelUnordered = new JTableComplex(modelUnordered, new Rectangle(12, 32, 860, 420));
        add(panelUnordered);

        JLabel lOrdered = ComponentFactory.newLabel("Упорядоченный в обратном порядке массив :", new Rectangle(12, 464, 350, 16));
        add(lOrdered);

        JTableComplex panelOrdered = new JTableComplex(modelOrdered, new Rectangle(12, 484, 860, 420));
        add(panelOrdered);
    }


    /**
     * Конструктор - создание формы с отображением одного массива
     * @param title - Название сортировки
     * @param modelArray - Табличная модель сортировки массива
     * @param label - Название типа сортировки
     */
    public ArrayShowingView(String title, DefaultTableModel modelArray, String label) {
        super("Отображение работы сортировки - " + title, new Rectangle(
                0,
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 14 - 20),
                900, 500
        ), JFrame.DISPOSE_ON_CLOSE);

        JLabel lArrayType = ComponentFactory.newLabel(label, new Rectangle(12, 12, 350, 16));
        add(lArrayType);

        JTableComplex panelArray = new JTableComplex(modelArray, new Rectangle(12, 32, 860, 420));
        add(panelArray);
    }
}
