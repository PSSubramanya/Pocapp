package com.example.pokapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper
{

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "Reminder_table";
    private static final String COL1 ="ID";
    private static final String COL2 = "Notes";

    public DatabaseHelper(Context context)
    {
        super(context,TABLE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL2 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        //db.execSQL("DROP IF TABLE EXISTS " +TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,item);

        Log.d(TAG,"addData: Adding "+item+" to "+TABLE_NAME);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getItemID(String textname)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT "+COL1+" FROM "+TABLE_NAME+
                " WHERE "+COL2+ " = '"+textname+ "'";

        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public void updateNote(String newNote,int id, String oldNote)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE "+TABLE_NAME+ " SET "+COL2+
                " = '"+newNote+ "' WHERE " +COL1+ " = '"+ id+ "'"+
                "AND "+ COL2+ " = '"+ oldNote+"'";

        Log.d(TAG, "updateText: query: "+query);
        Log.d(TAG, "updateText: Setting Note to : "+newNote);
        db.execSQL(query);
    }

    public void deleteText(int id, String text)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+TABLE_NAME+ " WHERE "+COL1+ " = '"+id+"'"+" AND "+COL2+" = '"+text+"'";

        Log.d(TAG, "deleteText: query: "+query);
        Log.d(TAG, "deleteText: Deleting "+text+" from database.");
        db.execSQL(query);
    }


    public void selectspecificdata(int id, String textpiece)
    {

    }
}
