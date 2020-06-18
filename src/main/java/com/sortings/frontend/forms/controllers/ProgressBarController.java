package com.sortings.frontend.forms.controllers;

import com.sortings.frontend.components.frame.FormController;
import com.sortings.frontend.forms.views.ProgressBarView;

/**
 * Контроллер для окна с полосой загрузки
 * @author Воячек Роман
 * @version 1.0
 */
public final class ProgressBarController implements FormController {

    /** Представление */
    private final ProgressBarView view = new ProgressBarView();

    /**
     * Метод - закрытие окна
     * */
    @Override
    public void closeWindow() {
        view.dispose();
    }
}
