package com.houari.marketmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.ViewCompat;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


import com.houari.marketmanager.database.SqliteHelper;
import com.houari.marketmanager.database.table_produit;
import com.houari.marketmanager.database.table_vente;
import com.houari.marketmanager.entities.product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class Sale extends AppCompatActivity {
    private ArrayList<String> data= new ArrayList<String>();
    private ArrayList<String> data1= new ArrayList<String>();
    private ArrayList<String> data2= new ArrayList<String>();
    private ArrayList<String> data3= new ArrayList<String>();
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    AutoCompleteTextView produit;
    TextView SOMME_AL;
    TextView txt_nombre;
    static TextView rest_qty;
    Button Save;
    ImageButton Ajout,ScanButton;
    SqliteHelper mydb;
    QuantityView valueSelector;
    int count;
    final ArrayList<product> prods = new ArrayList<product>();

    private TableLayout tableLayout;
    static EditText barcode;
    EditText QTE_IN_STOCK;
    EditText PRIX_VENTE;
    EditText SOMME;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);


        Vector<String> v = new Vector();
        produit = findViewById(R.id.produit);
        barcode = findViewById(R.id.BARECODE);
        QTE_IN_STOCK = findViewById(R.id.QTE_IN_STOCK);
        PRIX_VENTE = findViewById(R.id.PRIX_VENTE);
        SOMME = findViewById(R.id.SOMME);
        rest_qty = findViewById(R.id.rst_qty);
        SOMME_AL = findViewById(R.id.SOMME_AL);
        Ajout = findViewById(R.id.Ajout);
        ScanButton = findViewById(R.id.ScanButton);
        Save = findViewById(R.id.Save);
        mydb = new SqliteHelper(this);
        valueSelector=findViewById(R.id.valueSelector);

//        btn_dec.setOnClickListener(clickListener);
        //  btn_inc.setOnClickListener(clickListener);





        titles.clear();
        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, titles);
        produit.setAdapter(arrayAdapter);


        final Cursor c = mydb.selectAll(table_produit.TABLE_NAME);
        if (c.moveToFirst()) {
            do {

                titles.add(  c.getString(c.getColumnIndex(table_produit.NAME)) +"-"+c.getString(c.getColumnIndex(table_produit.PRICE2))+"-"+c.getString(c.getColumnIndex(table_produit.NUMBER)));
            } while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            produit.invalidate();

        }
        produit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String aaa = arrayAdapter.getItem(position).toString();
              String[] parts = aaa.split("-");
                //   prod prod=prods.get(position);
         produit.setText( parts[0]);
         String ss=parts[0];
            PRIX_VENTE.setText(parts[1]);

            rest_qty.setText(parts[2]);
                int    qty2=Integer.parseInt ((String)rest_qty.getText())-1;
                rest_qty.setText(qty2+"");


                }




        });

        Ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add();
            }
        });
        ScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sale.this, ScanActivityS.class);
                startActivity(intent);
                Cursor cursor = mydb.selectAllw(table_produit.TABLE_NAME, table_produit.BARCODE, barcode.getText());
                while (cursor.moveToNext()) {


                    produit.setText(cursor.getString(cursor.getColumnIndex(table_produit.NAME)));
                    PRIX_VENTE.setText(cursor.getString(cursor.getColumnIndex(table_produit.PRICE2)));
                    rest_qty.setText(cursor.getString(cursor.getColumnIndex(table_produit.NUMBER)));
                    int    qty1=Integer.parseInt ((String)rest_qty.getText())-1;
                    rest_qty.setText(qty1+"");
                }
            }
        });
        Save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
                //obtenir la date courante
                Date date = new Date();

                int id_vente=0;
                //obtenir l'heure courante
                Calendar calendar = Calendar.getInstance();
long id=mydb.insert(table_vente.TABLE_NAME,new String[]{table_vente.DATE_VENTE},new String[]{format.format(calendar.getTime())});
                if(id != -1){
                    Toast.makeText(getBaseContext(),"تم حفظ معلومات الزبون",Toast.LENGTH_LONG).show();


                }else{
                    Toast.makeText(getBaseContext(),"خطأ في حفظ المعلومات",Toast.LENGTH_LONG).show();
                }
                Cursor cursor2=mydb.selectAll(table_vente.TABLE_NAME);
               cursor2.moveToLast();
                   id_vente=cursor2.getInt(0);



                for (product product:prods
                     ) {
                    mydb.insertdetail(id_vente,product.getID_PRODUIT(),product.getQTE_IN_STOCK());


                }
                prods.clear();
                initial();


            }





        });


    }




    public void add(){
        mydb.updateDatas(rest_qty.getText().toString(),produit.getText().toString(),PRIX_VENTE.getText().toString());
        int tot;
        String prodname=produit.getText().toString();
        int price=Integer.parseInt(PRIX_VENTE.getText().toString());
        int qty=valueSelector.getQuantity();
//        txt_nombre.setText(String.valueOf(count));
        Cursor cursor1 = mydb.selectAllw(table_produit.TABLE_NAME,table_produit.NAME,produit.getText());
        while (cursor1.moveToNext()) {
            product prod=new product();
            prod.setID_PRODUIT(cursor1.getInt(0));
            prod.setQTE_IN_STOCK(String.valueOf(valueSelector.getQuantity()));
            prods.add(prod);}
        tot=price*qty;

        data.add(prodname);
        data1.add(String.valueOf(price));
        data2.add(String.valueOf(valueSelector.getQuantity()));
        data3.add(String.valueOf(tot));
        TableLayout table=findViewById(R.id.tb1);






        TableRow row = new TableRow(this);
        ViewCompat.setLayoutDirection(row , ViewCompat.LAYOUT_DIRECTION_RTL);

        TextView t1=new TextView(this);
        TextView t2=new TextView(this);
        TextView t3=new TextView(this);
        TextView t4=new TextView(this);
        String total;
t1.setTextColor(Color.BLUE);
        t1.setTextSize(16);

        t2.setTextColor(Color.BLUE);
        t2.setTextSize(16);
        t3.setTextColor(Color.BLUE);
        t3.setTextSize(16);
        t4.setTextColor(Color.BLUE);
        t4.setTextSize(16);


        int sum=0;
        for (int i=0;i<data.size();i++){
            String pname=data.get(i);
            String prc=data2.get(i);
         String qtyy=data1.get(i);
            String tott=data3.get(i);
            t1.setTextDirection(View.TEXT_DIRECTION_RTL);
            t4.setText(tott);
            t2.setText(prc);
          t3.setText(qtyy);
            t1.setText(pname);
            sum=sum+Integer.parseInt(data3.get(i));
        }
        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);
        table.addView(row);
        SOMME.setText(String.valueOf(sum));
        SOMME_AL.setText(Convert.AR(String.valueOf(sum)));
       produit.setText("");
        PRIX_VENTE.setText("");
        barcode.setText("");
      rest_qty.setText("");
    valueSelector.init();
        //autoComplete.r;

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void initial(){

     TableLayout table=findViewById(R.id.tb1);
    // table.removeAllViews();
    // TableRow row1=findViewById(R.id.tbrow1);
    // table.addView(row1);
        table.removeViewsInLayout(1,data.size());
        data.clear();
        data2.clear();
        data1.clear();
        data3.clear();
        SOMME.setText("");
        SOMME_AL.setText("");
        produit.setText("");
        PRIX_VENTE.setText("");
        barcode.setText("");
        rest_qty.setText("");
        valueSelector.init();
    }


}