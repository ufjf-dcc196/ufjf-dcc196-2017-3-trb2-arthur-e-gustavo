package br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "App.db";

    public AppDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AppContract.Book.SQL_CREATE_BOOK);
        db.execSQL(AppContract.Participant.SQL_CREATE_PARTICIPANT);
        db.execSQL(AppContract.Booking.SQL_CREATE_BOOKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
