package com.houari.marketmanager.database;

public class table_client {
    public final static String TABLE_NAME = "CLIENT";

    public final static String ID = "ID_CLIENT";
    public final static String NOM = "NOM";
    public final static String PRENOM = "PRENOM";
    public final static String TEL = "TEL";

    public final static String CREATE_TABLE_CLIENT = "CREATE TABLE " + TABLE_NAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            " " + NOM + " TEXT , " + PRENOM + " TEXT , " + TEL + " TEXT );";
}
