package ru.sberbank.java.scool.lab.animal;

public class Mouse extends Animal{

    public Mouse() {
        super(AnimalType.herbivore, "Мышь", 0.3, 7);
    }

    @Override
    String Vote() {
        return "Пи-пи";
    }

}
