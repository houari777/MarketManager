package com.houari.marketmanager.entities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.houari.marketmanager.R;

import java.util.ArrayList;

public class vente_adapter extends BaseAdapter {
    Context c;
    ArrayList<Entite_vente> list;
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

    public vente_adapter(Context c, ArrayList<Entite_vente> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.model_vente,null);
        }
        TextView barecode = (TextView) convertView.findViewById(R.id.txt_Model_barcode);
        TextView nom = (TextView) convertView.findViewById(R.id.txt_Model_NOM);
        TextView nombre = (TextView) convertView.findViewById(R.id.txt_Model_nombre);
        TextView total = (TextView) convertView.findViewById(R.id.txt_Model_Total);


        barecode.setText(list.get(position).getBarcode());
        nom.setText(list.get(position).getNOM());
        nombre.setText(list.get(position).getNombre());
        total.setText(list.get(position).getTotale());

        if(position % 2 == 1){
            convertView.setBackgroundColor(Color.BLUE);
        }else{
            convertView.setBackgroundColor(Color.RED);

        }



        return convertView;
    }
}
