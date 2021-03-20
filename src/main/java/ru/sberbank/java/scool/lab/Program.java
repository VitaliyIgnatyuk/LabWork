package ru.sberbank.java.scool.lab;

import ru.sberbank.java.scool.lab.animal.*;

public class Program {

    public static void main(String[] args) {
        Laboratory3();
    }

    private  static  void  Laboratory3 () {
        Dog dog = new Dog();
        Mouse mouse = new Mouse();
        System.out.println(dog.eating(mouse));
        Bear bear = new Bear();
        System.out.println(bear.eating(dog));
        System.out.println(dog.eating(bear));
        Plant plant = new Plant();
        System.out.println(bear.eating(plant));
    }

}
