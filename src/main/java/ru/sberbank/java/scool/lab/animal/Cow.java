package ru.sberbank.java.scool.lab.animal;

public class Cow extends Animal{

    public Cow() {
        super(AnimalType.herbivore, "Корова", 400d, 170);
    }

    @Override
    String Vote() {
        return "Муууу";
    }
}
