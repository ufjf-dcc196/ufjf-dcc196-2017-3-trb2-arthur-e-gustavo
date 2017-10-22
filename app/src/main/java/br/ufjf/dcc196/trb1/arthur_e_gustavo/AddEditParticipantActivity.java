package br.ufjf.dcc196.trb1.arthur_e_gustavo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.helpers.ParticipantHelper;
import br.ufjf.dcc196.trb1.arthur_e_gustavo.models.Participant;

public class AddEditParticipantActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtEmail;
    private Button btnAdd;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_participant);

        edtName = (EditText) findViewById(R.id.edtParticipantName);
        edtEmail = (EditText) findViewById(R.id.edtParticipantEmail);
        btnAdd = (Button) findViewById(R.id.btnAddParticipant);
        btnBack = (Button) findViewById(R.id.btnBackParticipant);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean error = false;
                if (edtName.getText().toString().isEmpty()) {
                    edtName.setError(getResources().getString(R.string.edt_name_empty));
                    edtName.requestFocus();
                    error = true;
                }
                if (edtEmail.getText().toString().isEmpty()) {
                    edtEmail.setError(getResources().getString(R.string.edt_email_empty));
                    edtEmail.requestFocus();
                    error = true;
                }
                if (!error) {
                    Participant participant = new Participant(edtName.getText().toString(), edtEmail.getText().toString());
                    ParticipantHelper.getInstance().addParticipant(participant);
                    Toast.makeText(AddEditParticipantActivity.this, getResources().getString(R.string.successfully_registered), Toast.LENGTH_LONG).show();
                    edtName.setText("");
                    edtEmail.setText("");
                    edtName.requestFocus();
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
}
