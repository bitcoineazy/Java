package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager extends Employee {
    private Book books = new Book();
    public Manager(int id, String name, String surname, String middleName, String address, int employeeId) {
        super(id, name, surname, middleName, address, employeeId);
    }

    public void createNewBook(int id, String name, String author, String edition, String publisher, int publication_year, String category) throws Exception {
        HashMap<String , String> addBook = new HashMap<>();
        addBook.put("id", Integer.toString(id));
        addBook.put("name", name);
        addBook.put("author", author);
        addBook.put("edition", edition);
        addBook.put("publisher", publisher);
        addBook.put("publication_year", Integer.toString(publication_year));
        addBook.put("category", category);
        books.addNewBook(addBook);
    }

    public void deleteBook(int id) {
        // Менеджер удаляет книгу
    }

    public int findBooksByCategory(String category) {
        // Менеджер ищет кол-во книг по категории
        int result = books.getIndexesFromValue("category", category).size();
        System.out.println("Кол-во книг по теме: " + category + " - " + result + "шт.");
        return result;
    }

    public int findBooksByName(String name){
        // Менеджер ищет кол-во книг по имени
        return books.getIndexesFromValue("name", name).size();
    }

    public int findBooksByAuthor(String author) {
        // Менеджер ищет кол-во книг по автору
        return books.getIndexesFromValue("author", author).size();
    }

    public int findBooksByAttribute(String column, String attribute) {
        // Менеджер ищет кол-во книг по атрибуту
        return books.getIndexesFromValue(column, attribute).size();
    }

    public void findBooksByReader(List<Reader> all_readers) {
        // Менеджер ищет книги, которые брал конкретный читатель
        for (Reader reader: all_readers) {
            System.out.println("Имя: " + reader.name + " Фамилия: " + reader.surname + " ID книг, которые брал: " + reader.bookIds);
        }

    }

    public void findBooksDistribution(List<Reader> all_readers, Book books) throws Exception {
        // Менеджер определяет сколько книг было взято читателями
        // и сколько еще находится в библиотеке
        int reader_books = 0;
        for (Reader reader: all_readers) {
            reader_books += reader.bookAmount;
            //System.out.println(reader.bookIds);
        }
        System.out.println("Кол-во книг у читателей: " + reader_books);
        System.out.println("Кол-во книг в библиотеке: " + books.getIdBooks().size());
    }

    public ArrayList<Integer> findBooksByReaders(List<Reader> all_readers) {
        ArrayList<Integer> readerBookIds = new ArrayList<>();
        for (Reader reader: all_readers) {
            for (Integer taken_id: reader.bookIds
                 ) {
                readerBookIds.add(taken_id);
            }
        }
        return readerBookIds;
    }

    public void getAdvancedStatistics(Book books, LibraryEmployee libraryEmployee) {
        int length;
        HashMap<String, String> dataBook;
        ArrayList<HashMap<String, String>> repeatingBooks;
        ArrayList<Integer> booksI = new ArrayList<>();
        ArrayList<Integer> ignoringIndex = new ArrayList<>();
        int uniqBooks = 0;
        ArrayList<String> uniqName = new ArrayList<>();
        ArrayList<String> uniqAuthor = new ArrayList<>();
        ArrayList<String> uniqEdition = new ArrayList<>();
        ArrayList<String> uniqPublisher = new ArrayList<>();
        ArrayList<String> uniqPublication_year = new ArrayList<>();
        ArrayList<String> uniqCategory = new ArrayList<>();

        try {
            books.getCountRows();
            length = books.getLength();

            for (int index = 1; index < length; index++) {
                booksI.clear();
                if (ignoringIndex.contains(index)){
                    continue;
                }
                dataBook = books.getRowFromIndex(index);
                dataBook.remove("id");
                repeatingBooks = libraryEmployee.getBooksByCriteria(books, dataBook);
                for (HashMap<String, String> book: repeatingBooks) {
                    booksI.add(books.getIndexesFromValue("id", book.get("id")).get(0));
                }
                ignoringIndex.addAll(booksI);
                if (!uniqName.contains(dataBook.get("name"))){
                    uniqName.add(dataBook.get("name"));
                }
                if (!uniqAuthor.contains(dataBook.get("author"))){
                    uniqAuthor.add(dataBook.get("author"));
                }
                if (!uniqEdition.contains(dataBook.get("edition"))){
                    uniqEdition.add(dataBook.get("edition"));
                }
                if (!uniqPublisher.contains(dataBook.get("publisher"))){
                    uniqPublisher.add(dataBook.get("publisher"));
                }
                if (!uniqPublication_year.contains(dataBook.get("publication_year"))){
                    uniqPublication_year.add(dataBook.get("publication_year"));
                }
                if (!uniqCategory.contains(dataBook.get("category"))){
                    uniqCategory.add(dataBook.get("category"));
                }
                uniqBooks++;
            }
            System.out.println("Уникальных книг: " + uniqBooks);
            System.out.println("Уникальные имена: " + uniqName.toString());
            System.out.println("Уникальные автор(ы): " + uniqAuthor.toString());
            System.out.println("Уникальные издатель(и): " + uniqEdition.toString());
            System.out.println("Уникальные издание(я): " + uniqPublisher.toString());
            System.out.println("Уникальные годы издание(я): " + uniqPublication_year.toString());
            System.out.println("Уникальные категория(и): " + uniqCategory.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}