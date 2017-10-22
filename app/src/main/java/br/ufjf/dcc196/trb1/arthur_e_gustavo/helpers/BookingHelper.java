package br.ufjf.dcc196.trb1.arthur_e_gustavo.helpers;

import android.icu.text.MessagePattern;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.models.Book;
import br.ufjf.dcc196.trb1.arthur_e_gustavo.models.Booking;
import br.ufjf.dcc196.trb1.arthur_e_gustavo.models.Participant;

public class BookingHelper {

    private static final BookingHelper INSTANCE = new BookingHelper();
    private List<Booking> listBooking;

    private BookingHelper() {
        listBooking = new ArrayList<>();
    }

    public static BookingHelper getInstance() {
        return INSTANCE;
    }

    public List<Booking> getListBooking() {
        return listBooking;
    }

    public List<Book> getListBooks(Participant participant) {
        List<Book> filtered = new ArrayList<>();

        for (Booking booking: listBooking) {
            Participant bookingParticipant = booking.getParticipant();

            if (bookingParticipant.getName().equals(participant.getName())
                    && bookingParticipant.getEmail().equals(participant.getEmail())) {
                filtered.add(booking.getBook());
            }
        }

        return filtered;
    }

    public void addBooking(Booking booking) {
        listBooking.add(booking);
    }
}
