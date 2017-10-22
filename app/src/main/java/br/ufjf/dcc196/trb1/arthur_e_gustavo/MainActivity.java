package br.ufjf.dcc196.trb1.arthur_e_gustavo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.adapters.ParticipantAdapter;
import br.ufjf.dcc196.trb1.arthur_e_gustavo.helpers.ParticipantHelper;
import br.ufjf.dcc196.trb1.arthur_e_gustavo.models.Participant;

public class MainActivity extends AppCompatActivity {

    private ListView listParticipants;
    private Button btnCadParticipant;
    private Button btnCadBook;
    private Button btnCadBooking;
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

        btnCadBooking = (Button) findViewById(R.id.btnCadBooking);
        btnCadBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBookingActivity.class);
                startActivity(intent);
            }
        });

        listParticipants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsParticipantActivity.class);
                intent.putExtra("participant", participantAdapter.getItem(position));
                startActivity(intent);
            }
        });

        listParticipants.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Participant participant = participantAdapter.getItem(pos);
                if (participant.getEnterDate() == null) {
                    participant.setEnterDate(Calendar.getInstance().getTime());
                    Toast.makeText(MainActivity.this, String.format(getResources().getString(R.string.participant_define_enter_hour), participant.getName()), Toast.LENGTH_LONG).show();
                } else if (participant.getExitDate() == null) {
                    participant.setExitDate(Calendar.getInstance().getTime());
                    Toast.makeText(MainActivity.this, String.format(getResources().getString(R.string.participant_define_exit_hour), participant.getName()), Toast.LENGTH_LONG).show();
                } else {
                    participant.setEnterDate(null);
                    participant.setExitDate(null);
                    Toast.makeText(MainActivity.this, String.format(getResources().getString(R.string.participant_erase_hours), participant.getName()), Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        participantAdapter.notifyDataSetChanged();
        super.onResume();
    }
}