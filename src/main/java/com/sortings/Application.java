package com.sortings;

import com.sortings.frontend.forms.controllers.ArrayShowingController;
import com.sortings.frontend.forms.controllers.InputController;
import com.sortings.frontend.forms.controllers.ProgressBarController;
import com.sortings.frontend.forms.controllers.TimeChartController;

import javax.swing.*;

public class Application {
    public static InputController inputForm;
    public static ProgressBarController progressBarForm;
    public static ArrayShowingController bubbleShowingForm;
    public static ArrayShowingController shakerShowingForm;
    public static TimeChartController timeChartForm;

    public static void main(String[] args)  {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            SwingUtilities.invokeLater(() -> inputForm = new InputController());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
