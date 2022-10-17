package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFiles {

    public final static String FileName = "src/main/resources/Input.txt";
    public final static String finalFileName = "src/main/resources/Results.txt";

    public static boolean running = true;
    public static String word;

    // запись текста в файл
    public static void fileWriting(String text) {
        try {
            FileWriter myWriter = new FileWriter(finalFileName);
            myWriter.write(String.valueOf(text));
            myWriter.close();
            System.out.println("Результаты успешно сохранены");
        } catch (Exception e) {
            System.out.println("Ошибка сохранения результата");
            e.printStackTrace();
        }
    }

    // чтение данных из файла и вывод в строковом типе
    public static String fileReading() {
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println(String.format("Чтение данных из текстового файла %s ...", FileName));
            FileReader newReader = new FileReader(FileName);
            int character = newReader.read();
            while (character != -1) {
                sb.append((char) character);
                character = newReader.read();
            }
            newReader.close();
        } catch (Exception e) {
            System.out.println("Ошибка чтения");
            e.printStackTrace();
        }

        return sb.toString();
    }

    // получение числа слов из текста
    public static int getNumberWords(String text) {
        String[] words = text.split("[\\s\n]+");
        return words.length;
    }

    // общий шаблон для реализации регулярных выражений по поиску и подсчёту элементов в тексте
    public static int generalPatternCount(String text, String regex) {
        int count = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    // общий шаблон для получения данных в результате работы регулярных выражений
    public static String[] generalPatternGet(String text, String regex) {
        int count = generalPatternCount(text, regex);

        String[] matchers = new String[count];
        count = 0;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            matchers[count] = text.substring(matcher.start(), matcher.end());
            count++;
        }

        return matchers;
    }

    // общий шаблон по удалению найденных по регулярным выражениям элементов из текста
    public static String generalPatternDelete(String text, String regex) {
        StringBuilder sb = new StringBuilder(text);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            sb.delete(matcher.start(), matcher.end());
            matcher = pattern.matcher(sb);
        }

        return sb.toString();
    }

    // общий шаблон по нахождению индекса первой и последней буквы искомого в тексте слова
    public static void generalPatternGetNumberDesiredWords(String text, String regex) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.start() + ":::" + matcher.end());
        }
    }

    // количество букв в прописном регистре
    public static int upperCaseWordsCount(String text) {
        return generalPatternCount(text, "\\p{Lu}");
    }

    // количество букв в строчном регистре
    public static int lowerCaseWordsCount(String text) {
        return generalPatternCount(text, "[\\p{L}&&[^\\p{Lu}]]");
    }

    // количество пробелов в тексте
    public static int spacesCount(String text) {
        return generalPatternCount(text, " ");
    }

    // количество определённых знаков препинания в тексте
    public static int punctuationCount(String text) {
        return generalPatternCount(text, "[\"\\,\\. \\!\\?]");
    }

    // методы для получения количества целых чисел и массива строк с этими числами
    public static int integerCount(String text) {
        return generalPatternCount(text, "\\d+");
    }

    public static String[] integers(String text) {
        return generalPatternGet(text, "\\d+");
    }

    // методы для получения количества чисел с плавающей точкой и массива строк с этими числами
    public static int doublesCount(String text) {
        return generalPatternCount(text, "\\d\\.\\d*");
    }

    public static String[] doubles(String text) {
        return generalPatternGet(text, "\\d\\.\\d*");
    }

    public static void main(String[] args) {

        String inputText = fileReading();
        StringBuilder sb = new StringBuilder();

        sb.append("Текст из Input.txt:\n\n").append(inputText).append("\n++++++++++\n");
        System.out.println("Текст Input.txt:\n" + inputText + "\n");

        sb.append("Количество слов в тексте = ").append(getNumberWords(inputText)).append("\n\n++++++++++\n\n");
        System.out.println("Количество слов в тексте = " + getNumberWords(inputText) + "\n");

        sb.append("Количество прописных букв в тексте = ").append(upperCaseWordsCount(inputText)).append("\n\n++++++++++\n\n");
        System.out.println("Количество прописных букв в тексте = " + upperCaseWordsCount(inputText) + "\n");

        sb.append("Количество строчных букв в тексте = ").append(lowerCaseWordsCount(inputText)).append("\n\n++++++++++\n\n");
        System.out.println("Количество прописных букв в тексте = " + lowerCaseWordsCount(inputText) + "\n");

        sb.append("Сумма прописных и строчных букв в тексте = ").append(lowerCaseWordsCount(inputText) + upperCaseWordsCount(inputText)).append("\n\n++++++++++\n\n");
        System.out.println("Сумма прописных и строчных букв в тексте = " +
                (lowerCaseWordsCount(inputText) + upperCaseWordsCount(inputText)) + "\n");

        sb.append("Количество пробелов в тексте = ").append(spacesCount(inputText)).append("\n\n++++++++++\n\n");
        System.out.println("Количество пробелов в тексте = " + spacesCount(inputText) + "\n");

        sb.append("Количество целых чисел в тексте = ").append(integerCount(inputText)).append("\n\n++++++++++\n\n");
        System.out.println("Количество целых чисел в тексте = " + integerCount(inputText) + "\n");

        sb.append("Все целые числа в тексте:\n\n").append(Arrays.toString(integers(inputText))).append("\n\n++++++++++\n\n");
        System.out.println("Все целые числа в тексте:\n\n" + Arrays.toString(integers(inputText)) + "\n");

        sb.append("Отформатированные целые числа в 16-теричном формате:\n\n");
        System.out.println("Отформатированные целые числа в 16-теричном формате:\n\n");
        for (String s: integers(inputText)) {
            sb.append(String.format("%x", Integer.parseInt(s))).append("\n");
            System.out.printf("%x%n", Integer.parseInt(s));
        }
        sb.append("\n++++++++++\n\n");
        System.out.println("\n");

        sb.append("Количество чисел с плавающей точкой = ").append(doublesCount(inputText)).append("\n\n++++++++++\n\n");
        System.out.println("Количество чисел с плавающей точкой = " + doublesCount(inputText) + "\n");

        sb.append("Все числа с плавающей точкой в тексте: ").append(Arrays.toString(doubles(inputText))).append("\n\n++++++++++\n\n");
        System.out.println("Все числа с плавающей точкой в тексте: " + Arrays.toString(doubles(inputText)) + "\n");

        sb.append("Отформатированные числа с плавающей точкой с 2 десятичными знаками:\n\n");
        System.out.println("Отформатированные целые числа с 2 десятичными знаками:\n\n");

        for (String s: doubles(inputText)) {
            sb.append(String.format("%.2f", Double.parseDouble(s))).append("\n");
            System.out.printf("%.2f%n", Double.parseDouble(s));
        }

        sb.append("\n++++++++++\n\n");
        System.out.println("\n");

        sb.append("Количество знаков препинания в тексте = ").append(punctuationCount(inputText)).append("\n\n++++++++++\n");
        System.out.println("Количество знаков препинания в тексте = " + punctuationCount(inputText) + "\n++++++++++\n");

        sb.append("Текст без знаков препинания\n\n++++++++++\n\n" +
                generalPatternDelete(inputText, "[\"\\,\\. \\!\\?]") + "\n\n++++++++++\n");
        System.out.println("Текст без знаков препинания\n\n+++++++++\n\n" +
                generalPatternDelete(inputText, "[\"\\,\\. \\!\\?]") + "\n\n++++++++++\n");

        fileWriting(sb.toString());

        while (running) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите текст для поиска в файле: ");
            word = in.nextLine();

            System.out.print("Итоговый результат поиска в индексах:\t");
            generalPatternGetNumberDesiredWords(inputText, word);

            System.out.print("Продолжить поиск?");
            running = in.nextBoolean();
        }
    }
}