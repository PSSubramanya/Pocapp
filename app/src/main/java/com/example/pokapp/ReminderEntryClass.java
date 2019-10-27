package com.example.pokapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ReminderEntryClass extends AppCompatActivity {

    EditText remindernote;

    DatabaseHelper mdatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_entry_class);

        remindernote = (EditText)findViewById(R.id.remindernote);
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
            //openDialogueBox();
//            String entry = remindernote.getText().toString();
//            if (remindernote.length() !=0)
//            {
//                AddData(entry);
//                //remindernote.setText("");
//            }
//            else
//            {
//                Toast.makeText(ReminderEntryClass.this,"Add Something",Toast.LENGTH_LONG).show();
//            }

            String reminder = remindernote.getText().toString();
//            Intent intent = new Intent(ReminderEntryClass.this,MainActivity.class);
            Intent intent = new Intent(ReminderEntryClass.this,Main2Activity.class);
            intent.putExtra("reminder",reminder);
            startActivity(intent);
        }

//        if (id == R.id.viewnote1)
//        {
//            Intent intent = new Intent(ReminderEntryClass.this,ListDataActivity.class);
//            startActivity(intent);
//        }

        return super.onOptionsItemSelected(item);
    }

//    public void AddData(String entry)
//    {
//        boolean insertData = mdatabaseHelper.addData(entry);
//
//        if (insertData)
//        {
//            Toast.makeText(ReminderEntryClass.this,"Data Added Successfully",Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//            Toast.makeText(ReminderEntryClass.this,"Retry",Toast.LENGTH_LONG).show();
//        }
//    }
}
