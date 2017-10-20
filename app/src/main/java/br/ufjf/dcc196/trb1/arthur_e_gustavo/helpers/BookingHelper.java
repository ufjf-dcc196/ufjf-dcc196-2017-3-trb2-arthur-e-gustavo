package br.ufjf.dcc196.trb1.arthur_e_gustavo.helpers;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.models.Booking;

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

    public void addBooking(Booking booking) {
        listBooking.add(booking);
    }
}
