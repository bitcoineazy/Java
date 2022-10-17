package org.example;

import java.util.ArrayList;

public class Reader extends Human {
    // Кол-во книг у читателя
    public int bookAmount;
    // Какие именно id книг взял читатель
    public ArrayList<Integer> bookIds;

    public Reader(int id, String name, String surname, String middleName, String address, int bookAmount, ArrayList<Integer> bookIds) {
        super(id, name, surname, middleName, address);
        this.bookAmount = bookAmount;
        this.bookIds = bookIds;
    }

    public void takeBook(Book books, LibraryEmployee libraryEmployee, int bookId) throws Exception {
        // Читатель просит библиотечного работника дать ему книгу
        libraryEmployee.giveBookToReader(books, this, bookId);
    }

    public void returnBook(LibraryEmployee libraryEmployee, int bookId) throws Exception {
        // Читатель дает книгу библиотечному
        // работнику и он возвращает книгу в библиотеку
        libraryEmployee.returnBookFromReader(this, bookId);
    }
}
