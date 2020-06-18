package com.sortings.frontend.components.table;

import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Таблица со встроенной возможностью прокрутки
 * @author Воячек Роман
 * @version 1.0
 */
public class JTableComplex extends JPanel {

    /**
     * Конструктор - создание нового объекта
     * @param tableModel Модель таблицы
     * @param bounds Размер и положение табличного комплекса
     */
    public JTableComplex(DefaultTableModel tableModel, Rectangle bounds) {
        this.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        this.setBounds(bounds);

        JTable table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setDefaultEditor(Object.class, null);
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JScrollPane tableScroll = new JScrollPane();
        tableScroll.setViewportView(table);
        tableScroll.setPreferredSize(new Dimension(bounds.width - 20, bounds.height - 15));
        tableScroll.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(tableScroll);
    }

}
