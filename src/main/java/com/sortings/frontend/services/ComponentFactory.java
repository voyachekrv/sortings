package com.sortings.frontend.services;

import javax.swing.*;
import java.awt.*;

/**
 * Фабрика компонентов
 * @author Воячек Роман
 * @version 1.0
 */
public final class ComponentFactory {

    /**
     * Метод, создающий кнопку
     * @param t - Текст кнопки
     * @param r - Размеры и положение
     * @return Возвращает кнопку с заданными свойствами
     * */
    public static JButton newButton(String t, Rectangle r) {
        JButton b = new JButton(t);
        b.setBounds(r);
        b.setFocusPainted(false);
        return b;
    }

    /**
     * Метод, создающий радиокнопку
     * @param t - Текст кнопки
     * @param r - Размеры и положение
     * @param selected - выбрана ли кнопка
     * @return Возвращает кнопку с заданными свойствами
     * */
    public static JRadioButton newRadioButton(String t, Rectangle r, boolean selected) {
        JRadioButton rb = new JRadioButton(t);
        rb.setFocusPainted(false);
        rb.setBounds(r);
        rb.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rb.setSelected(selected);
        return rb;
    }

    /**
     * Метод, создающий надпись
     * @param t - Текст надписи
     * @param r - Размеры и положение
     * @return Возвращает надпись с заданными свойствами
     * */
    public static JLabel newLabel(String t, Rectangle r) {
        JLabel l = new JLabel(t);
        l.setBounds(r.x, r.y, r.width, r.height);
        return l;
    }

    /**
     * Метод, создающий надпись-предупреждение
     * @param t - Текст надписи
     * @param r - Размеры и положение
     * @return Возвращает надпись с заданными свойствами
     * */
    public static JLabel newWarningLabel(String t, Rectangle r) {
        JLabel l = new JLabel(t);
        l.setBounds(r.x, r.y, r.width, r.height);
        l.setForeground(Color.RED);
        return l;
    }

    /**
     * Метод, создающий инкрементный регулятор
     * @param model - Модель регулятора
     * @param r - Размеры и положение
     * @return Возвращает инкрементный регулятор с заданными свойствами
     * */
    public static JSpinner newSpinnerNumeric(SpinnerNumberModel model, Rectangle r) {
        JSpinner spinner = new JSpinner();
        spinner.setModel(model);
        spinner.setBounds(r);
        return spinner;
    }

    /**
     * Метод, создающий флажок
     * @param t - Текст флажка
     * @param r - Размеры и положение
     * @param selected - выбран ли флажок
     * @return Возвращает флажок с заданными свойствами
     * */
    public static JCheckBox newCheckBox(String t, Rectangle r, boolean selected) {
        JCheckBox cb = new JCheckBox(t);
        cb.setBounds(r);
        cb.setFocusPainted(false);
        cb.setSelected(selected);
        return cb;
    }

    /**
     * Метод, создающий полосу загрузки
     * @param r - Размеры и положение
     * @return Возвращает полосу загрузки с заданными свойствами
     * */
    public static JProgressBar newProgressBar(Rectangle r) {
        JProgressBar pb = new JProgressBar();
        pb.setIndeterminate(true);
        pb.setBounds(r);
        return pb;
    }
}
