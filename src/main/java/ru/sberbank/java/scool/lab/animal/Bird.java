package ru.sberbank.java.scool.lab.animal;

/**
 * Базовый класс для птиц, реализует интерфейс полёта
 */
public abstract class Bird extends Animal implements Fly{

    public Bird(AnimalType animalType, String name, double weight, int growth) {
        super(animalType, name, weight, growth);
    }

    /**
     * Взёлт
     */
    public void flight() {
        System.out.printf("%s летит", getName());
    }

}
