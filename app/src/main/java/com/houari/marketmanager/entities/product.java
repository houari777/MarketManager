package com.houari.marketmanager.entities;

public class product {

    private int ID_PRODUIT;
    private String LABEL_PRODUIT;
    private String BARECODE;
    private String QTE_IN_STOCK;
    private String PRIX_ACHAT;
    private String PRIX_VENTE;
    private String DATE_PERIM;
    private byte[] IMAGE_PRODUIT;

    public String getBARECODE() {
        return BARECODE;
    }

    public void setBARECODE(String BARECODE) {
        this.BARECODE = BARECODE;
    }

    public product() {
    }

    public product(int ID_PRODUIT, String LABEL_PRODUIT, String BARECODE, String QTE_IN_STOCK, String PRIX_ACHAT, String PRIX_VENTE, String DATE_PERIM, byte[] IMAGE_PRODUIT) {
        this.ID_PRODUIT = ID_PRODUIT;
        this.LABEL_PRODUIT = LABEL_PRODUIT;
        this.BARECODE = BARECODE;
        this.QTE_IN_STOCK = QTE_IN_STOCK;
        this.PRIX_ACHAT = PRIX_ACHAT;
        this.PRIX_VENTE = PRIX_VENTE;
        this.DATE_PERIM = DATE_PERIM;
        this.IMAGE_PRODUIT = IMAGE_PRODUIT;
    }

    public product(String LABEL_PRODUIT, String QTE_IN_STOCK, String PRIX_VENTE, byte[] IMAGE_PRODUIT) {
        this.LABEL_PRODUIT = LABEL_PRODUIT;
        this.QTE_IN_STOCK = QTE_IN_STOCK;
        this.PRIX_VENTE = PRIX_VENTE;
        this.IMAGE_PRODUIT = IMAGE_PRODUIT;
    }

    public product(int ID_PRODUIT, String LABEL_PRODUIT, String QTE_IN_STOCK, String PRIX_ACHAT, String PRIX_VENTE, String DATE_PERIM, byte[] IMAGE_PRODUIT) {
        this.ID_PRODUIT = ID_PRODUIT;
        this.LABEL_PRODUIT = LABEL_PRODUIT;
        this.QTE_IN_STOCK = QTE_IN_STOCK;
        this.PRIX_ACHAT = PRIX_ACHAT;
        this.PRIX_VENTE = PRIX_VENTE;
        this.DATE_PERIM = DATE_PERIM;
        this.IMAGE_PRODUIT = IMAGE_PRODUIT;
    }

    public product(int ID_PRODUIT, String LABEL_PRODUIT, String PRIX_VENTE) {
        this.ID_PRODUIT = ID_PRODUIT;
        this.LABEL_PRODUIT = LABEL_PRODUIT;
        this.PRIX_VENTE = PRIX_VENTE;
    }

    public int getID_PRODUIT() {
        return ID_PRODUIT;
    }

    public void setID_PRODUIT(int ID_PRODUIT) {
        this.ID_PRODUIT = ID_PRODUIT;
    }

    public String getLABEL_PRODUIT() {
        return LABEL_PRODUIT;
    }

    public void setLABEL_PRODUIT(String LABEL_PRODUIT) {
        this.LABEL_PRODUIT = LABEL_PRODUIT;
    }

    public String getQTE_IN_STOCK() {
        return QTE_IN_STOCK;
    }

    public void setQTE_IN_STOCK(String QTE_IN_STOCK) {
        this.QTE_IN_STOCK = QTE_IN_STOCK;
    }

    public String getPRIX_ACHAT() {
        return PRIX_ACHAT;
    }

    public void setPRIX_ACHAT(String PRIX_ACHAT) {
        this.PRIX_ACHAT = PRIX_ACHAT;
    }

    public String getPRIX_VENTE() {
        return PRIX_VENTE;
    }

    public void setPRIX_VENTE(String PRIX_VENTE) {
        this.PRIX_VENTE = PRIX_VENTE;
    }

    public String getDATE_PERIM() {
        return DATE_PERIM;
    }

    public void setDATE_PERIM(String DATE_PERIM) {
        this.DATE_PERIM = DATE_PERIM;
    }

    public byte[] getIMAGE_PRODUIT() {
        return IMAGE_PRODUIT;
    }

    public void setIMAGE_PRODUIT(byte[] IMAGE_PRODUIT) {
        this.IMAGE_PRODUIT = IMAGE_PRODUIT;
    }
}
