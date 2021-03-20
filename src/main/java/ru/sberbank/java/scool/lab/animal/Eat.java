package ru.sberbank.java.scool.lab.animal;

/**
 * Описывает еду
 */
public interface Eat {

    String eatFormat = "%s съедает %s";
    String notEatFormat = "%s не съест %s";

    /**
     * Возвращает тип пищи (Живая или растительная пища)
     */
    EatType eatType();

    /**
     * Вес пищи килограммах
     */
    double getWeight();

    /**
     * Название пищи
     */
    String getName();

}
