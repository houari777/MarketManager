package com.houari.marketmanager.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import com.houari.marketmanager.R;
import com.houari.marketmanager.entities.product;



import java.util.List;

/**
 * Created by Azhar Rivaldi on 03/11/2019.
 */

public class Adapter_Products extends RecyclerView.Adapter {

    private List<product> movieList;

    public Adapter_Products(List<product> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.model_produits, parent, false);

        return new RowViewHolder(itemView);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {

           // rowViewHolder.IMAGE_PRODUIT.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.LABEL_PRODUIT.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.QTE_IN_STOCK.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.PRIX_ACHAT.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.PRIX_VENTE.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.DATE_PERIM.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.BARECODE.setBackgroundResource(R.drawable.table_header_cell_bg);


            rowViewHolder.LABEL_PRODUIT.setText("اسم السلعة");
            rowViewHolder.QTE_IN_STOCK.setText("الكمية الموجودة في المحل");
            rowViewHolder.PRIX_ACHAT.setText("ثمن الشراء");
            rowViewHolder.PRIX_VENTE.setText("ثمن البيع");
            rowViewHolder.DATE_PERIM.setText("تاريخ انتهاء الصلاحية");
            rowViewHolder.BARECODE.setText("الباركود");
        } else {
            product modal = movieList.get(rowPos - 1);

          //  rowViewHolder.IMAGE_PRODUIT.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.LABEL_PRODUIT.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.QTE_IN_STOCK.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.PRIX_ACHAT.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.PRIX_VENTE.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.DATE_PERIM.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.BARECODE.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.LABEL_PRODUIT.setText(modal.getLABEL_PRODUIT() + "");
            rowViewHolder.QTE_IN_STOCK.setText(modal.getQTE_IN_STOCK()+"");
            rowViewHolder.PRIX_ACHAT.setText(modal.getPRIX_ACHAT() + "");
            rowViewHolder.PRIX_VENTE.setText(modal.getPRIX_VENTE() + "");
            rowViewHolder.DATE_PERIM.setText(modal.getDATE_PERIM()+"");
            rowViewHolder.BARECODE.setText(modal.getBARECODE() + "");
         //   byte[] ImageProd = modal.getIMAGE_PRODUIT();
         //   Bitmap bitmap = BitmapFactory.decodeByteArray(ImageProd, 0, ImageProd.length);
           // rowViewHolder.IMAGE_PRODUIT.setImageBitmap(bitmap);
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size() + 1;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView LABEL_PRODUIT;
        TextView QTE_IN_STOCK;
        TextView PRIX_ACHAT;
        TextView PRIX_VENTE;
        TextView DATE_PERIM;
        TextView BARECODE;
      //  ImageView IMAGE_PRODUIT;

        RowViewHolder(View itemView) {
            super(itemView);
            LABEL_PRODUIT = itemView.findViewById(R.id.LABEL_PRODUIT);
            QTE_IN_STOCK = itemView.findViewById(R.id.QTE_IN_STOCK);
            PRIX_ACHAT = itemView.findViewById(R.id.PRIX_ACHAT);
            PRIX_VENTE = itemView.findViewById(R.id.PRIX_VENTE);
            DATE_PERIM = itemView.findViewById(R.id.DATE_PERIM);
            BARECODE = itemView.findViewById(R.id.BARECODE);
           // IMAGE_PRODUIT = itemView.findViewById(R.id.IMAGE_PRODUIT);
        }
    }
}
