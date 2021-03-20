package ru.sberbank.java.scool.lab.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Абстрактный класс животного
 * каждое животное является звеном в пищевой цепи, поэтому реализует интерфейс Eat (Еда)
 */
@Getter
@AllArgsConstructor
public abstract class Animal implements Eat {

    /**
     * Тип животного
     */
    private AnimalType animalType;
    /**
     * Название животного
     */
    private String name;
    /**
     * Средний вес в кг
     */
    private double weight;
    /**
     * Средний рост в сантиметрах
     */
    private int growth;

    /**
     * Звук который издаёт животное
     */
    abstract String Vote();

    @Override
    public double getWeight () {
        return this.weight;
    }

    @Override
    public EatType eatType (){
        return EatType.live;
    }

    /**
     * Животному предлагают съесть некую еду
     * @param eat конкретная пища для животного
     *
     */
    public String eating(Eat eat) {
        boolean isEdible = false;
        switch (animalType){
            case omnivorous:
                isEdible = eat.eatType() == EatType.vegetable;
                if (isEdible)
                    break; // Если переданная пища не является животным, то всеядное животное её ест
            // если это всеядное животное и пища животного просисхождения, то в проверим сможем ли мы съесть по весу
            case predator:
                if (eat.eatType() == EatType.live){
                    isEdible = eat.getWeight() < this.weight;
                }
                break;
            case herbivore:
                isEdible = eat.eatType() == EatType.vegetable; // Травоядные едят только растительную пищу
                break;
        }
        if (isEdible)
            return String.format(eatFormat, this.name, eat.getName());
        else
            return String.format(notEatFormat, this.name, eat.getName());
    }

}
