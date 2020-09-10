package com.houari.marketmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.Editable;

public class SqliteHelper extends SQLiteOpenHelper {



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_produit.CREATE_TABLE_PRODUIT);
        db.execSQL(table_client.CREATE_TABLE_CLIENT);
        db.execSQL(table_caisse.CREATE_TABLE_CAISSE);
        db.execSQL(table_credit.CREATE_TABLE_CREDIT);
        db.execSQL(table_vente.CREATE_TABLE_VENTE);
        db.execSQL(table_vente_detail.CREATE_TABLE_VENTE_DETAIL);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int  newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_produit.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + table_client.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + table_credit.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + table_caisse.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + table_vente.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + table_vente_detail.TABLE_NAME);
        onCreate(db);
    }
    public SqliteHelper(Context context) {
        super(context, "Prod.db", null, 9);
    }
    public long insert(String tableName, String[] cName, String[] cValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        for (int i = 0; i < cName.length; i++) {
            c.put(cName[i], cValue[i]);
        }
        long id = db.insert(tableName, null, c);
        return id;
    }
    public void insertData(String LABEL_PRODUIT, String QTE_IN_STOCK, String barecode , String PRIX_ACHAT, String PRIX_VENTE, String DATE_PERIM, byte[] IMAGE_PRODUIT){
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "INSERT INTO "+table_produit.TABLE_NAME +" VALUES ( NULL,?, ?,?, ?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,barecode);
        statement.bindString(2, LABEL_PRODUIT);
        statement.bindString(3, QTE_IN_STOCK);
        statement.bindString(4, PRIX_ACHAT);
        statement.bindString(5,PRIX_VENTE);
        statement.bindString(6,DATE_PERIM);
        statement.bindBlob(7, IMAGE_PRODUIT);

        statement.executeInsert();
    }
    public void insertdetail(int id_vente,int id_produit,String qty){
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "INSERT INTO "+table_vente_detail.TABLE_NAME +" VALUES ( ?, ?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,id_produit);
        statement.bindDouble(2, id_vente);
        statement.bindString(3, qty);


        statement.executeInsert();
    }
    public long update(String tableName, String[] cName, String[] cValue, String colNameToUpdate,
                       String colValueToUpdate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        for (int i = 0; i < cName.length; i++) {
            c.put(cName[i], cValue[i]);
        }
        long number = db.update(tableName, c, colNameToUpdate + " = ?", new String[]{colValueToUpdate});
        return number;
    }

    public Cursor selectAllw(String tableName, String colName, Editable colValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + tableName +" where "+colName+" =?" , new String[]{String.valueOf(colValue)});
        return c;
    }
    public Cursor selectAll(String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + tableName+"",null );
        return c;
    }

    public long delete(String tableName, String cloName, String colValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName, cloName + " = ?", new String[]{colValue});

    }
    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM "+table_produit.TABLE_NAME +" WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }
   /* public Cursor getUser(String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + User.TABLE_NAME + " where " +
                User.NAME + " = ? AND " + User.PASSWORD + " = ? ", new String[]{name, password});
        return c;
    }*/
   public void updateData( String qte, String BARCODE) {
       SQLiteDatabase database = getWritableDatabase();

       String sql = "UPDATE "+table_produit.TABLE_NAME +" SET LABEL_PRODUIT = ?, PRIX_VENTE = ?, QTE_IN_STOCK = ? WHERE BARCODE = ?";
       SQLiteStatement statement = database.compileStatement(sql);


       statement.bindString(1, qte);

       statement.bindString(2,BARCODE);

       statement.execute();
       database.close();
   }
    public void updateDatas(String qty, String name, String price) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE "+table_produit.TABLE_NAME +" SET "+ table_produit.NUMBER+" = ? WHERE ("+table_produit.NAME+" = ?  AND "+table_produit.PRICE2+"=?)";
        SQLiteStatement statement = database.compileStatement(sql);


        statement.bindString(1, qty);
        statement.bindString(2, name);
        statement.bindString(3, price);



        statement.execute();
        database.close();
    }
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
}
