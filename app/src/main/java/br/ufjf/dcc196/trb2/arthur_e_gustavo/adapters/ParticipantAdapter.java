package br.ufjf.dcc196.trb2.arthur_e_gustavo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.R;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Participant;

public class ParticipantAdapter extends ArrayAdapter<Participant> {

    private static final Comparator<Participant> comparatorParticipant = new Comparator<Participant>() {
        public int compare(Participant p1, Participant p2) {
            return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
        }
    };

    public ParticipantAdapter(Context context, List<Participant> participants) {
        super(context, 0, participants);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Participant participant = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.participant_view, parent, false);
        }
        TextView textName = convertView.findViewById(R.id.participant_view_txtName);
        textName.setText(participant.getName());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        this.setNotifyOnChange(false);
        this.sort(comparatorParticipant);
        super.notifyDataSetChanged();
        this.setNotifyOnChange(true);
    }
}
