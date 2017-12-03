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
import br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers.AppDbHelper;

public class ParticipantAdapter extends CursorAdapter {
    private AppDbHelper appHelper;

    public ParticipantAdapter(Context context, Cursor c) {
        super(context, c);
        appHelper = new AppDbHelper(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.participant_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textTitle = view.findViewById(R.id.participant_view_txtName);
        String title = cursor.getString(cursor.getColumnIndexOrThrow(AppContract.Participant.COLUMN_NAME_NAME));
        textTitle.setText(title);
    }
}
