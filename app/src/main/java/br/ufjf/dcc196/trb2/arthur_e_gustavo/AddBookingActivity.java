package br.ufjf.dcc196.trb2.arthur_e_gustavo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.adapters.SpinnerAdapter;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers.BookHelper;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers.BookingHelper;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers.ParticipantHelper;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Book;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Booking;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Participant;

public class AddBookingActivity extends AppCompatActivity {

    private SpinnerAdapter participantAdapter;
    private SpinnerAdapter bookAdapter;
    private Spinner spnParticipant;
    private Spinner spnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_booking);

        Button btnAdd = (Button) findViewById(R.id.btnAddBooking);
        Button btnBack = (Button) findViewById(R.id.btnBackBooking);

        spnParticipant = (Spinner) findViewById(R.id.spnParticipant);
        spnBook = (Spinner) findViewById(R.id.spnBook);

        participantAdapter = new SpinnerAdapter(this, R.layout.support_simple_spinner_dropdown_item, ParticipantHelper.getInstance().getListParticipant());
        spnParticipant.setAdapter(participantAdapter);

        bookAdapter = new SpinnerAdapter(this, R.layout.support_simple_spinner_dropdown_item, BookHelper.getInstance().getListBooks());
        spnBook.setAdapter(bookAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean error = false;

                if (spnParticipant.getSelectedItemPosition() == 0) {
                    ((TextView) spnParticipant.getSelectedView()).setError("");
                    error = true;
                }

                if (spnBook.getSelectedItemPosition() == 0) {
                    ((TextView) spnBook.getSelectedView()).setError("");
                    error = true;
                }

                if (!error) {
                    Participant participant = (Participant) spnParticipant.getSelectedItem();
                    Book book = (Book) spnBook.getSelectedItem();
                    BookingHelper.getInstance().addBooking(new Booking(participant, book));
                    Toast.makeText(AddBookingActivity.this, getResources().getString(R.string.successfully_registered), Toast.LENGTH_LONG).show();
                    spnParticipant.setSelection(0);
                    spnBook.setSelection(0);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void finish() {
        spnParticipant.setVisibility(View.INVISIBLE);
        spnBook.setVisibility(View.INVISIBLE);
        super.finish();
        participantAdapter.finish();
        bookAdapter.finish();
    }
}
