package com.houari.marketmanager.database;

public class table_vente {
    public final static String TABLE_NAME = "VENTE";

    public final static String ID_VENTE = "ID_VENTE";
    public final static String DATE_VENTE = "DATE_VENTE";
    public final static String ID_CLIENT = "ID_CLIENT";


    public final static String CREATE_TABLE_VENTE = "CREATE TABLE " + TABLE_NAME + " ( " + ID_VENTE + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            " " + DATE_VENTE + " TEXT , " + ID_CLIENT + " INTEGER  );";
}
