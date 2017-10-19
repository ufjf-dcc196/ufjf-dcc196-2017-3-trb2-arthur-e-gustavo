package br.ufjf.dcc196.trb1.arthur_e_gustavo.models;

public class Book {
    private String title;
    private String publisher;
    private Integer year;

    public Book() {
    }

    public Book(String title, String publisher, Integer year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
