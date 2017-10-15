package br.ufjf.dcc196.trb1.arthur_e_gustavo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.adapters.ParticipantAdapter;
import br.ufjf.dcc196.trb1.arthur_e_gustavo.helpers.ParticipantHelper;

public class MainActivity extends AppCompatActivity {

    private ListView listParticipants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParticipantHelper participantHelper = new ParticipantHelper();

        listParticipants = (ListView) findViewById(R.id.listParticipante);
        final ParticipantAdapter participantAdapter = new ParticipantAdapter(getApplicationContext(), participantHelper.getListParticipant());
        listParticipants.setAdapter(participantAdapter);



    }
}
