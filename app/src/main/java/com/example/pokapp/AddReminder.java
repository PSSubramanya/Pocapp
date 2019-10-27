package com.example.pokapp;

import androidx.appcompat.app.AppCompatDialogFragment;

//
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatDialogFragment;
//
//
public class AddReminder extends AppCompatDialogFragment
{
//    private static final String TAG = "AddReminder";
//
//    //DatabaseHelper databaseHelper;
//    private EditText remindertext;
//    private Button Save;
//
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.add_reminder);
////
////    }
//
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        // super.onCreateDialog(savedInstanceState);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view = inflater.inflate(R.layout.activity_add_reminder,null);
//        remindertext = view.findViewById(R.id.remindertext);
//
//
//        builder.setView(view)
//                .setTitle("Notepad")
//                .setMessage("Add Reminder!!!")
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                })
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
////                        String reminder = remindertext.getText().toString();
//
////                        Intent intent = new Intent(((Dialog)dialogInterface).getContext(),MainActivity.class);
////                        intent.putExtra("reminder",reminder);
////                        startActivity(intent);
//                    }
//                });
//
//
//        return builder.create();
//    }
//
}
