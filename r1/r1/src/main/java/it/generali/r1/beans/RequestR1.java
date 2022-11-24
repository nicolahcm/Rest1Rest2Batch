package it.generali.r1.beans;

import java.sql.Timestamp;

public class RequestR1 {

    public int id_origine;
    public Timestamp data_creazione_origine;



    public RequestR1(int id_origine, Timestamp data_creazione_origine) {
        this.id_origine = id_origine;
        this.data_creazione_origine = data_creazione_origine;
    }

    public int getId_origine() {
        return id_origine;
    }

    public void setId_origine(int id_origine) {
        this.id_origine = id_origine;
    }

    public Timestamp getData_creazione_origine() {
        return data_creazione_origine;
    }

    public void setData_creazione_origine(Timestamp data_creazione_origine) {
        this.data_creazione_origine = data_creazione_origine;
    }

    @Override
    public String toString() {
        return "RequestR1{" +
                "id_origine=" + id_origine +
                ", data_creazione_origine=" + data_creazione_origine +
                '}';
    }
}
