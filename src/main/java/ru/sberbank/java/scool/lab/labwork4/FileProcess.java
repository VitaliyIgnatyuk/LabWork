package ru.sberbank.java.scool.lab.labwork4;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@AllArgsConstructor
public class FileProcess {

    private String filePath;

    /**
     * Создание нового файла с использоватением классов и обёрток из пакета IO
     *
     * @param fileName Имя создаваемого файла
     * @param newChar  Символ для замены (все такие символы в новом файле будт заменены на символ переданный в oldChar)
     * @param oldChar  Символ которым будет заменён newChar
     * @throws IOException ошибки ввода вывода
     */
    public void createNewFileIO(String fileName, char oldChar, char newChar) throws IOException {
        File file = createFile(fileName);
        // Используем ресурсный try и обёртки из IO позволяющие удобно работать с текстовым файлом
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

             FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             PrintWriter printWriter = new PrintWriter(fileOutputStream)
        ) {
            String line;
            int iteration = 0;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.printf("%s\n", line.replace(oldChar, newChar));
                iteration++;
                if (iteration >= 10) {
                    printWriter.flush();
                    iteration = 0;
                }
            }
        }
    }

    /**
     * Создание файла и заполнение его данными с использованием пакета NIO и функционального подхода
     *
     * @param fileName Имя нового файла
     * @param newChar  Символ для замены (все такие символы в новом файле будт заменены на символ переданный в oldChar)
     * @param oldChar  Символ которым будет заменён newChar
     * @throws IOException Ошибки ввода вывода передадим выше для обработки
     */
    public void createNewFileNIO(String fileName, char oldChar, char newChar) throws IOException {
        final Path path = Paths.get(fileName);
        Files.deleteIfExists(path);
        final Path newFile = Files.createFile(path);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFile, StandardCharsets.UTF_8)) {
            Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8).
                    forEach((line) -> {
                        try {
                            bufferedWriter.write(line.replace(oldChar, newChar));
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    /**
     * Создание базового файла, через FileOutputStream без обёрток
     *
     * @throws IOException ошибки ввода вывода передадим выше для обработки
     */
    public void createTempBaseFile() throws IOException {
        File file = createFile(filePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            for (int i = 100000; i < 1000000; i++) {
                fileOutputStream.write(String.format("%d\n", i).getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    /**
     * Создаст и вернёт файл с переданным именем (если такой файл уже существует, то пересоздаст его)
     *
     * @param fileName Имя файла
     * @return объект типа File
     * @throws IOException ошибки ввода вывода
     */
    private File createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists() || file.delete())
            if (!file.createNewFile())
                throw new IOException("Файл не был создан");
        return file;
    }


}
