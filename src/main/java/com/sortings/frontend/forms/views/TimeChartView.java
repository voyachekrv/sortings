package com.sortings.frontend.forms.views;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * Представление для формы графика с отображением времени выполнения сортировки
 * @author Воячек Роман
 * @version 1.0
 */
public final class TimeChartView {

    /** Набор данных */
    private final DefaultCategoryDataset dataset;

    /** Окно */
    public final ChartFrame frame;

    /**
     * Конструктор - создание нового объекта
     * @param bubbleUnordered - время сортировки пузырьком неупорядоченного массива
     * @param bubbleOrdered - время сортировки пузырьком упорядоченного в обратном порядке массива
     * @param shakerUnordered - время шейкереной сортировки неупорядоченного массива
     * @param shakerOrdered - время шейкереной сортировки упорядоченного в обратном порядке массива
     * @param arraySize - Тип размера массива
     */
    public TimeChartView(long bubbleUnordered, long bubbleOrdered, long shakerUnordered, long shakerOrdered, String arraySize) {
        dataset = new DefaultCategoryDataset();

        addToChart(bubbleUnordered, "Пузырьком - неупорядоченный");
        addToChart(bubbleOrdered, "Пузырьком - обратно упорядоченный");
        addToChart(shakerUnordered, "Шейкерная - неупорядоченный");
        addToChart(shakerOrdered, "Шейкерная - обратно упорядоченный");

        JFreeChart chart = ChartFactory.createBarChart(
                "Время сортировки " + arraySize,
                "Тип сортировки и массива",
                "Время сортировки", dataset, PlotOrientation.VERTICAL, false, true, false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        frame = new ChartFrame("Сравнение времени сортировки", chart);
        frame.setEnabled(true);
        frame.setVisible(true);
        frame.setSize(1200, 720);
    }

    /**
     * Метод - проверка на возможность добавить значение на график
     * @param value - Значение времени
     * @param col - Название колонки */
    private void addToChart(long value, String col) {
        if (value != -1) {
            dataset.addValue(value, "Время", col);
        }
    }
}
