package com.example.pokapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokapp.AddReminder;

public class Main2Activity extends AppCompatActivity {

    TextView viewtext;
    DatabaseHelper mdatabaseHelper;
    //    Button done,viewdatabase;
    Button viewdatabase;
    ImageView done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
//        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_main2);
        viewtext = (TextView)findViewById(R.id.viewtext);
        done = (ImageView) findViewById(R.id.done);
        //viewdatabase = (Button)findViewById(R.id.viewdatabase);
        mdatabaseHelper = new DatabaseHelper(this);


        String txt = getIntent().getStringExtra("reminder");
        viewtext.setText(txt);

        String entry = viewtext.getText().toString();
        if (viewtext.length() !=0)
        {
            AddData(entry);
            viewtext.setText("");
        }
        else
        {
            Toast.makeText(Main2Activity.this,"Add Something",Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(Main2Activity.this,ListDataActivity.class);
        startActivity(intent);


//        done.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String entry = viewtext.getText().toString();
//                if (viewtext.length() !=0)
//                {
//                    AddData(entry);
//                    viewtext.setText("");
//                }
//                else
//                {
//                    Toast.makeText(MainActivity.this,"Add Something",Toast.LENGTH_LONG).show();
//                }
//            }
//        });




//        viewdatabase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
//                startActivity(intent);
//            }
//        });



    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.title_bar,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int id = item.getItemId();
//
//        if (id == R.id.addrem)
//        {
//            openDialogueBox();
//        }
//
//        if (id == R.id.viewnote)
//        {
//            Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
//            startActivity(intent);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    private void openDialogueBox()
    {
        AddReminder addReminder = new AddReminder();
        addReminder.show(getSupportFragmentManager(),"personal info dialogue");
    }

    public void AddData(String entry)
    {
        boolean insertData = mdatabaseHelper.addData(entry);

        if (insertData)
        {
            Toast.makeText(Main2Activity.this,"Data Added Successfully",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(Main2Activity.this,"Retry",Toast.LENGTH_LONG).show();
        }
    }
}