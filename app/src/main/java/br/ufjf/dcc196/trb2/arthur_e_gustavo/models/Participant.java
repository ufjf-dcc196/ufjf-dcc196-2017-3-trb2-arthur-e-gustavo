package br.ufjf.dcc196.trb2.arthur_e_gustavo.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Gustavo Magalhães on 15/10/2017.
 */

public class Participant implements Serializable {

    private String name;
    private String email;
    private Date enterDate;
    private Date exitDate;

    public Participant() {
    }

    public Participant(String name, String email) {
        this.name = name;
        this.email = email;
        this.enterDate = null;
        this.exitDate = null;
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

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public boolean equalsTo(Participant other) {
        return this.name.equals(other.getName()) && this.email.equals(other.getEmail());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
