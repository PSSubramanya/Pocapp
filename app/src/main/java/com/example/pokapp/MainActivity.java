package com.example.pokapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button notepadapp,timer,calculator,qrcodescanner;

    DatabaseHelper mdatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notepadapp = (Button)findViewById(R.id.notepadapp);
        timer = (Button)findViewById(R.id.timer);
        calculator = (Button)findViewById(R.id.calculator);
        qrcodescanner = (Button)findViewById(R.id.qrcodescanner);

        notepadapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
                startActivity(intent);
            }
        });

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StopWatchTimer.class);
                startActivity(intent);
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Calculator_Page.class);
                startActivity(intent);
            }
        });

        qrcodescanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Main2Activity.this,QRCodeScannerActivity.class);
                Intent intent = new Intent(MainActivity.this,QRCodeScannerActivity2.class);
//                Intent intent = new Intent(Main2Activity.this,PictureBarcodeActivity.class);
                startActivity(intent);
            }
        });


//        mdatabaseHelper = new DatabaseHelper(this);
//
//
//        String txt = getIntent().getStringExtra("reminder");
//        viewtext.setText(txt);
//
//        String entry = viewtext.getText().toString();
//        if (viewtext.length() !=0)
//        {
//            AddData(entry);
//            viewtext.setText("");
//        }
//        else
//        {
//            Toast.makeText(MainActivity.this,"Add Something",Toast.LENGTH_LONG).show();
//        }
//
//        Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
//        startActivity(intent);
//
//
////        done.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                String entry = viewtext.getText().toString();
////                if (viewtext.length() !=0)
////                {
////                    AddData(entry);
////                    viewtext.setText("");
////                }
////                else
////                {
////                    Toast.makeText(MainActivity.this,"Add Something",Toast.LENGTH_LONG).show();
////                }
////            }
////        });
//
//
//
//
////        viewdatabase.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
////                startActivity(intent);
////            }
////        });
//
//
//
//    }
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
//
//    private void openDialogueBox()
//    {
//        AddReminder addReminder = new AddReminder();
//        addReminder.show(getSupportFragmentManager(),"personal info dialogue");
//    }
//
//    public void AddData(String entry)
//    {
//        boolean insertData = mdatabaseHelper.addData(entry);
//
//        if (insertData)
//        {
//            Toast.makeText(MainActivity.this,"Data Added Successfully",Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//            Toast.makeText(MainActivity.this,"Retry",Toast.LENGTH_LONG).show();
//        }
//    }


}

}
