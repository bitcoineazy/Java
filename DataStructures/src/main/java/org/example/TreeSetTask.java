package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreeSetTask {
    public final static String fileName = "src/main/resources/tree_set_task";
    public final static String resultFileName = "src/main/resources/tree_set_task_result";
    public static String readData(String file) {
        StringBuilder data = new StringBuilder();
        try {
            FileReader newReader = new FileReader(file);
            int character = newReader.read();
            while (character != -1) {
                data.append((char) character);
                character = newReader.read();
            }
            newReader.close();
        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
        System.out.println("Успешное чтение файла");
        return data.toString();
    }

    public static void dataProcess(TreeSet<String> wordTreeSet, String data) {
        String[] lines = data.split("\n");
        String wordStr;
        try {
            for (String line: lines) {
                Pattern word = Pattern.compile( "\\w+", Pattern.UNICODE_CHARACTER_CLASS );
                Matcher matcher = word.matcher( line );
                while ( matcher.find() ) {
                    wordStr = matcher.group().toLowerCase();
                    wordTreeSet.add(wordStr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveResult(String text) {
        try {
            FileWriter myWriter = new FileWriter(resultFileName);
            myWriter.write(String.valueOf(text));
            myWriter.close();
            System.out.println("Результат сохранен");
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении результата");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /*
        Используя класс TreeSet, напишите программу, которая читает текст из файла, удаляет повторяющиеся
        слова и все знаки препинания, а затем сохраняет результат в новый текстовый файл.
         */

        TreeSet<String> wordsSet = new TreeSet<>();
        String data = readData(fileName);
        dataProcess(wordsSet, data);
        System.out.println(wordsSet);
        saveResult(wordsSet.toString());

    }
}
