package com.sortings;

import com.sortings.frontend.forms.TestForm;

import javax.swing.*;

public class Application {
    public static TestForm testForm; // Тестовая форма (удалить потом)

    public static void main(String[] args)  {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            SwingUtilities.invokeLater(() -> {
                testForm = new TestForm();
            });
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
