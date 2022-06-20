package com.example.labourmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class database_handler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "labour_management";
    public static final String TABLE_NAME_LOGIN = "login_table";
    public static final String TABLE_NAME_LANDLORD = "landlord_table";

    public database_handler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_login_table = "CREATE TABLE if not exists login_table (username Text primary key,password Text, role Text)";
        sqLiteDatabase.execSQL(create_login_table);
        String create_landlord_table = "CREATE TABLE if not exists landlord_table (username Text primary key,name Text, age int, adhar Text,mobile Text, address Text)";
        sqLiteDatabase.execSQL(create_landlord_table);
        String create_labour_table = "CREATE TABLE if not exists labour_table (username Text primary key,name Text, age int, adhar Text,mobile Text, address Text,no_of_team int, work Text, wage int, working_days int)";
        sqLiteDatabase.execSQL(create_labour_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        sqLiteDatabase.execSQL(drop, new String[]{"login_table"});
        onCreate(sqLiteDatabase);
    }

    public Cursor get_credential(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("login_table",new String[]{"username","password","role"},"username=?",new String[]{String.valueOf(username)},null,null,null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytag",cursor.getString(0));
            Log.d("mytag",cursor.getString(1));
        }
        else{
            Log.d("mytag","Some error");
        }
        return cursor;
    }

    public void add_admin(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("role","a");
        long k = db.insert(TABLE_NAME_LOGIN,null,values);
        db.close();
    }

    public void add_landlord(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        ContentValues values_landlord = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("role","ll");
        long k = db.insert(TABLE_NAME_LOGIN,null,values);
        values_landlord.put("username",username);
        values_landlord.put("name","Null");
        values_landlord.put("age",0);
        values_landlord.put("adhar","Null");
        values_landlord.put("mobile","Null");
        values_landlord.put("address","Null");
        long l = db.insert(TABLE_NAME_LANDLORD,null,values_landlord);
        db.close();
    }

    public void add_labour(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("role","l");
        long k = db.insert(TABLE_NAME_LOGIN,null,values);
        db.close();
    }

    public void delete_member(String username){

    }

}
