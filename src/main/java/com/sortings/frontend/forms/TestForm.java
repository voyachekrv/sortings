package com.sortings.frontend.forms;

import javax.swing.*;
import java.awt.*;

public class TestForm {
    public JFrame frame;
    private final JTextField tfLogin; // Поле для ввода логина
    private final JPasswordField tfPassword; // Поле для ввода пароля

    /* TODO: Создать 3 потомка класса JFrame - форма ввода, форма-таблица, форма график, установить JFreeChart */

    public TestForm() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Размеры окна

        // Форма
        frame = new JFrame("Тестирование"); // Основная панель формы
        frame.setLayout(null);
        frame.setSize(375, 400); // Установка размеров
        frame.setLocation((screenSize.width / 3) + 130, (screenSize.height / 4) + 30); // Установка положения на экране
        frame.setResizable(false); // Запрет изменения размера окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Установка операции закрытия окна приложения

        tfLogin = new JTextField(20);
        tfLogin.setBounds(12, 12, 130, 30);
        frame.add(tfLogin);

        tfPassword = new JPasswordField(20);
        tfPassword.setBounds(12, 50, 130, 30);
        frame.add(tfPassword);

        frame.setVisible(true);
    }
}
