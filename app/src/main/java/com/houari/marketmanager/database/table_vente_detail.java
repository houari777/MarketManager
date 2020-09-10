package com.houari.marketmanager.database;

public class table_vente_detail {
    public final static String TABLE_NAME = "VENTE_DETAIL";

    public final static String ID_PRODUIT = "ID_PRODUIT";
    public final static String ID_VENTE = "ID_VENTE";
    public final static String QTE = "QTE";


    public final static String CREATE_TABLE_VENTE_DETAIL = "CREATE TABLE " + TABLE_NAME + " ( " + ID_PRODUIT + " INTEGER  ," +
            " " + ID_VENTE + " INTEGER , " + QTE + " TEXT  );";
}
