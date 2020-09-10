package com.houari.marketmanager.database;

public class table_credit {
    public final static String TABLE_NAME = "CREDIT";

    public final static String ID_CREDIT = "ID_CREDIT";
    public final static String GENRE_CREDIT = "GENRE_CREDIT";
    public final static String DATE = "DATE";
    public final static String PRIX = "PRIX";
    public final static String PRIX_TOTAL = "PRIX_TOTAL";
    public final static String ID_CLIENT = "ID_CLIENT";

    public final static String CREATE_TABLE_CREDIT = "CREATE TABLE " + TABLE_NAME + " ( " + ID_CREDIT + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            " " + GENRE_CREDIT + " TEXT , " + DATE + " TEXT , " + PRIX + " TEXT, " + PRIX_TOTAL + " TEXT , " + ID_CLIENT + " INTEGER );";

}
