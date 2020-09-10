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

public class Adapter_Client extends BaseAdapter {
    Context c;
    ArrayList<client> list;

    public Adapter_Client(Context c, ArrayList<client> list) {
        this.c = c;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.model,null);
        }
        TextView id = (TextView) convertView.findViewById(R.id.txt_Model_ID);
        TextView nom = (TextView) convertView.findViewById(R.id.txt_Model_NOM);
        TextView prenom = (TextView) convertView.findViewById(R.id.txt_Model_PRENOM);
        TextView tel = (TextView) convertView.findViewById(R.id.txt_Model_TEL);


     id.setText(list.get(position).getID_CLIENT());
     nom.setText(list.get(position).getNOM());
     prenom.setText(list.get(position).getPRENOM());
     tel.setText(list.get(position).getTEL());

        if(position % 2 == 1){
            convertView.setBackgroundColor(Color.BLUE);
        }else{
            convertView.setBackgroundColor(Color.RED);

        }

        return convertView;
    }
}
