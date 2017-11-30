package br.ufjf.dcc196.trb2.arthur_e_gustavo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.R;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Book;

import static br.ufjf.dcc196.trb2.arthur_e_gustavo.R.layout.book_view;

public class BookAdapter extends ArrayAdapter<Book> {

    private static final Comparator<Book> comparatorBook = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            return b1.getTitle().toLowerCase().compareTo(b2.getTitle().toLowerCase());
        }
    };

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
        this.sort(comparatorBook);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book Book = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(book_view, parent, false);
        }
        TextView textTitle = convertView.findViewById(R.id.book_view_txtTitle);
        textTitle.setText(Book.getTitle());
        return convertView;
    }


    @Override
    public void notifyDataSetChanged() {
        this.setNotifyOnChange(false);
        this.sort(comparatorBook);
        super.notifyDataSetChanged();
        this.setNotifyOnChange(true);
    }
}
