package br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Participant;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.utils.DateUtils;

public class ParticipantHelper extends AppDbHelper {

    public ParticipantHelper(Context context) {
        super(context);
    }

    public Cursor getAllCursor() {
        try {
            SQLiteDatabase db = getReadableDatabase();
            String[] vision = {
                    AppContract.Participant._ID,
                    AppContract.Participant.COLUMN_NAME_NAME,
                    AppContract.Participant.COLUMN_NAME_EMAIL,
                    AppContract.Participant.COLUMN_NAME_ENTER_DATE,
                    AppContract.Participant.COLUMN_NAME_EXIT_DATE
            };
            String sort = AppContract.Participant.COLUMN_NAME_NAME + " ASC";
            return db.query(AppContract.Participant.TABLE_NAME, vision, null, null, null, null, sort);

        } catch (Exception e) {
            Log.e("PARTICIPANT", e.getLocalizedMessage());
            Log.e("PARTICIPANT", e.getStackTrace().toString());
            return null;
        }
    }

    public List<Participant> getAll() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(AppContract.Participant.SQL_SELECT_PARTICIPANTS, null);

        List<Participant> participants = new ArrayList<>();
        while (cursor.moveToNext()) {
            Participant participant = new Participant();
            participant.setId(cursor.getInt(cursor.getColumnIndex(AppContract.Participant._ID)));
            participant.setName(cursor.getString(cursor.getColumnIndex(AppContract.Participant.COLUMN_NAME_NAME)));
            participant.setEmail(cursor.getString(cursor.getColumnIndex(AppContract.Participant.COLUMN_NAME_EMAIL)));
            participant.setEnterDate(DateUtils.converToDate(cursor.getString(cursor.getColumnIndex(AppContract.Participant.COLUMN_NAME_ENTER_DATE))));
            participant.setExitDate(DateUtils.converToDate(cursor.getString(cursor.getColumnIndex(AppContract.Participant.COLUMN_NAME_EXIT_DATE))));
            participants.add(participant);
        }
        cursor.close();
        return participants;
    }

    public Participant add(Participant participant) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(AppContract.Participant.COLUMN_NAME_NAME, participant.getName());
            values.put(AppContract.Participant.COLUMN_NAME_EMAIL, participant.getEmail());
            long id = db.insert(AppContract.Participant.TABLE_NAME, null, values);
            participant.setId(id);
            return participant;
        } catch (Exception e) {
            Log.e("PARTICIPANT", e.getLocalizedMessage());
            Log.e("PARTICIPANT", e.getStackTrace().toString());
            return null;
        }
    }

    public void update(Participant participant) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(AppContract.Participant.COLUMN_NAME_NAME, participant.getName());
            values.put(AppContract.Participant.COLUMN_NAME_EMAIL, participant.getEmail());
            values.put(AppContract.Participant.COLUMN_NAME_ENTER_DATE, DateUtils.convertToString(participant.getEnterDate()));
            values.put(AppContract.Participant.COLUMN_NAME_EXIT_DATE, DateUtils.convertToString(participant.getExitDate()));
            String where = AppContract.Participant._ID + " = ?";
            String[] args = {String.valueOf(participant.getId())};
            db.update(AppContract.Participant.TABLE_NAME, values, where, args);
        } catch (Exception e) {
            Log.e("PARTICIPANT", e.getLocalizedMessage());
            Log.e("PARTICIPANT", e.getStackTrace().toString());
        }
    }

    public Participant get(long id_participant) {
        Cursor cursor = null;
        Participant participant = new Participant();
        try {
            SQLiteDatabase db = getReadableDatabase();
            cursor = db.rawQuery(AppContract.Participant.SQL_SELECT_PARTICIPANT, new String[]{String.valueOf(id_participant)});

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                participant.setId(id_participant);
                participant.setName(cursor.getString(cursor.getColumnIndex(AppContract.Participant.COLUMN_NAME_NAME)));
                participant.setEmail(cursor.getString(cursor.getColumnIndex(AppContract.Participant.COLUMN_NAME_EMAIL)));
                participant.setEnterDate(DateUtils.converToDate(cursor.getString(cursor.getColumnIndex(AppContract.Participant.COLUMN_NAME_ENTER_DATE))));
                participant.setExitDate(DateUtils.converToDate(cursor.getString(cursor.getColumnIndex(AppContract.Participant.COLUMN_NAME_EXIT_DATE))));
            }
        } catch (Exception e) {
            Log.e("PARTICIPANT", e.getLocalizedMessage());
            Log.e("PARTICIPANT", e.getStackTrace().toString());
        } finally {
            cursor.close();
            return participant;
        }
    }
}
