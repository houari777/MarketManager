package com.houari.marketmanager.entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.houari.marketmanager.R;

import java.util.ArrayList;

public class Adapter_Product extends BaseAdapter {
    private Context context;

    private ArrayList<product> list;

    public Adapter_Product(Context context, int model_produit, ArrayList<product> list) {
        this.context = context;

        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.indexOf(getItem(position));
    }
    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice, txtQte;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.model_produit, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtQte = (TextView) row.findViewById(R.id.txtQte);
            holder.txtPrice = (TextView) row.findViewById(R.id.txtPrice);
            holder.imageView = (ImageView) row.findViewById(R.id.ImageProd);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        product prod = list.get(position);

        holder.txtName.setText(prod.getLABEL_PRODUIT());
        holder.txtPrice.setText(prod.getPRIX_VENTE());
        holder.txtQte.setText(prod.getQTE_IN_STOCK());
        byte[] ImageProd = prod.getIMAGE_PRODUIT();
        Bitmap bitmap = BitmapFactory.decodeByteArray(ImageProd, 0, ImageProd.length);
        holder.imageView.setImageBitmap(bitmap);
        return row;
    }
}
