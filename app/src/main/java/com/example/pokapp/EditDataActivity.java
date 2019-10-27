package com.example.pokapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EditDataActivity extends AppCompatActivity
{

    private static final String TAG = "EditDataActivity";
    private EditText editable_item;
    //private Button btnDelete, btnSave;

    DatabaseHelper mDatabaseHelper;

    private String selectedtext;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_layout);

//        btnDelete = (Button)findViewById(R.id.btnDelete);
//        btnSave = (Button)findViewById(R.id.btnSave);

        editable_item = (EditText)findViewById(R.id.editable_item);

        mDatabaseHelper = new DatabaseHelper(this);

        Intent recievedIntent = getIntent();

        selectedID = recievedIntent.getIntExtra("id",-1);
        selectedtext = recievedIntent.getStringExtra("text");

        editable_item.setText(selectedtext);

//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 String item = editable_item.getText().toString();
//                 if (!item.equals(""))
//                 {
//                     mDatabaseHelper.updateNote(item,selectedID,selectedtext);
//                     Intent intent = new Intent(EditDataActivity.this,ListDataActivity.class);
//                     startActivity(intent);
//                 }
//                 else
//                 {
//                     Toast.makeText(EditDataActivity.this,"Enter the text",Toast.LENGTH_LONG).show();
//                 }
//            }
//        });
//
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mDatabaseHelper.deleteText(selectedID,selectedtext);
//                editable_item.setText("");
//                Toast.makeText(EditDataActivity.this, "Removed From Database", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(EditDataActivity.this,ListDataActivity.class);
//                startActivity(intent);
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.editlayout_titlebar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.editchecked)
        {
            String items = editable_item.getText().toString();
            if (!items.equals(""))
            {
                mDatabaseHelper.updateNote(items,selectedID,selectedtext);
                //finish();
                Intent intent = new Intent(EditDataActivity.this,ListDataActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(EditDataActivity.this,"Enter the text",Toast.LENGTH_LONG).show();
            }
        }

        if (id == R.id.deletebton)
        {
            mDatabaseHelper.deleteText(selectedID,selectedtext);
            editable_item.setText("");
            Toast.makeText(EditDataActivity.this, "Removed From Database", Toast.LENGTH_SHORT).show();
            //finish();
            Intent intent = new Intent(EditDataActivity.this,ListDataActivity.class);
            startActivity(intent);
        }

        if (id == R.id.undobton)
        {

        }

        if (id == R.id.redobton)
        {

        }

//        if (id == R.id.viewnote1)
//        {
//            Intent intent = new Intent(ListDataActivity.this,ListDataActivity.class);
//            startActivity(intent);
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        //return;
    }

}
