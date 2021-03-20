package ru.sberbank.java.scool.lab.animal;

public class Bear extends Animal{

    public Bear() {
        super(AnimalType.omnivorous, "Медведь", 500d, 230);
    }

    @Override
    String Vote() {
        return "Рррррр";
    }

}
