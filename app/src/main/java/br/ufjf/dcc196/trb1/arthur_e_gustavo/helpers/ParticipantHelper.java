package br.ufjf.dcc196.trb1.arthur_e_gustavo.helpers;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.dcc196.trb1.arthur_e_gustavo.models.Participant;

public class ParticipantHelper {
    private static final ParticipantHelper INSTANCE = new ParticipantHelper();
    private List<Participant> listParticipant;

    public static ParticipantHelper getInstance() {
        return INSTANCE;
    }

    private ParticipantHelper() {
        criarParticipant();
    }

    private void criarParticipant() {
        listParticipant = new ArrayList<>();
        listParticipant.add(new Participant("Fulano de tal", "fulano@email.com"));
        listParticipant.add(new Participant("Ciclano de tal", "ciclano@email.com"));
        listParticipant.add(new Participant("Beltrano de tal", "beltrano@email.com"));
    }

    public List<Participant> getListParticipant() {
        return listParticipant;
    }

    public void addParticipant(Participant participant) {
        listParticipant.add(participant);
    }
}
