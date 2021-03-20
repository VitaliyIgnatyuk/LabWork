package ru.sberbank.java.scool.lab.animal;

public class Dog extends Animal{

    public Dog() {
        super (AnimalType.predator, "Собака", 15d, 50);
    }

    @Override
    String Vote() {
        return "Гав";
    }
}
