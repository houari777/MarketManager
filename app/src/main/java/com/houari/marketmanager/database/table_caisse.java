package com.houari.marketmanager.database;

public abstract class table_caisse {
    public final static String TABLE_NAME = "CAISSE";

    public final static String ID_TRANSACTION = "ID_TRANSACTION";
    public final static String DATE = "DATE";
    public final static String DEBUT = "DEBUT";
    public final static String TOTAL = "TOTAL";
    public final static String GRAND_TOTAL = "GRAND_TOTAL";
    public final static String ID_VENTE = "ID_VENTE";

    public final static String CREATE_TABLE_CAISSE = "CREATE TABLE " + TABLE_NAME + " ( " + ID_TRANSACTION + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            " " + DATE + " TEXT , " + DEBUT + " TEXT , " + TOTAL + " TEXT, " + GRAND_TOTAL + " TEXT , " + ID_VENTE + " INTEGER );";
   }
