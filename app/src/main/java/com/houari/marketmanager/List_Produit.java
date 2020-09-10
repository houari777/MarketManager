package com.houari.marketmanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.houari.marketmanager.database.SqliteHelper;
import com.houari.marketmanager.database.table_produit;
import com.houari.marketmanager.entities.Adapter_Product;
import com.houari.marketmanager.entities.product;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class List_Produit extends AppCompatActivity {

    GridView gridView;
    product pl = new product();
    ArrayList<product> list;
    Adapter_Product adapter = null;
    SqliteHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__produit);
        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new Adapter_Product(this, R.layout.model_produit, list);
        gridView.setAdapter(adapter);
        mydb = new SqliteHelper(this);
        list.clear();
        setDataToList();
        adapter.notifyDataSetChanged();
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                CharSequence[] items = {"تغيير", "حذف"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(List_Produit.this);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 0) {
                            // update
                            Cursor c = mydb.selectAll(table_produit.TABLE_NAME);
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            // show dialog update at here
                            showDialogUpdate(List_Produit.this, arrID.get(position));

                        } else {
                            // delete
                            Cursor c = mydb.selectAll(table_produit.TABLE_NAME);
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });

    }

    ImageView imageView;
    private void showDialogUpdate(List_Produit activity, final int position){

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.update_produit);
        dialog.setTitle("تغيير");

        imageView = (ImageView) dialog.findViewById(R.id.imageView   );
        final EditText edtName = (EditText) dialog.findViewById(R.id.edtName);
        final EditText edtPrice = (EditText) dialog.findViewById(R.id.edtPrice);
        final EditText edtQte = (EditText) dialog.findViewById(R.id.edtQte);
        Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate);

        // set width for dialog
        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        // set height for dialog
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // request photo library
                Intent intimg= new Intent(Intent.ACTION_GET_CONTENT);
                intimg.setType("image/*");
                startActivityForResult(intimg,100);

            }
        });

      /*  btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mydb.updateData(
                            edtName.getText().toString().trim(),
                            edtPrice.getText().toString().trim(), edtQte.getText().toString().trim(),
                            List_Produit.imageViewToByte(imageView),
                            position
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "تم تغيير معلومات البضاعة!!!", Toast.LENGTH_SHORT).show();
                }*/
                /*catch (Exception error) {
                    Log.e("Update error", error.getMessage());
                }
                setDataToList();
            }
        });*/
    }

    private void showDialogDelete(final int idFood){
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(List_Produit.this);

        dialogDelete.setTitle("تنبيه");
        dialogDelete.setMessage("هل تريد فعلا حذف البضاعة");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                   mydb.deleteData(idFood);
                    Toast.makeText(getApplicationContext(), "تم حذف المنتوج", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Log.e("error", e.getMessage());
                }
                setDataToList();
            }

        });

        dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

       public void setDataToList(){

        Cursor cursor = mydb.selectAll(table_produit.TABLE_NAME);
        pl = new product();
        while (cursor.moveToNext()){
            pl = new product();
            pl.setLABEL_PRODUIT (cursor.getString(cursor.getColumnIndex(table_produit.NAME)));
            pl.setPRIX_VENTE(cursor.getString(cursor.getColumnIndex(table_produit.PRICE2)));
            pl.setQTE_IN_STOCK(cursor.getString(cursor.getColumnIndex(table_produit.NUMBER)));
            pl.setIMAGE_PRODUIT(cursor.getBlob(cursor.getColumnIndex(table_produit.IMAGE_PRODUIT)));

            list.add(pl);
        }
    }
    void opengalery(View view){
        Intent intimg= new Intent(Intent.ACTION_GET_CONTENT);
        intimg.setType("image/*");
        startActivityForResult(intimg,100);
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
                imageView.setImageBitmap(decodstream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}
