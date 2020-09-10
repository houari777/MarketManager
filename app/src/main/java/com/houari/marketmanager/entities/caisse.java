package com.houari.marketmanager.entities;

public class caisse {

    private int ID_TRANSACTION;
    private String DATE;
    //private String DEBUT;
    private String TOTAL;
   // private String GRAND_TOTAL;
    private int  ID_VENTE;

    public caisse(int ID_TRANSACTION, String DATE,  String TOTAL, int ID_VENTE) {
        this.ID_TRANSACTION = ID_TRANSACTION;
        this.DATE = DATE;

        this.TOTAL = TOTAL;
       // this.GRAND_TOTAL = GRAND_TOTAL;
        this.ID_VENTE = ID_VENTE;
    }

    public int getID_TRANSACTION() {
        return ID_TRANSACTION;
    }

    public void setID_TRANSACTION(int ID_TRANSACTION) {
        this.ID_TRANSACTION = ID_TRANSACTION;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }



    public String getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(String TOTAL) {
        this.TOTAL = TOTAL;
    }




    public int getID_VENTE() {
        return ID_VENTE;
    }

    public void setID_VENTE(int ID_VENTE) {
        this.ID_VENTE = ID_VENTE;
    }
}
