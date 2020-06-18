package com.sortings.frontend.forms.views;

import com.sortings.frontend.components.frame.BaseView;
import com.sortings.frontend.services.ComponentFactory;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * Представление окна с полосой загрузки
 * @author Воячек Роман
 * @version 1.0
 */
public final class ProgressBarView extends BaseView {

    /**
     * Конструктор - создание нового объекта. Создание отслеживания событий и присвоение им методов
     */
    public ProgressBarView() {
        super(
                "Загрузка",
                new Rectangle(
                        ((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - 170),
                        ((Toolkit.getDefaultToolkit().getScreenSize().height) / 3 + 75),
                        420,
                        100),
                JFrame.DO_NOTHING_ON_CLOSE
        );

        JLabel lWait = ComponentFactory.newLabel("Пожалуйста, подождите...", new Rectangle(12, 10, 140, 18));
        add(lWait);

        JProgressBar progressBar = ComponentFactory.newProgressBar(new Rectangle(12, 30, 378, 20));
        add(progressBar);
    }
}
