package com.houari.marketmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView card_vente,card_client,card_achat,card_caisse,card_baridi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card_vente=findViewById(R.id.card_vente);
       card_client=findViewById(R.id.card_client);
       card_achat=findViewById(R.id.card_achat);
        card_caisse=findViewById(R.id.card_caisse);
        card_baridi=findViewById(R.id.card_baridi);

        card_vente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Sale.class));


            }
        });

        card_achat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Produit.class));

            }
        });
        card_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Client.class));

            }
        });

    }
}