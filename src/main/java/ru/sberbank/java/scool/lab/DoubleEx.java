package ru.sberbank.java.scool.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;

/**
 * Класс реализующий операции над переменной типа double принимающий входные параметры с типом Number.
 * Переданное значение может иметь тип любого наследуемого от Number типа
 *
 * @author Игнатюк Виталий
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public class DoubleEx {

    private double value;
    private final DoublePredicate equalsZerro = (p) -> p == 0d;
    private final DoublePredicate equalsOne = (p) -> p == 1d;

    /**
     * Производит операцию сложения значения текущего объекта и переданного значения
     *
     * @param val значение которое требуется добавить к текущему объекту
     * @return текущий объект в случае переданного аргумента == "0" или "0.0", иначе создаст и вернёт новый объект содержащий сумму
     */
    public DoubleEx add(Number val) {
        return func(val, equalsZerro, (a) -> this.value + a);
    }

    /**
     * Производит операцию вычитания значения из текущего объекта переданного значения
     *
     * @param val значение которое требуется вычесть из текущего объекта
     * @return текущий объект в случае переданного аргумента == "0" или "0.0", иначе создаст и вернёт новый объект содержащий разницу
     */
    public DoubleEx subtract(Number val) {
        return func(val, equalsZerro, (s) -> this.value - s);
    }

    /**
     * Производит операцию умножения значения текущего объекта и переданного значения
     *
     * @param val значение на которое требуется умножить текущий объект
     * @return текущий объект в случае переданного аргумента == "1" или "1.0", иначе создаст и вернёт новый объект содержащий результат умножения
     */
    public DoubleEx multiply(Number val) {
        return func(val, equalsOne, (s) -> this.value * s);
    }

    /**
     * Производит операцию деления значения текущего объекта на переданное значение
     *
     * @param val значение на которое требуется разделить текущий объект
     * @return текущий объект в случае переданного аргумента == "1" или "1.0", иначе создаст и вернёт новый объект содержащий результат деления
     */
    public DoubleEx divide(Number val) throws ArithmeticException {
        checkZerro(val); // вызываем проверку ргумента на "0", т.к. на ноль делить нельзя
        return func(val, equalsOne, (s) -> this.value / s);
    }

    /**
     * Производит операцию деления по модулю значения текущего объекта на переданное значение
     *
     * @param val значение на которое требуется разделить текущий объект
     * @return текущий объект в случае переданного аргумента == "1" или "1.0", иначе создаст и вернёт новый объект содержащий остаток от деления
     */
    public DoubleEx mod(Number val) throws ArithmeticException {
        checkZerro(val); // вызываем проверку ргумента на "0", т.к. на ноль делить нельзя
        return func(val, equalsOne, (s) -> this.value % s);
    }

    /**
     * Производит операцию возведения в степень значения текущего объекта на переданное значение
     *
     * @param val значение степени в которую требуется возвести текущий объект
     * @return новый объект содержащий в себе результат возведения в степень
     */
    public DoubleEx pow(Number val) {
        return new DoubleEx(Math.pow(this.value, val.doubleValue()));
    }

    /**
     * Производит операцию сравнения и возвращает объект содержащий максимальное значение
     *
     * @param val значение для сравнения со значением текущего объекта
     * @return текущий объект в случае если его значение больше или равно аргументу, иначе новый объект содержащий в себе значение аргумента
     */
    public DoubleEx max(Number val) {
        return value >= val.doubleValue() ? this : new DoubleEx(val.doubleValue());
    }

    /**
     * Производит проверку на тип передаваемого аргумента и его значение, если значение == "0" вызывает ошибку
     *
     * @param val значение для проверки
     * @throws ArithmeticException если аргумент == "0"
     */
    private void checkZerro(Number val) throws ArithmeticException {
        if ((val instanceof Integer) & (val.intValue() == 0))
            throw new ArithmeticException();
    }

    /**
     * @param val Значение с которым надо выполнить какю либо унарную операцию
     * @param dp  Предикат при выполнении которого требуется вернуть текущий объект в результате
     * @param duo Унарная операция результат которой требуется вернуть как новый объект
     * @return текщий объект в случае выполнения предиката, иначе новый объект содержащий в своём значении результат выполнения унарной операции
     */
    private DoubleEx func(Number val, DoublePredicate dp, DoubleUnaryOperator duo) {
        double value = val.doubleValue();
        return dp.test(value) ? this : new DoubleEx(duo.applyAsDouble(value));
    }

}