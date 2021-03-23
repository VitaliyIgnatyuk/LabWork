package ru.sberbank.java.scool.lab;

import ru.sberbank.java.scool.lab.animal.Bear;
import ru.sberbank.java.scool.lab.animal.Dog;
import ru.sberbank.java.scool.lab.animal.Mouse;
import ru.sberbank.java.scool.lab.animal.Plant;
import ru.sberbank.java.scool.lab.labwork4.FileProcess;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {

    public static void main(String[] args) {
        Laboratory4();
    }

    private static void Laboratory3() {
        Dog dog = new Dog();
        Mouse mouse = new Mouse();
        System.out.println(dog.eating(mouse));
        Bear bear = new Bear();
        System.out.println(bear.eating(dog));
        System.out.println(dog.eating(bear));
        Plant plant = new Plant();
        System.out.println(bear.eating(plant));
    }

    private static void Laboratory4() {
        final char csReplaceChar = '1';
        final char csSpace = ' ';

        FileProcess fileProcess = new FileProcess("TestBaseFile.txt");
        try {
            fileProcess.createTempBaseFile();  // Создадим файл и заполним его данными
        } catch (IOException e) {
            System.out.printf("При создании файла \"%s\" произошла ошибка \"%s\"\n", fileProcess.getFilePath(), e.getMessage());
            return;
        }
        final String fileIOName = "TestNewFileIO.txt";
        try {
            // создадим новый файл с данными из базового файла, с заменой символов используя классы из пакета IO
            fileProcess.createNewFileIO(fileIOName, csReplaceChar, csSpace);
        } catch (IOException e) {
            System.out.printf("При создании файла \"%s\" произошла ошибка \"%s\"\n", fileIOName, e.getMessage());
            return;
        }
        final String fileNIOName = "TestNewFileNIO.txt";
        try {
            // создадим новый файл с данными из базового файла, с заменой символов используя классы из пакета NIO
            fileProcess.createNewFileNIO(fileNIOName, csReplaceChar, csSpace);
        } catch (IOException e) {
            System.out.printf("При создании файла \"%s\" произошла ошибка \"%s\"\n", fileNIOName, e.getMessage());
        }
    }

}
