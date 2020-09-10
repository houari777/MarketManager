package com.houari.marketmanager.entities;

public class vente_detail {
     private int ID_PRODUIT;
     private int  ID_VENTE;
     private String QTE;

    public vente_detail(int ID_PRODUIT, int ID_VENTE, String QTE) {
        this.ID_PRODUIT = ID_PRODUIT;
        this.ID_VENTE = ID_VENTE;
        this.QTE = QTE;
    }

    public int getID_PRODUIT() {
        return ID_PRODUIT;
    }

    public void setID_PRODUIT(int ID_PRODUIT) {
        this.ID_PRODUIT = ID_PRODUIT;
    }

    public int getID_VENTE() {
        return ID_VENTE;
    }

    public void setID_VENTE(int ID_VENTE) {
        this.ID_VENTE = ID_VENTE;
    }

    public String getQTE() {
        return QTE;
    }

    public void setQTE(String QTE) {
        this.QTE = QTE;
    }
}
