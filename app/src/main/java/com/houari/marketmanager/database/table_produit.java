package com.houari.marketmanager.database;

public class table_produit {
    public final static String TABLE_NAME = "PRODUIT";

    public final static String ID = "ID_PRODUIT";
    public final static String NAME = "LABEL_PRODUIT";
    public final static String BARCODE = "barcode";
    public final static String PRICE = "PRIX_ACHAT";
    public final static String PRICE2 = "PRIX_VENTE";
    public final static String NUMBER = "QTE_IN_STOCK";
    public final static String DATE_PERIM = "DATE_PERIM";
    public final static String IMAGE_PRODUIT ="IMAGE_PRODUIT";



    public final static String CREATE_TABLE_PRODUIT = "CREATE TABLE " + TABLE_NAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + BARCODE+" TEXT,"+
            " " + NAME + " TEXT , " + NUMBER + " TEXT,  " + PRICE + " TEXT ," +PRICE2 + " TEXT , " + DATE_PERIM + " TEXT , " + IMAGE_PRODUIT + " Blob );";
}
