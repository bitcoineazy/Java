package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HashMapReader {
    private final String filePath = "src/main/resources/hashmap_task";

    Map<String, String> hashMap = new HashMap<String, String>();

    public String getValue(String key) {
        return hashMap.get(key);
    }

    public void startRead() throws IOException {

        FileReader reader = new java.io.FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);

        String s;
        String word;
        while((s = br.readLine()) != null) {

            Scanner scan = new Scanner(s);

            while (scan.hasNext()) {

                word = scan.nextLine().toLowerCase();
                String[] splited_words = word.split(":");
                System.out.println(Arrays.toString(word.split(":")));
                hashMap.put(splited_words[0], splited_words[1]);
            }
        }
        System.out.println(List.of(hashMap));


    }

    public static void main(String[] args) throws IOException {
        /*
         Напишите простую программу-словарь, которая считывает информацию из файла и сохраняет ее в
         HashMap. Пользователь должен иметь возможность искать слово с помощью меню, которое постоянно
         отображается. Текстовый файл должен иметь следующую структуру:
         Слово1: Значение1
         Слово2 : Значение2
         */

        HashMapReader hashMapReader = new HashMapReader();
        System.out.println("Our hashmap");
        hashMapReader.startRead();

        System.out.println("Введите ключ для поиска значения");
        Scanner find_word_scanner = new Scanner(System.in);
        String wordFind = find_word_scanner.nextLine();

        System.out.println(hashMapReader.getValue(wordFind));
    }
}
