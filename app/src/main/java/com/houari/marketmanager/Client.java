package com.houari.marketmanager;

import android.database.Cursor;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.houari.marketmanager.database.SqliteHelper;
import com.houari.marketmanager.database.table_client;
import com.houari.marketmanager.entities.Adapter_Client;
import com.houari.marketmanager.entities.client;

import java.util.ArrayList;

public class Client extends AppCompatActivity {
EditText nom,prenom,tel;
SqliteHelper mydb;
    ArrayList<client> list = new ArrayList<>();
    client cl;
    ListView list_client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        nom = findViewById(R.id.Nom);
        prenom = findViewById(R.id.Prenom);
        tel = findViewById(R.id.Tel);
        mydb = new SqliteHelper(this);
        list_client = findViewById(R.id.list_client);
        setDataToList();
        Adapter_Client x= new Adapter_Client(Client.this,list);
        list_client.setAdapter(x);
    }
        public void setDataToList(){

            Cursor cursor = mydb.selectAll(table_client.TABLE_NAME);
            while (cursor.moveToNext()){
                cl = new client();
                cl.setID_CLIENT(cursor.getString(cursor.getColumnIndex(table_client.ID)));
                cl.setNOM(cursor.getString(cursor.getColumnIndex(table_client.NOM)));
                cl.setPRENOM(cursor.getString(cursor.getColumnIndex(table_client.PRENOM)));
                cl.setTEL(cursor.getString(cursor.getColumnIndex(table_client.TEL)));

                list.add(cl);
            }
        }
    public void click(View v){

        long id =  mydb.insert(table_client.TABLE_NAME,new String[]{table_client.NOM,table_client.PRENOM,
                        table_client.TEL},
                new String[]{nom.getText().toString(),
                        prenom.getText().toString(),
                        tel.getText().toString()});


        if(id != -1){
            Toast.makeText(getBaseContext(),"تم حفظ معلومات الزبون", Toast.LENGTH_LONG).show();
            list.clear();
            setDataToList();
            Adapter_Client x= new Adapter_Client(Client.this,list);
            list_client.setAdapter(x);

        }else{
            Toast.makeText(getBaseContext(),"خطأ في حفظ المعلومات", Toast.LENGTH_LONG).show();
        }

    }

}

