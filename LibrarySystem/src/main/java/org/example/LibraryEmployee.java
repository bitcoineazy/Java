package org.example;

public class LibraryEmployee extends Employee {

    public LibraryEmployee(int id, String name, String surname, String middleName, String address, int employeeId) {
        super(id, name, surname, middleName, address, employeeId);
    }

    public void giveBookToReader(Book books, Reader reader, int id) throws Exception {
        // Библиотечный работник ищет книгу и дает её читателю
        // Обновляя при этом читателя (кол-во книг, какие именно)
        if (books.getIdBooks().contains(id)) {
            if (!reader.bookIds.contains(id)) {
                reader.bookAmount += 1;
                reader.bookIds.add(id);
                System.out.println("Читателю выдана книга с ID: " + id);
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
    }
}
