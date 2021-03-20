package ru.sberbank.java.scool.lab.animal;

/**
 * Растительная пища, трава
 */
public class Plant implements Eat{

    @Override
    public EatType eatType() {
        return EatType.vegetable;
    }

    @Override
    public double getWeight() {
        return 1;
    }

    @Override
    public String getName() {
        return "Трава";
    }
}
