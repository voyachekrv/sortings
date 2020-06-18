package com.sortings.frontend.forms.views;

import com.sortings.frontend.components.frame.BaseView;
import com.sortings.frontend.services.ComponentFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Представление формы ввода данных, предназначенных для испытания сортировок
 * @author Воячек Роман
 * @version 1.0
 */
public final class InputView extends BaseView {

    /** Радиокнопки */
    public final JRadioButton rbSmallArray, rbBigArray;

    /** Инкрементный регулятор */
    public final JSpinner spinnerArrayLength, spinnerMinValue, spinnerMaxValue;

    /** Флажки */
    public final JCheckBox cbBubbleSort, cbShakerSort, cbOrderedArray, cbUnorderedArray;

    /** Надпись-предупреждение */
    public final JLabel lWarning;

    /** Кнопка */
    public final JButton btnStart;

    /** Модели инкрементного регулятора */
    public final SpinnerNumberModel modelSmallArray, modelBigArray;

    /**
     * Конструктор - создание нового объекта
     */
    public InputView() {
        super(
                "Испытание сортировок",
                new Rectangle(
                        ((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - 170),
                        ((Toolkit.getDefaultToolkit().getScreenSize().height) / 3),
                        420,
                        280),
                JFrame.EXIT_ON_CLOSE
        );

        rbSmallArray = ComponentFactory.newRadioButton("Испытание на небольшом массиве", new Rectangle(12, 12, 200, 17), true);
        add(rbSmallArray);

        rbBigArray = ComponentFactory.newRadioButton("Испытание на большом массиве", new Rectangle(210, 12, 200, 17), false);
        add(rbBigArray);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(rbSmallArray);
        radioGroup.add(rbBigArray);

        JLabel lArraysLength = ComponentFactory.newLabel("Длина массива: ", new Rectangle(12, 44, 100, 17));
        add(lArraysLength);

        modelSmallArray = new SpinnerNumberModel(10, 1, 10, 1);
        modelBigArray = new SpinnerNumberModel(30000, 1, Integer.MAX_VALUE, 1);

        spinnerArrayLength = ComponentFactory.newSpinnerNumeric(
                modelSmallArray,
                new Rectangle(95, 44, 75, 20)
        );
        add(spinnerArrayLength);

        JLabel lMinValue = ComponentFactory.newLabel("Минимум: ", new Rectangle(175, 44, 55, 20));
        add(lMinValue);

        spinnerMinValue = ComponentFactory.newSpinnerNumeric(
                new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1), new Rectangle(225, 44, 60, 20)
        );
        add(spinnerMinValue);

        JLabel lMaxValue = ComponentFactory.newLabel("Максимум:", new Rectangle(290, 44, 55, 20));
        add(lMaxValue);

        spinnerMaxValue = ComponentFactory.newSpinnerNumeric(
                new SpinnerNumberModel(100, 1, Integer.MAX_VALUE, 1), new Rectangle(345, 44, 60, 20)
        );
        add(spinnerMaxValue);

        JLabel lSorting = ComponentFactory.newLabel("Сортировки: ", new Rectangle(12, 80, 155, 15));
        add(lSorting);

        cbBubbleSort = ComponentFactory.newCheckBox("Пузырьковая", new Rectangle(12, 100, 135, 15), true);
        add(cbBubbleSort);

        cbShakerSort = ComponentFactory.newCheckBox("Шейкерная", new Rectangle(190, 100, 155, 15), true);
        add(cbShakerSort);

        JLabel lArrays = ComponentFactory.newLabel("Массивы: ", new Rectangle(12, 125, 155, 15));
        add(lArrays);

        cbUnorderedArray = ComponentFactory.newCheckBox("Неупорядоченный", new Rectangle(12, 150, 155, 15), true);
        add(cbUnorderedArray);

        cbOrderedArray = ComponentFactory.newCheckBox("Упорядоченный в обратном порядке", new Rectangle(190, 150, 355, 15), true);
        add(cbOrderedArray);

        lWarning = ComponentFactory.newWarningLabel(
                "",
                new Rectangle(12, 175, 235, 60)
        );
        add(lWarning);

        btnStart = ComponentFactory.newButton("Начать испытание", new Rectangle(253, 200, 136, 27));
        add(btnStart);
    }
}
