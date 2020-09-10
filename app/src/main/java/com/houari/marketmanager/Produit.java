package com.houari.marketmanager;



import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.houari.marketmanager.activities.List_Produits;
import com.houari.marketmanager.database.SqliteHelper;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Produit extends AppCompatActivity {

    EditText LABEL_PRODUIT, QTE_IN_STOCK, PRIX_ACHAT, PRIX_VENTE, DATE_PERIM;
    ImageButton IMAGE_PRODUIT;
   ImageButton ScanButton;
    Button save;
    SqliteHelper mydb;
    public static EditText tvresult;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);
        DATE_PERIM = findViewById(R.id.DATE_PERIM);
        DatePickerHelper assessmentDueDateHelper = new DatePickerHelper(Produit.this,
                DATE_PERIM);
        LABEL_PRODUIT =  findViewById(R.id.LABEL_PRODUIT);
        QTE_IN_STOCK = findViewById(R.id.QTE_IN_STOCK);
        PRIX_ACHAT = findViewById(R.id.PRIX_ACHAT);
        PRIX_VENTE = findViewById(R.id.PRIX_VENTE);
        IMAGE_PRODUIT = findViewById(R.id.IMAGE_PRODUIT);
        save=findViewById(R.id.Save);
        mydb = new SqliteHelper(this);
        tvresult = findViewById(R.id.BARECODE);
        ScanButton=findViewById(R.id.ScanButton);
        btn =  findViewById(R.id.btnc);
        ScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Produit.this, ScanActivity.class);
                startActivity(intent);
            }
        });

IMAGE_PRODUIT.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intimg= new Intent(Intent.ACTION_GET_CONTENT);
        intimg.setType("image/*");
        startActivityForResult(intimg,100);
    }
});
save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            mydb.insertData(LABEL_PRODUIT.getText().toString(), QTE_IN_STOCK.getText().toString(),tvresult.getText().toString(), PRIX_ACHAT.getText().toString(), PRIX_VENTE.getText().toString(), DATE_PERIM.getText().toString(),imageViewToByte(IMAGE_PRODUIT));
            Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Added faild!", Toast.LENGTH_SHORT).show();
        }

    }
});
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Produit.this, List_Produits.class);
        startActivity(intent);
    }
});
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== RESULT_OK && requestCode==100){
            Uri uri=data.getData();
            InputStream inputStream= null;
            try {
                inputStream = getContentResolver().openInputStream(uri);
                Bitmap decodstream = BitmapFactory.decodeStream(inputStream);
                IMAGE_PRODUIT.setImageBitmap(decodstream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
   /* public void onClick(View view) {

        try {
            mydb.insertData(tvresult.getText().toString(),LABEL_PRODUIT.getText().toString(), QTE_IN_STOCK.getText().toString(), PRIX_ACHAT.getText().toString(), PRIX_VENTE.getText().toString(), DATE_PERIM.getText().toString(),imageViewToByte(IMAGE_PRODUIT));
            Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
        }
    }*/
    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }





}
