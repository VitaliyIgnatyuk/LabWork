package ru.sberbank.java.scool.lab.animal;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BearTest {

    private Animal bear = new Bear();

    @Test
    public void getWeight() {
        Assert.assertEquals(bear.getWeight(), 500d, 0d);
    }

    @Test
    public void eatType() {
        Assert.assertEquals(bear.eatType(), EatType.live);
    }

    @Test
    public void eating() {
        // Медведь съедает кошку
        Animal cat = new Cat();
        Assert.assertEquals(bear.eating(cat), String.format(Eat.eatFormat, bear.getName(), cat.getName()));
        Animal bear2 = new Bear();
        // Медведь не съедает медведя
        Assert.assertEquals(bear.eating(bear2), String.format(Eat.notEatFormat, bear.getName(), bear2.getName()));
        Eat cow = new Cow();
        // Медведь съедает корову
        Assert.assertEquals(bear.eating(cow), String.format(Eat.eatFormat, bear.getName(), cow.getName()));
        Plant plant = new Plant();
        // Медведь съедает траву
        Assert.assertEquals(bear.eating(plant), String.format(Eat.eatFormat, bear.getName(), plant.getName()));

        // Использование Moc
        Animal fish = mock(Animal.class);
        when(fish.getName()).thenReturn("Селёдка");
        when(fish.getWeight()).thenReturn(1.5);
        when(fish.eatType()).thenReturn(EatType.live);
        // Медведь ест селёдку
        Assert.assertEquals(bear.eating(fish), String.format(Eat.eatFormat, bear.getName(), fish.getName()));

        // Использование Moc
        Animal elephant = mock(Animal.class);
        when(elephant.getName()).thenReturn("Слон");
        when(elephant.getWeight()).thenReturn(6000d);
        when(elephant.eatType()).thenReturn(EatType.live);
        // Медведь не съест слона
        Assert.assertEquals(bear.eating(elephant), String.format(Eat.notEatFormat, bear.getName(), elephant.getName()));
    }

    @Test
    public void getAnimalType() {
        Assert.assertEquals(bear.getAnimalType(), AnimalType.omnivorous);
    }

    @Test
    public void getName() {
        Assert.assertEquals(bear.getName(), "Медведь");
    }

    @Test
    public void getGrowth() {
        Assert.assertEquals(bear.getGrowth(), 230);
    }

    @Test
    public void vote() {
        Assert.assertEquals(bear.Vote(), "Рррррр");
    }

}