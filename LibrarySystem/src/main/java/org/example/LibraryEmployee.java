package org.example;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibraryEmployee extends Employee {

    private final String rootPath = "src/main/resources";

    private StringBuilder log = new StringBuilder();

    public LibraryEmployee(int id, String name, String surname, String middleName, String address, int employeeId) {
        super(id, name, surname, middleName, address, employeeId);
        readLog();
    }

    public void giveBookFromOption(Book books, Reader reader, HashMap<String, String> bookOptions, ArrayList<Integer> IDGetBooks){
        ArrayList<Integer> indexes_old = new ArrayList<>();
        ArrayList<Integer> indexes_new = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        int count = 0;
        for (Map.Entry entry: bookOptions.entrySet()) {
            indexes.clear();
            indexes_new = books.getIndexesFromValue((String) entry.getKey(), (String) entry.getValue());
            if (count == 0){
                indexes_old.addAll(indexes_new);
            }
            for (Integer index :indexes_new) {
                if (indexes_old.contains(index)){
                    indexes.add(index);
                }
            }
            indexes_old.clear();
            indexes_old.addAll(indexes);
            count++;

        }
        ArrayList<Integer> IdsBook = new ArrayList<>();
        for (Integer index :indexes_old) {
            try {
                IdsBook.add(Integer.valueOf(books.getRowFromIndex(index).get("id")));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        for(Integer id: IdsBook){
            if (IDGetBooks.contains(id)){
                if (reader.bookIds.contains(id)) {
                    System.out.println("У читателя уже есть эта книга");
                    return;
                } else {
                    continue;
                }
            }
            reader.bookAmount += 1;
            reader.bookIds.add(id);
            System.out.println("Читателю выдана книга с ID: " + id);
            log(String.format("Reader id %s, name %s, surname %s, middleName %s, address %s; get book with id %s",
                    reader.id, reader.name, reader.surname, reader.middleName, reader.address, id));

        }
        System.out.println("Все искомые книги уже взяты");

    }

    public void giveBookToReader(Book books, Reader reader, int id) throws Exception {
        // Библиотечный работник ищет книгу и дает её читателю
        // Обновляя при этом читателя (кол-во книг, какие именно)
        if (books.getIdBooks().contains(id)) {
            if (!reader.bookIds.contains(id)) {
                reader.bookAmount += 1;
                reader.bookIds.add(id);
                System.out.println("Читателю выдана книга с ID: " + id);
                log(String.format("Reader id %s, name %s, surname %s, middleName %s, address %s; get book with id %s",
                        reader.id, reader.name, reader.surname, reader.middleName, reader.address, id));
            } else {
                System.out.println("У читателя уже есть эта книга");
            }
        } else {
            System.out.println("В библиотеке не существует книги с ID: " + id);
        }
    }

    public void returnBookFromReader(Reader reader, int id) throws Exception {
        reader.bookAmount -= 1;
        reader.bookIds.remove(id);
        log(String.format("Reader id %s, name %s, surname %s, middleName %s, address %s; return book with id %s",
                reader.id, reader.name, reader.surname, reader.middleName, reader.address, id));
    }

    public void readLog() {
        try {
            java.io.FileReader logFile = new java.io.FileReader(rootPath + "/log");
            int character = logFile.read();
            while (character != -1) {
                log.append((char) character);
                character = logFile.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Don`t find log file");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Read log from file failed");
            throw new RuntimeException(e);
        }
    }

    public void log(String data) {
        log.append(data + "\n");
        try {
            FileWriter logWrite = new FileWriter(rootPath + "/log");
            logWrite.write(log.toString());
            logWrite.flush();
            logWrite.close();
        } catch (IOException e) {
            System.out.println("Write log in file failed");
            throw new RuntimeException(e);
        }
    }
    public String getLog() {
        return log.toString();
    }

}
