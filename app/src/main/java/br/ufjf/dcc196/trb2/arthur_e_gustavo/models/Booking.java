package br.ufjf.dcc196.trb2.arthur_e_gustavo.models;

public class Booking {
    private Participant participant;
    private Book book;

    public Booking() {
    }

    public Booking(Participant participant, Book book) {
        this.participant = participant;
        this.book = book;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
