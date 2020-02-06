package com.example.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

 public  static  final String DB_NAME="names_db";
 public  static  final int VERSION=2;
 public  static final String TABLE_NAME="name";
 public  static final String CLN_NAME="name";
 public  static final String CLN_NUMBER="number";
 public  static final String CLN_KIND="kind";


    public MyDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE "+ TABLE_NAME+" ( "+CLN_NAME+" TEXT , "

                +CLN_NUMBER +" TEXT ," +CLN_KIND +" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insert (UserData userData){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(CLN_NAME,userData.getName());
        values.put(CLN_NUMBER,userData.getNumber());
        values.put(CLN_KIND,userData.getKind());
        long result=db.insert(TABLE_NAME,null,values);
        return result !=-1;
    }

    public ArrayList<UserData> getAllData(){
        ArrayList<UserData> data=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        while (cursor.moveToNext()){
            data.add(new UserData(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
        }
        return data;
    }

}
