package br.ufjf.dcc196.trb2.arthur_e_gustavo.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.R;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers.AppContract;

public class BookAdapter extends CursorAdapter {

    public BookAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.book_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textTitle = view.findViewById(R.id.book_view_txtTitle);
        String title = cursor.getString(cursor.getColumnIndexOrThrow(AppContract.Book.COLUMN_NAME_TITLE));
        textTitle.setText(title);
    }
}
