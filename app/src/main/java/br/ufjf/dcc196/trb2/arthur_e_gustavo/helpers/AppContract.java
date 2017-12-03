package br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers;

import android.provider.BaseColumns;

public class AppContract {
    public static final String TEXT_TYPE = " TEXT";
    public static final String INT_TYPE = " INTEGER";
    public static final String SEP = ",";

    public AppContract() {
    }

    public static final class Book implements BaseColumns {
        public static final String TABLE_NAME = "book";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_PUBLISHER = "publisher";
        public static final String COLUMN_NAME_YEAR = "year";

        public static final String SQL_CREATE_BOOK = "CREATE TABLE " + Book.TABLE_NAME + " (" +
                _ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT" + SEP +
                COLUMN_NAME_TITLE + TEXT_TYPE + SEP +
                COLUMN_NAME_PUBLISHER + TEXT_TYPE + SEP +
                COLUMN_NAME_YEAR + INT_TYPE + ")";

        public static final String SQL_DROP_BOOK = "DROP TABLE IF EXISTS " + Book.TABLE_NAME;

        public static final String SQL_SELECT_BOOK = "SELECT " +
                _ID + SEP +
                COLUMN_NAME_TITLE + SEP +
                COLUMN_NAME_PUBLISHER + SEP +
                COLUMN_NAME_YEAR +
                " FROM " + TABLE_NAME +
                " WHERE " + _ID + " = ?";

        public static final String SQL_SELECT_BOOKS = "SELECT " +
                _ID + SEP +
                COLUMN_NAME_TITLE + SEP +
                COLUMN_NAME_PUBLISHER + SEP +
                COLUMN_NAME_YEAR +
                " FROM " + TABLE_NAME;
        public static final String SQL_DELETE_BOOK = "DELETE FROM " + TABLE_NAME + " WHERE " + _ID + " = ?";
    }

    public static final class Participant implements BaseColumns {
        public static final String TABLE_NAME = "participant";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_ENTER_DATE = "enter_date";
        public static final String COLUMN_NAME_EXIT_DATE = "exit_date";

        public static final String SQL_CREATE_PARTICIPANT = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT" + SEP +
                COLUMN_NAME_NAME + TEXT_TYPE + SEP +
                COLUMN_NAME_EMAIL + TEXT_TYPE + SEP +
                COLUMN_NAME_ENTER_DATE + TEXT_TYPE + SEP +
                COLUMN_NAME_EXIT_DATE + TEXT_TYPE + ")";

        public static final String SQL_DROP_PARTICIPANT = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String SQL_SELECT_PARTICIPANT = "SELECT " +
                _ID + SEP +
                COLUMN_NAME_NAME + SEP +
                COLUMN_NAME_EMAIL + SEP +
                COLUMN_NAME_ENTER_DATE + SEP +
                COLUMN_NAME_EXIT_DATE +
                " FROM " + TABLE_NAME +
                " WHERE " + _ID + " = ?";

        public static final String SQL_SELECT_PARTICIPANTS = "SELECT " +
                _ID + SEP +
                COLUMN_NAME_NAME + SEP +
                COLUMN_NAME_EMAIL + SEP +
                COLUMN_NAME_ENTER_DATE + SEP +
                COLUMN_NAME_EXIT_DATE +
                " FROM " + TABLE_NAME;
    }

    public static final class Booking implements BaseColumns {
        public static final String TABLE_NAME = "booking";
        public static final String COLUMN_NAME_BOOK = "id_book";
        public static final String COLUMN_NAME_PARTICIPANT = "id_participant";

        public static final String SQL_CREATE_BOOKING = "CREATE TABLE " + Booking.TABLE_NAME + " (" +
                COLUMN_NAME_BOOK + INT_TYPE + " NOT NULL REFERENCES " + Book.TABLE_NAME + "(" + Book._ID + ")" + SEP +
                COLUMN_NAME_PARTICIPANT + INT_TYPE + " NOT NULL REFERENCES " + Participant.TABLE_NAME + "(" + Participant._ID + ")" + SEP +
                " PRIMARY KEY (" + COLUMN_NAME_BOOK + SEP + COLUMN_NAME_PARTICIPANT + "))";

        public static final String SQL_DROP_BOOKING = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String SQL_SELECT_BOOKS = Book.SQL_SELECT_BOOKS +
                " JOIN " + TABLE_NAME + " ON " + Book._ID + " = " + COLUMN_NAME_BOOK;

        public static final String SQL_SELECT_PARTICIPANTS = Participant.SQL_SELECT_PARTICIPANTS +
                " JOIN " + TABLE_NAME + " ON " + Participant._ID + " = " + COLUMN_NAME_PARTICIPANT;

        public static final String SQL_SELECT_BOOKS_BY_PARTICIPANT = SQL_SELECT_BOOKS +
                " WHERE " + COLUMN_NAME_PARTICIPANT + " = ? ";

        public static final String SQL_SELECT_PARTICIPANTS_BY_BOOK = SQL_SELECT_PARTICIPANTS +
                " WHERE " + COLUMN_NAME_BOOK + " = ? ";

        public static final String SQL_DELETE_BOOKING_OR = "DELETE FROM " + TABLE_NAME +
                " WHERE " + COLUMN_NAME_BOOK + " = ? OR " + COLUMN_NAME_PARTICIPANT + " = ?";

        public static final String SQL_DELETE_BOOKING_AND = "DELETE FROM " + TABLE_NAME +
                " WHERE " + COLUMN_NAME_BOOK + " = ? AND " + COLUMN_NAME_PARTICIPANT + " = ?";
    }
}
