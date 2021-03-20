package ru.sberbank.java.scool.lab.animal;

public class Crow extends Bird {

    public Crow() {
        super(AnimalType.herbivore, "Ворона", 0.8, 15);
    }

    @Override
    String Vote() {
        return "Кар-Кар";
    }

}
