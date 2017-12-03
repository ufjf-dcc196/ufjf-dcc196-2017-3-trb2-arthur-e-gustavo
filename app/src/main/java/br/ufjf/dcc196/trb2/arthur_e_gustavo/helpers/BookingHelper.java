package br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Book;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Booking;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Participant;

public class BookingHelper extends AppDbHelper {

    public BookingHelper(Context context) {
        super(context);
    }

    public Cursor getListBooks(Participant participant) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(AppContract.Booking.SQL_SELECT_BOOKS_BY_PARTICIPANT, new String[]{String.valueOf(participant.getId())});
        return cursor;
    }

    public Cursor getListParticipants(Book book) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(AppContract.Booking.SQL_SELECT_PARTICIPANTS_BY_BOOK, new String[]{String.valueOf(book.getId())});
        return cursor;
    }

    public void add(Booking booking) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(AppContract.Booking.COLUMN_NAME_PARTICIPANT, booking.getParticipant().getId());
            values.put(AppContract.Booking.COLUMN_NAME_BOOK, booking.getParticipant().getId());
            db.insert(AppContract.Booking.TABLE_NAME, null, values);
        } catch (Exception e) {
            Log.e("BOOKING", e.getLocalizedMessage());
            Log.e("BOOKING", e.getStackTrace().toString());
        }
    }
}
