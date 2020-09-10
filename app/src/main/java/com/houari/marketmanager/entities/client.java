package com.houari.marketmanager.entities;

public class client {
    private String ID_CLIENT;
    private String NOM;
    private String PRENOM;
    private String TEL;

    public client() {
        this.ID_CLIENT = ID_CLIENT;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.TEL = TEL;
    }

    public String getID_CLIENT() {
        return ID_CLIENT;
    }

    public void setID_CLIENT(String ID_CLIENT) {
        this.ID_CLIENT = ID_CLIENT;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }
}
