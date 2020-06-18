package com.sortings.services;

/**
 * Таймер в наносекундах
 * @author Воячек Роман
 * @version 1.0
 */
public final class NanoTimer {

    /** Время старта таймера */
    private long startTime;

    /** Время, замеренное таймером */
    private long timeElapsed;

    /**
     * Метод - запуск таймера
     * */
    public void start() {
        startTime = System.nanoTime();
    }

    /**
     * Метод - остановка таймера
     * */
    public void stop() {
        timeElapsed  = System.nanoTime() - startTime;
    }

    /**
     * Метод - получение времени, замеренного таймером
     * @return Время в наносекундах
     * */
    public long getTimeElapsed() {
        return timeElapsed;
    }
}
