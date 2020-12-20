package com.example.ip2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "quizApp.db";
    public static final String TABLE_NAME = "allQuestions.db";
    public static final String COL1 = "ID";
    public static final String COL2 = "CATEGORY";
    public static final String COL3 = "DIFFICULTY";
    public static final String COL4 = "QUESTIONTEXT";
    public static final String COL5 = "ANSWERTEXT1";
    public static final String COL6 = "BOOLEAN1";
    public static final String COL7 = "ANSWERTEXT2";
    public static final String COL8 = "BOOLEAN2";
    public static final String COL9 = "ANSWERTEXT3";
    public static final String COL10 = "BOOLEAN3";
    public static final String COL11 = "ANSWERTEXT4";
    public static final String COL12 = "BOOLEAN4";

    public Databasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "CATEGORY TEXT, " +
                "DIFFICULTY INTEGER, " +
                "QUESTIONTEXT TEXT, " +
                "ANSWERTEXT1 TEXT, " +
                "BOOLEAN1 BIT, " +
                "ANSWERTEXT2 TEXT, " +
                "BOOLEAN2 BIT, " +
                "ANSWERTEXT3 TEXT, " +
                "BOOLEAN3 BIT, " +
                "ANSWERTEXT4 TEXT, " +
                "BOOLEAN4 BIT)";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean addData(String _category, String _difficulty, String _questiontext,
                           String _answertext1, Integer _boolean1, String _answertext2, Integer _boolean2,
                           String _answertext3, Integer _boolean3, String _answertext4, Integer _boolean4)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, _category);
        contentValues.put(COL3, _difficulty);
        contentValues.put(COL4, _questiontext);
        contentValues.put(COL5, _answertext1);
        contentValues.put(COL6, _boolean1);
        contentValues.put(COL7, _answertext2);
        contentValues.put(COL8, _boolean2);
        contentValues.put(COL9, _answertext3);
        contentValues.put(COL10, _boolean3);
        contentValues.put(COL11, _answertext4);
        contentValues.put(COL12, _boolean4);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data =  db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

}
