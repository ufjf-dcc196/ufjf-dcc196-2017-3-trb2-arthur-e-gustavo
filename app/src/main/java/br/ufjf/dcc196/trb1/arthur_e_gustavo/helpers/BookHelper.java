package br.ufjf.dcc196.trb1.arthur_e_gustavo.helpers;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.models.Book;

public class BookHelper {

    private static final BookHelper INSTANCE = new BookHelper();
    private List<Book> listBook;

    private BookHelper() {
        createBook();
    }

    public static BookHelper getInstance() {
        return INSTANCE;
    }

    private void createBook() {
        listBook = new ArrayList<>();
        listBook.add(new Book("Livro 3", "Editora 3", 2010));
        listBook.add(new Book("Livro 2", "Editora 2", 2011));
        listBook.add(new Book("Livro 1", "Editora 1", 2012));
    }

    public List<Book> getListBooks() {
        return listBook;
    }

    public void addBook(Book book) {
        listBook.add(book);
    }
}
