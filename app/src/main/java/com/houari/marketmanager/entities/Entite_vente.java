package com.houari.marketmanager.entities;

public class Entite_vente {
    private String barcode;
    private String NOM;
    private String nombre;
    private int totale;

    public Entite_vente() {
    }

    public Entite_vente(String barcode, String NOM, String nombre, int totale) {
        this.barcode = barcode;
        this.NOM = NOM;
        this.nombre = nombre;
        this.totale = totale;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotale() {
        return totale;
    }

    public void setTotale(int totale) {
        this.totale = totale;
    }


}
