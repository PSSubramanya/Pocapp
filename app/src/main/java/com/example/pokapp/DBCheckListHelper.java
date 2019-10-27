package com.example.pokapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBCheckListHelper extends SQLiteOpenHelper
{

    private static final String DB_NAME = "CheckListDB";
    private static final int DB_VER = 1;
    public static final String DB_TABLE = "Task";
    public static final String DB_COLUM = "Task Name";

    public DBCheckListHelper(Context context)
    {
        super(context,DB_NAME,null,DB_VER);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
