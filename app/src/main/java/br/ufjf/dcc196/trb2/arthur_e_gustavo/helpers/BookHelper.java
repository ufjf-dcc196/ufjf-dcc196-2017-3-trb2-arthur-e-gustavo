package br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Book;

public class BookHelper extends AppDbHelper {

    public BookHelper(Context context) {
        super(context);
    }

    public Cursor getAllCursor() {
        try {
            SQLiteDatabase db = getWritableDatabase();
            String[] vision = {
                    AppContract.Book._ID,
                    AppContract.Book.COLUMN_NAME_TITLE,
                    AppContract.Book.COLUMN_NAME_PUBLISHER,
                    AppContract.Book.COLUMN_NAME_YEAR,
            };
            String sort = AppContract.Book.COLUMN_NAME_TITLE + " ASC";
            return db.query(AppContract.Book.TABLE_NAME, vision, null, null, null, null, sort);
        } catch (Exception e) {
            Log.e("BOOK", e.getLocalizedMessage());
            Log.e("BOOK", e.getStackTrace().toString());
            return null;
        }
    }

    public List<Book> getAll() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(AppContract.Book.SQL_SELECT_BOOKS, null);

        List<Book> books = new ArrayList<>();
        while (cursor.moveToNext()) {
            Book book = new Book();
            book.setId(cursor.getInt(cursor.getColumnIndex(AppContract.Book._ID)));
            book.setTitle(cursor.getString(cursor.getColumnIndex(AppContract.Book.COLUMN_NAME_TITLE)));
            book.setPublisher(cursor.getString(cursor.getColumnIndex(AppContract.Book.COLUMN_NAME_PUBLISHER)));
            book.setYear(cursor.getInt(cursor.getColumnIndex(AppContract.Book.COLUMN_NAME_YEAR)));
            books.add(book);
        }
        cursor.close();

        return books;
    }

    public Book add(Book book) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(AppContract.Book.COLUMN_NAME_TITLE, book.getTitle());
            values.put(AppContract.Book.COLUMN_NAME_PUBLISHER, book.getPublisher());
            values.put(AppContract.Book.COLUMN_NAME_YEAR, book.getYear());
            long id = db.insert(AppContract.Book.TABLE_NAME, null, values);
            book.setId(id);
            return book;
        } catch (Exception e) {
            Log.e("BOOK", e.getLocalizedMessage());
            Log.e("BOOK", e.getStackTrace().toString());
            return null;
        }
    }

    public Book get(long id_book) {
        Cursor cursor = null;
        Book book = new Book();
        try {
            SQLiteDatabase db = getReadableDatabase();
            cursor = db.rawQuery(AppContract.Book.SQL_SELECT_BOOK, new String[]{String.valueOf(id_book)});

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                book.setId(id_book);
                book.setTitle(cursor.getString(cursor.getColumnIndex(AppContract.Book.COLUMN_NAME_TITLE)));
                book.setPublisher(cursor.getString(cursor.getColumnIndex(AppContract.Book.COLUMN_NAME_PUBLISHER)));
                book.setYear(cursor.getInt(cursor.getColumnIndex(AppContract.Book.COLUMN_NAME_YEAR)));
            }
            return book;
        } finally {
            cursor.close();
        }
    }
}
