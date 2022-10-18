package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("213123");
        Book books = new Book();

        System.out.println(books.getRowFromIndex(3));
//        try {
//            //ArrayList<Integer> idBooks = books.getIdBooks();
//            HashMap<String, String> data = books.getRowFromIndex(3);
//
//            System.out.println("DATA" + data);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        int selectedOption = -1;

        List<Reader> all_readers = new ArrayList<Reader>();

        Manager manager1 = new Manager(1, "First Manager", "Surname1",
                "MiddleName1", "address1", 1);
        LibraryEmployee libraryEmployee1 = new LibraryEmployee(2, "Second Manager", "Surname2",
                "MiddleName2", "address2", 2);
        ArrayList<Integer> reader_books = new ArrayList<Integer>();
        Reader reader1 = new Reader(2, "Second Manager", "Surname2",
                "MiddleName2", "address2", 0, reader_books);

        reader1.takeBook(books, libraryEmployee1, 1);
        reader1.takeBook(books, libraryEmployee1, 20);
        //reader1.takeBook(books, libraryEmployee1, 20);

        all_readers.add(reader1);

        System.out.println(reader1.bookIds);
        System.out.println(reader1.bookAmount);
        manager1.findBooksDistribution(all_readers, books);
        System.out.println(manager1.findBooksByCategory("roman"));
        //System.out.println(books.getRowFromIndex(2));

        //manager1.createNewBook(1, "dDS", "Dasd", "dasdas", "dasd", 1999, "dasd");
        System.out.println(books.getRowFromIndex(1));
        System.out.println("""
                1 - Менеджер // Меню управления
                2 - Менеджер // Сколько книг по конкретной теме
                3 - Менеджер // Какие книги брал читатель
                4 - Менеджер // Статистика по книгам
                5 - Вывести информацию
                """);
        while (selectedOption != 20) {
            Scanner menu = new Scanner(System.in);
            System.out.println("Введите команду: ");
            selectedOption = menu.nextInt();
            switch (selectedOption) {
                case (1) -> {
                    System.out.println("""
                                   Меню менеджера
                                   
                        1 - Менеджер // Создать новую книгу
                        2 - Работники // Сколько книг по конкретной теме
                        3 - Менеджер // Какие книги брал читатель
                        4 - Менеджер // Статистика по книгам
                        5 - Выйти из меню управления менеджером
                        """);

                    Scanner manager_menu = new Scanner(System.in);
                    int managerOption = manager_menu.nextInt();
                    switch (managerOption) {
                        // Создать новую книгу
                        case(1) -> {
                            System.out.println("Введите ID новой книги: ");
                            Scanner book_create_scanner = new Scanner(System.in);
                            int book_id = book_create_scanner.nextInt();

                            System.out.println("Введите название новой книги: ");
                            Scanner name_scanner = new Scanner(System.in);
                            String name_scanned = name_scanner.nextLine();
                            System.out.println(name_scanned);

                            System.out.println("Введите автора новой книги: ");
                            Scanner author_scanner = new Scanner(System.in);
                            String book_author = author_scanner.nextLine();

                            System.out.println("Введите издание новой книги: ");
                            Scanner edition_scanner = new Scanner(System.in);
                            String book_edition = edition_scanner.nextLine();

                            System.out.println("Введите издателя новой книги: ");
                            Scanner publisher_scanner = new Scanner(System.in);
                            String book_publisher = publisher_scanner.nextLine();

                            System.out.println("Введите год новой книги: ");
                            Scanner year_scanner = new Scanner(System.in);
                            int book_year = year_scanner.nextInt();

                            System.out.println("Введите тему новой книги: ");
                            Scanner category_scanner = new Scanner(System.in);
                            String book_category = category_scanner.nextLine();

                            manager1.createNewBook(book_id, name_scanned, book_author, book_edition, book_publisher, book_year, book_category);

                            System.out.println(books.getAllDataList());
                        }
                        // Какие книги брал читатель
                        case (3) -> {
                            manager1.findBooksByReader(all_readers);
                        }
                        // Менеджер статистика по книгам
                        case (4) -> {
                            manager1.findBooksDistribution(all_readers, books);
                        }
                        case (5) -> {
                            System.out.println(books.getAllDataList());
                            System.out.println(books.getRowFromIndex(4));
                        }
                    }
                }
                case (5) -> {
                    System.out.println(books.getAllDataList());
                    System.out.println(books.getRowFromIndex(4));
                }
            }


        }




        /*
        HashMap<String , String> addRow = new HashMap<>();
        String[] columnName = new String[] {"id", "name", "author", "edition", "publisher", "publication_year", "category"};
        String[] values = new String[]{"20", "Book2", "Author1", "Издано: \"2003\"", "ABC\"Book\"", "2003", "roman"};
        for (int index = 0; index < columnName.length; index++){
            addRow.put(columnName[index], values[index]);
        }

        //books.addNewBook(addRow);

        try {
            ArrayList<Integer> ids = books.getIDsFromValue("author", "Author1");

            System.out.printf("Value %s include in row with ids: %s%n", "Author1", ids);

            HashMap<String, String> row1 = books.getRowFromId(1);
            for (String name: row1.keySet()) {
                String value = row1.get(name).toString();
                System.out.printf("%-20s :: %s%n",name, value);
            }

            ArrayList<HashMap<String, String>> rows = books.getRowsFromId(ids);

            System.out.printf("Value %s include in row with ids: %s%n", "Author1", ids);

            int count = 0;
            for(HashMap<String, String> row : rows){
                count++;
                System.out.printf("%s%n", count);
                for (String name: row.keySet()) {
                    String value = row.get(name).toString();
                    System.out.printf("\t%-20s :: %s%n",name, value);
                }
            }

            count = 0;
            for(HashMap<String, String> row : books.getAllData()){
                count++;
                System.out.printf("%s%n", count);
                for (String name: row.keySet()) {
                    String value = row.get(name).toString();
                    System.out.printf("\t%-20s :: %s%n",name, value);
                }
            }

            //HashMap<String, String> deleteRow = books.deleteRow(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

         */
    }

}
