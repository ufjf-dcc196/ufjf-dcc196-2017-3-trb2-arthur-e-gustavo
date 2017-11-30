package br.ufjf.dcc196.trb2.arthur_e_gustavo.models;

import java.io.Serializable;

public class Book implements Serializable {
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

    public boolean equalsTo(Book other) {
        return this.title.equals(other.getTitle()) && this.publisher.equals(other.getPublisher())
                && this.year.equals(other.getYear());
    }

    @Override
    public String toString() {
        return this.title;
    }
}
