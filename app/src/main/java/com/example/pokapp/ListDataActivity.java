package com.example.pokapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class ListDataActivity extends AppCompatActivity
{
    private static final String TAG = "ListDataActivity";
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    //public static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private ListView mlistView;
    DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        //setContentView(R.layout.activity_main);
        mlistView = (ListView)findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        populatedListView();
    }

    private void populatedListView()
    {
        Log.d(TAG,"populatedListView: Displaying Data in the listView");
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext())
        {
            listData.add(data.getString(1));
        }
//        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
//        mlistView.setAdapter(adapter);

        ListAdapter adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        mlistView.setAdapter(adapter1);
        //mlistView.setAdapter(null);

        //setting onClickListener for listView
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String textname = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG,"onItemClick: You Clicked on "+textname);

                Cursor data = mDatabaseHelper.getItemID(textname);
                int itemID = -1;
                while(data.moveToNext())
                {
                    itemID = data.getInt(0);
                }

                if (itemID > - 1)
                {
                    Log.d(TAG,"onItemClick: The ID is: "+itemID);
                    Intent editScreenIntent = new Intent(ListDataActivity.this,EditDataActivity.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("text",textname);
                    startActivity(editScreenIntent);
                }
                else
                {
                    Toast.makeText(ListDataActivity.this,"No ID assossiated with the searched text",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.titlelistpagebar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

//        if (id == R.id.addrem1)
//        {
//            //openDialogueBox();
//            Intent intent = new Intent(ListDataActivity.this,ReminderEntryClass.class);
//            startActivity(intent);
//        }


        if (id == R.id.addnotes)
        {
            //openDialogueBox();
            Intent intent = new Intent(ListDataActivity.this,ReminderEntryClass.class);
            startActivity(intent);
        }

        if (id == R.id.checklist)
        {
            //openDialogueBox();
            Intent intent = new Intent(ListDataActivity.this,CheckListActivity.class);
            startActivity(intent);

        }

        if (id == R.id.voicerecognizer)
        {
            //openDialogueBox();
//            Intent intent = new Intent(ListDataActivity.this,ReminderEntryClass.class);
//            startActivity(intent);
            speak();
        }

//        if (id == R.id.viewnote1)
//        {
//            Intent intent = new Intent(ListDataActivity.this,ListDataActivity.class);
//            startActivity(intent);
//        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onBackPressed() {
//        new AlertDialog.Builder(this)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .setTitle("Exit")
//                .setMessage("Are you sure?")
//                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        Intent intent = new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);
//                        finish();
//                    }
//                }).setNegativeButton("no", null).show();
//    }

    @Override
    public void onBackPressed() {
        finish();
    }

    //try to implement voice to text note generator and also voice recorder
    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Add Your Voice Note!!!");

        try {
            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e)
        {
            Toast.makeText(this,""+e.getMessage(),Toast.LENGTH_SHORT).show();;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case REQUEST_CODE_SPEECH_INPUT:
                if (resultCode == RESULT_OK && null!=data)
                {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //searchbtn.setText(result.get(0));
                    Intent intent = new Intent(ListDataActivity.this,VoiceNoteActivity.class);
                    intent.putExtra("voicedata",result.get(0));
                    //intent.putExtra("data",data);
                    startActivity(intent);
                }
                break;
        }
    }
}
