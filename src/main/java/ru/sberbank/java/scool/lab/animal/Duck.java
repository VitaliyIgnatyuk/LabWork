package ru.sberbank.java.scool.lab.animal;

public class Duck extends Bird {

    public Duck() {
        super(AnimalType.herbivore, "Утка", 7d, 40);
    }

    @Override
    String Vote() {
        return "Кря-Кря";
    }

}
