package com.sortings.frontend.forms.controllers;

import com.sortings.frontend.components.frame.FormController;
import com.sortings.frontend.forms.views.InputView;
import com.sortings.frontend.services.TableModelFactory;
import com.sortings.services.ArrayGenerator;
import com.sortings.services.NanoTimer;
import com.sortings.services.SortingProcessor;

import static com.sortings.Application.*;

/**
 * Контроллер для формы ввода данных, предназначенных для испытания сортировок
 * @author Воячек Роман
 * @version 1.0
 */
public final class InputController implements FormController {

    /** Представление */
    private final InputView view = new InputView();

    /** Время сортировки массивов */
    private long timeBubbleOrdered, timeBubbleUnordered, timeShakerOrdered, timeShakerUnordered;

    /**
     * Конструктор - создание нового объекта. Создание отслеживания событий и присвоение им методов
     */
    public InputController() {
        view.rbSmallArray.addItemListener(itemEvent -> switchTestType());
        view.cbBubbleSort.addItemListener(itemEvent -> checkCheckboxStatement());
        view.cbShakerSort.addItemListener(itemEvent -> checkCheckboxStatement());
        view.cbOrderedArray.addItemListener(itemEvent -> checkCheckboxStatement());
        view.cbUnorderedArray.addItemListener(itemEvent -> checkCheckboxStatement());
        view.btnStart.addActionListener(actionEvent -> startSorting());
    }

    /**
     * Метод - закрытие окна
     * */
    @Override
    public void closeWindow() {
        view.dispose();
    }

    /**
     * Метод - переключение типов испытания
     */
    private void switchTestType() {
        if (view.rbSmallArray.isSelected()) {
            view.spinnerArrayLength.setModel(view.modelSmallArray);
            view.spinnerArrayLength.setValue(10);
        } else {
            view.spinnerArrayLength.setModel(view.modelBigArray);
            view.spinnerArrayLength.setValue(30000);
        }
    }

    /**
     * Метод - проверка состояния флажков
     */
    private void checkCheckboxStatement() {
        if (
                (!view.cbBubbleSort.isSelected() && !view.cbShakerSort.isSelected()) ||
                (!view.cbOrderedArray.isSelected() && !view.cbUnorderedArray.isSelected())
        ) {
            view.btnStart.setEnabled(false);
            view.lWarning.setText("<html>Необходимо, чтобы в испытании участвововал хотя бы один тип сортировки и хотя бы один тип массива!");
        } else {
            view.btnStart.setEnabled(true);
            view.lWarning.setText("");
        }
    }

