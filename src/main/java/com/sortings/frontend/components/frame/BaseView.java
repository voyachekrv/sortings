package com.sortings.frontend.components.frame;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Базовое представление формы
 * @author Воячек Роман
 * @version 1.0
 */
public abstract class BaseView extends JFrame {
    /**
     * Конструктор - создание нового объекта
     * @param title - заголовок фрейма
     * @param bounds - положение и размеры фрейма
     * @param closingOperation - индекс операции закрытия фрейма
     */
    public BaseView(String title, Rectangle bounds, int closingOperation) {
        super(title);
        this.setLayout(null);
        this.setBounds(bounds);
        this.setResizable(false);
        this.setDefaultCloseOperation(closingOperation);
        this.setEnabled(true);
        this.setVisible(true);
    }

}
