package ru.sberbank.java.scool.lab.animal;

public class Cat extends Animal {

    public Cat() {
        super (AnimalType.predator, "Кошка", 6d, 30);
    }

    @Override
    String Vote() {
        return "Мяу";
    }
}
