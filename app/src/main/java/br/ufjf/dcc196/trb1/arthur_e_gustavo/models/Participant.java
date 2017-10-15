package br.ufjf.dcc196.trb1.arthur_e_gustavo.models;

/**
 * Created by Gustavo Magalhães on 15/10/2017.
 */

public class Participant {

    private String name;
    private String email;

    public Participant() {
    }

    public Participant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
