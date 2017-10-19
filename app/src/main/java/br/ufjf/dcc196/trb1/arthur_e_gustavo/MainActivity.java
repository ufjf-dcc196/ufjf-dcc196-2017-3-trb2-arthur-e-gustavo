package br.ufjf.dcc196.trb1.arthur_e_gustavo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.adapters.ParticipantAdapter;
import br.ufjf.dcc196.trb1.arthur_e_gustavo.helpers.ParticipantHelper;

public class MainActivity extends AppCompatActivity {

    private ListView listParticipants;
    private Button btnCadParticipant;
    private Button btnCadBook;
    private ParticipantAdapter participantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listParticipants = (ListView) findViewById(R.id.listParticipant);
        participantAdapter = new ParticipantAdapter(getApplicationContext(), ParticipantHelper.getInstance().getListParticipant());
        listParticipants.setAdapter(participantAdapter);

        btnCadParticipant = (Button) findViewById(R.id.btnCadParticipant);
        btnCadParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEditParticipantActivity.class);
                intent.putExtra("activity_title", getResources().getString(R.string.cad_participant));
                startActivity(intent);
            }
        });

        btnCadBook = (Button) findViewById(R.id.btnCadBook);
        btnCadBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEditBookActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        participantAdapter.notifyDataSetChanged();
        super.onResume();
    }
}