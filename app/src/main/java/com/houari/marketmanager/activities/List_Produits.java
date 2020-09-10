package com.houari.marketmanager.activities;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.houari.marketmanager.R;
import com.houari.marketmanager.adapter.Adapter_Products;
import com.houari.marketmanager.database.SqliteHelper;
import com.houari.marketmanager.database.table_produit;

import com.houari.marketmanager.entities.product;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azhar Rivaldi on 03/11/2019.
 */

public class List_Produits extends AppCompatActivity {

    SqliteHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produits);
        mydb = new SqliteHelper(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);

        Adapter_Products adapter = new Adapter_Products(getMovieList());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
    }

    private List<product> getMovieList() {
        Cursor cursor = mydb.selectAll(table_produit.TABLE_NAME);
        List<product> movieList = new ArrayList<>();
        while (cursor.moveToNext()) {
            product pl = new product();
            pl.setLABEL_PRODUIT(cursor.getString(cursor.getColumnIndex(table_produit.NAME)));
            pl.setPRIX_VENTE(cursor.getString(cursor.getColumnIndex(table_produit.PRICE2)));
            pl.setQTE_IN_STOCK(cursor.getString(cursor.getColumnIndex(table_produit.NUMBER)));
          //  pl.setIMAGE_PRODUIT(cursor.getBlob(cursor.getColumnIndex(table_produit.IMAGE_PRODUIT)));
            pl.setDATE_PERIM(cursor.getString(cursor.getColumnIndex(table_produit.DATE_PERIM)));
            pl.setPRIX_ACHAT(cursor.getString(cursor.getColumnIndex(table_produit.PRICE)));

            movieList.add(pl);
        }
        return movieList;
    }
    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}
