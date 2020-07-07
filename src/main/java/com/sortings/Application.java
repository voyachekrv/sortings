package com.sortings;

import com.sortings.frontend.forms.controllers.*;

import javax.swing.*;

public class Application {
    public static InputController inputForm;
    public static ProgressBarController progressBarForm;
    public static ArrayShowingController bubbleShowingForm;
    public static ArrayShowingController shakerShowingForm;
    public static TimeChartController timeChartForm;
    public static TimeTableController timeTableForm;

    public static void main(String[] args)  {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            SwingUtilities.invokeLater(() -> inputForm = new InputController());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
