package br.ufjf.dcc196.trb1.arthur_e_gustavo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.R;
import br.ufjf.dcc196.trb1.arthur_e_gustavo.models.Participant;

public class ParticipantAdapter extends ArrayAdapter<Participant> {

    public ParticipantAdapter(Context context, List<Participant> participants) {
        super(context, 0, participants);
        this.sort(comparatorParticipant);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Participant participant = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.participant_view, parent, false);
        }
        TextView textName = convertView.findViewById(R.id.participante_view_txtName);
        textName.setText(participant.getName());
        return convertView;
    }

    public void sort() {
        this.sort(comparatorParticipant);
    }

    private static final Comparator<Participant> comparatorParticipant = new Comparator<Participant>() {
        public int compare(Participant p1, Participant p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };
}
