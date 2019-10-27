package com.example.pokapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class VoiceNoteActivity extends AppCompatActivity {

    private static final String TAG = "VoiceNoteActivity";

    DatabaseHelper mDatabaseHelper;

    //private String selectedtext;
    //private int selectedID;

    EditText editable_item2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_note);


        mDatabaseHelper = new DatabaseHelper(this);

//        Intent recievedIntent = getIntent();

//        selectedID = recievedIntent.getIntExtra("id",-1);
        editable_item2 = (EditText)findViewById(R.id.editable_item2);

        String txt2 = getIntent().getStringExtra("voicedata");
        editable_item2.setText(txt2);
        Log.d(TAG,"Data recieved "+txt2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.reminderpage_titlebar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.checkd)
        {
            String reminder = editable_item2.getText().toString();
            Intent intent = new Intent(VoiceNoteActivity.this,Main2Activity.class);
            intent.putExtra("reminder",reminder);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