    /**
     * Метод - запуск испытания сортировок
     */
    private void startSorting() {
        int min;
        int max;

        // Обмен местами минимального и максимального значения в случае, если пользователь ввёл некорректные значения
        if (Integer.parseInt(view.spinnerMinValue.getValue().toString()) > Integer.parseInt(view.spinnerMaxValue.getValue().toString())) {
            min = Integer.parseInt(view.spinnerMaxValue.getValue().toString());
            max = Integer.parseInt(view.spinnerMinValue.getValue().toString());

            view.spinnerMinValue.setValue(min);
            view.spinnerMaxValue.setValue(max);
        } else {
            min = Integer.parseInt(view.spinnerMinValue.getValue().toString());
            max = Integer.parseInt(view.spinnerMaxValue.getValue().toString());
        }

        view.setEnabled(false);
        progressBarForm = new ProgressBarController();

        int[] ordered = ArrayGenerator.getOrderedArray(min, max, Integer.parseInt(view.spinnerArrayLength.getValue().toString()));
        int[] unordered = ArrayGenerator.getUnorderedArray(min, max, Integer.parseInt(view.spinnerArrayLength.getValue().toString()));

        progressBarForm.closeWindow();
        view.setEnabled(true);

        if (bubbleShowingForm != null) {
            bubbleShowingForm.closeWindow();
        }

        if (shakerShowingForm != null) {
            shakerShowingForm.closeWindow();
        }

        if (timeChartForm != null) {
            timeChartForm.closeWindow();
        }

        timeBubbleOrdered = -1;
        timeBubbleUnordered = -1;
        timeShakerOrdered = -1;
        timeShakerUnordered = -1;

        if (view.rbSmallArray.isSelected()) {
            if (view.cbOrderedArray.isSelected() && view.cbUnorderedArray.isSelected()) {
                if (view.cbBubbleSort.isSelected()) {
                    smallArrayBubbleTest(unordered, ordered);
                }

                if (view.cbShakerSort.isSelected()) {
                    smallArrayShakerTest(unordered, ordered);
                }
            } else if (view.cbOrderedArray.isSelected() && !(view.cbUnorderedArray.isSelected())) {
                if (view.cbBubbleSort.isSelected()) {
                    smallArrayBubbleTest(ordered, "Упорядоченный в обратном порядке массив :");
                }

                if (view.cbShakerSort.isSelected()) {
                    smallArrayShakerTest(ordered, "Упорядоченный в обратном порядке массив :");
                }
            } else if (!(view.cbOrderedArray.isSelected()) && view.cbUnorderedArray.isSelected()) {
                if (view.cbBubbleSort.isSelected()) {
                    smallArrayBubbleTest(unordered, "Неупорядоченный массив: ");
                }

                if (view.cbShakerSort.isSelected()) {
                    smallArrayShakerTest(unordered, "Неупорядоченный массив: ");
                }
            }

            timeChartForm = new TimeChartController(
                    timeBubbleUnordered,
                    timeBubbleOrdered,
                    timeShakerUnordered,
                    timeShakerOrdered,
                    "небольшого массива"
            );
        } else {
            bigArrayTest(min, max);

            timeChartForm = new TimeChartController(
                    timeBubbleUnordered,
                    timeBubbleOrdered,
                    timeShakerUnordered,
                    timeShakerOrdered,
                    "большого массива"
            );
        }
    }

    /**
     * Метод - испытание пузырьковой сорттировки на массиве одного типа
     * @param array - Неотсортированный масссив
     * @param label - Название типа массива
     */
    private void smallArrayBubbleTest(int[] array, String label) {
        NanoTimer timer = new NanoTimer();

        int[] arrayForTimer = new int[array.length];
        System.arraycopy(array,0, arrayForTimer, 0, array.length);

        timer.start();
        SortingProcessor.bubbleSort(arrayForTimer);
        timer.stop();

        if (label.equals("Неупорядоченный массив: ")) {
            timeBubbleUnordered = timer.getTimeElapsed();
        } else {
            timeBubbleOrdered = timer.getTimeElapsed();
        }

        bubbleShowingForm = new ArrayShowingController("пузырьковая", TableModelFactory.getBubbleSortModel(array), label);
        view.toBack();
    }

    /**
     * Метод - испытание пузырьковой сорттировки на массиве двух типов
     * @param unordered - Неотсортированный неупорядоченный масссив
     * @param ordered - Неотсортированный упорядоченный в обратном порядке масссив
     */
    private void smallArrayBubbleTest(int[] unordered, int[] ordered) {
        NanoTimer timer = new NanoTimer();

        int[] unorderedForTimer = new int[unordered.length];
        int[] orderedForTimer = new int[ordered.length];

        System.arraycopy(unordered,0, unorderedForTimer, 0, unordered.length);
        System.arraycopy(ordered,0, orderedForTimer, 0, ordered.length);

        timer.start();
        SortingProcessor.bubbleSort(unorderedForTimer);
        timer.stop();

        timeBubbleUnordered = timer.getTimeElapsed();

        timer.start();
        SortingProcessor.bubbleSort(orderedForTimer);
        timer.stop();

        timeBubbleOrdered = timer.getTimeElapsed();

        bubbleShowingForm = new ArrayShowingController(
                "пузырьковая", TableModelFactory.getBubbleSortModel(unordered), TableModelFactory.getBubbleSortModel(ordered)
        );
        view.toBack();
    }

