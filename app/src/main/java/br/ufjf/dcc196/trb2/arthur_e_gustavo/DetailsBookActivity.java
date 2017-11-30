package br.ufjf.dcc196.trb2.arthur_e_gustavo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.adapters.ParticipantAdapter;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers.BookingHelper;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Book;

public class DetailsBookActivity extends AppCompatActivity {

    private Book book;
    private EditText edtTitle;
    private EditText edtPublisher;
    private EditText edtYear;
    private ListView listBookings;
    private ParticipantAdapter participantAdapter;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_book);

        book = (Book) getIntent().getSerializableExtra("book");

        edtTitle = (EditText) findViewById(R.id.edtBookTitle);
        edtTitle.setFocusable(false);
        edtTitle.setText(book.getTitle());

        edtPublisher = (EditText) findViewById(R.id.edtBookPublisher);
        edtPublisher.setFocusable(false);
        edtPublisher.setText(book.getPublisher());

        edtYear = (EditText) findViewById(R.id.edtBookYear);
        edtYear.setFocusable(false);
        edtYear.setText(book.getYear().toString());

        listBookings = (ListView) findViewById(R.id.listBookBookings);
        participantAdapter =
                new ParticipantAdapter(getApplicationContext(), BookingHelper.getInstance().getListParticipants(book));
        listBookings.setAdapter(participantAdapter);

        btnBack = (Button) findViewById(R.id.btnBackDetailsBook);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
