package com.houari.marketmanager.entities;

public class vente {
  private int  ID_VENTE;
  private String DATE_VENTE;
  private int ID_CLIENT;

    public vente(int ID_VENTE, String DATE_VENTE, int ID_CLIENT) {
        this.ID_VENTE = ID_VENTE;
        this.DATE_VENTE = DATE_VENTE;
        this.ID_CLIENT = ID_CLIENT;
    }

    public int getID_VENTE() {
        return ID_VENTE;
    }

    public void setID_VENTE(int ID_VENTE) {
        this.ID_VENTE = ID_VENTE;
    }

    public String getDATE_VENTE() {
        return DATE_VENTE;
    }

    public void setDATE_VENTE(String DATE_VENTE) {
        this.DATE_VENTE = DATE_VENTE;
    }

    public int getID_CLIENT() {
        return ID_CLIENT;
    }

    public void setID_CLIENT(int ID_CLIENT) {
        this.ID_CLIENT = ID_CLIENT;
    }
}