    /**
     * Метод - испытание шейкерной сорттировки на массиве одного типа
     * @param array - Неотсортированный масссив
     * @param label - Название типа массива
     */
    private void smallArrayShakerTest(int[] array, String label) {
        NanoTimer timer = new NanoTimer();

        int[] arrayForTimer = new int[array.length];
        System.arraycopy(array,0, arrayForTimer, 0, array.length);

        timer.start();
        SortingProcessor.shakerSort(arrayForTimer);
        timer.stop();

        if (label.equals("Неупорядоченный массив: ")) {
            timeShakerUnordered = timer.getTimeElapsed();
        } else {
            timeShakerOrdered = timer.getTimeElapsed();
        }

        shakerShowingForm = new ArrayShowingController("шейкерная", TableModelFactory.getShakerSortModel(array), label);
        view.toBack();
    }

    /**
     * Метод - испытание шейкерной сорттировки на массиве двух типов
     * @param unordered - Неотсортированный неупорядоченный масссив
     * @param ordered - Неотсортированный упорядоченный в обратном порядке масссив
     */
    private void smallArrayShakerTest(int[] unordered, int[] ordered) {
        NanoTimer timer = new NanoTimer();

        int[] unorderedForTimer = new int[unordered.length];
        int[] orderedForTimer = new int[ordered.length];

        System.arraycopy(unordered,0, unorderedForTimer, 0, unordered.length);
        System.arraycopy(ordered,0, orderedForTimer, 0, ordered.length);

        timer.start();
        SortingProcessor.shakerSort(unorderedForTimer);
        timer.stop();

        timeShakerUnordered = timer.getTimeElapsed();

        timer.start();
        SortingProcessor.shakerSort(orderedForTimer);
        timer.stop();

        timeShakerOrdered = timer.getTimeElapsed();

        shakerShowingForm = new ArrayShowingController(
                "шейкерная", TableModelFactory.getShakerSortModel(unordered), TableModelFactory.getShakerSortModel(ordered)
        );
        view.toBack();
    }

    /**
     * Метод - испытание сортировок на большом массиве
     * @param min - Минимальное значение в массиве
     * @param max - Максимальное значение в массиве
     */
    private void bigArrayTest(int min, int max) {
        if (view.cbBubbleSort.isSelected()) {
            if (view.cbUnorderedArray.isSelected()) {
                timeBubbleUnordered = getBubbleSortingTime(
                        ArrayGenerator.getUnorderedArray(
                            min, max, Integer.parseInt(view.spinnerArrayLength.getValue().toString())
                        )
                );
            }

            if (view.cbOrderedArray.isSelected()) {
                timeBubbleOrdered = getBubbleSortingTime(
                        ArrayGenerator.getOrderedArray(
                                min, max, Integer.parseInt(view.spinnerArrayLength.getValue().toString())
                        )
                );
            }
        }

        if (view.cbShakerSort.isSelected()) {
            if (view.cbUnorderedArray.isSelected()) {
                timeShakerUnordered = getShakerSortingTime(
                        ArrayGenerator.getUnorderedArray(
                                min, max, Integer.parseInt(view.spinnerArrayLength.getValue().toString())
                        )
                );
            }

            if (view.cbOrderedArray.isSelected()) {
                timeShakerOrdered = getShakerSortingTime(
                        ArrayGenerator.getOrderedArray(
                                min, max, Integer.parseInt(view.spinnerArrayLength.getValue().toString())
                        )
                );
            }
        }
    }

    /**
     * Метод - Получение времени сортировки пузырьком большого массива
     * @param array - неотсортированнный массив
     * @return Возвращает время в наносекундах
     */
    private long getBubbleSortingTime(int[] array) {
        NanoTimer timer = new NanoTimer();

        timer.start();
        SortingProcessor.bubbleSort(array);
        timer.stop();

        return timer.getTimeElapsed();
    }

    /**
     * Метод - Получение времени шейкерной сортировки большого массива
     * @param array - неотсортированнный массив
     * @return Возвращает время в наносекундах
     */
    private long getShakerSortingTime(int[] array) {
        NanoTimer timer = new NanoTimer();

        timer.start();
        SortingProcessor.shakerSort(array);
        timer.stop();

        return timer.getTimeElapsed();
    }
}
