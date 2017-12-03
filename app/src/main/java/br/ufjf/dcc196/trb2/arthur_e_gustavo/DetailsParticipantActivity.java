package br.ufjf.dcc196.trb2.arthur_e_gustavo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.adapters.BookAdapter;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers.BookingHelper;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers.ParticipantHelper;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Participant;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.utils.DateUtils;

public class DetailsParticipantActivity extends AppCompatActivity {

    private Participant participant;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtEnterDate;
    private EditText edtExitDate;
    private ListView listBookings;
    private BookAdapter bookAdapter;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_participant);

        long id_participant = getIntent().getLongExtra("participant", -1);

        participant = new ParticipantHelper(getApplicationContext()).get(id_participant);

        edtName = (EditText) findViewById(R.id.edtParticipantName);
        edtName.setFocusable(false);
        edtName.setText(participant.getName());

        edtEmail = (EditText) findViewById(R.id.edtParticipantEmail);
        edtEmail.setFocusable(false);
        edtEmail.setText(participant.getEmail());

        edtEnterDate = (EditText) findViewById(R.id.edtParticipantEnterDate);
        edtEnterDate.setFocusable(false);
        if (participant.getEnterDate() != null) {
            edtEnterDate.setText(DateUtils.convertToString(participant.getEnterDate()));
        } else {
            edtEnterDate.setText(R.string.edt_missing);
        }

        edtExitDate = (EditText) findViewById(R.id.edtParticipantExitDate);
        edtExitDate.setFocusable(false);
        if (participant.getExitDate() != null) {
            edtExitDate.setText(DateUtils.convertToString(participant.getExitDate()));
        } else {
            edtExitDate.setText(R.string.edt_missing);
        }

        listBookings = (ListView) findViewById(R.id.listParticipantBookings);
        bookAdapter = new BookAdapter(getApplicationContext(), new BookingHelper(getApplicationContext()).getListBooks(participant));
        listBookings.setAdapter(bookAdapter);

        btnBack = (Button) findViewById(R.id.btnBackDetailsParticipant);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
