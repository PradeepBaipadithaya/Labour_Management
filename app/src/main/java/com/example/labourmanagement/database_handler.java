package com.example.labourmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class database_handler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "labour_management";
    public static final String TABLE_NAME_LOGIN = "login_table";
    public static final String TABLE_NAME_LANDLORD = "landlord_table";
    public static final String TABLE_NAME_LABOUR = "labour_table";
    public static final String TABLE_NAME_ATTENDANCE = "attendance_table";
    public static final String TABLE_NAME_NOTIFY = "notify_table";
    public static final String TABLE_NAME_NOTIFY_ALL = "notify_all_table";

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
        String create_attendance_table = "CREATE TABLE if not exists attendance_table " +
                "(landlord_id Text, labour_id Text,present Text, date Text, payment int, incentive int, advance int, " +
                "Primary key(landlord_id,labour_id,date), " +
                "foreign key (landlord_id) references landlord_table(username) on delete cascade," +
                "foreign key (labour_id)references labour_table(username) on delete cascade)";
        sqLiteDatabase.execSQL(create_attendance_table);

        String create_notify_table = "CREATE TABLE if not exists notify_table " +
                "(landlord_id Text, labour_id Text, date Text, reason Text, " +
                "Primary key(landlord_id,labour_id,date), " +
                "foreign key (landlord_id) references landlord_table(username) on delete cascade," +
                "foreign key (labour_id)references labour_table(username) on delete cascade)";
        sqLiteDatabase.execSQL(create_notify_table);

        String create_notify_all_table = "CREATE TABLE if not exists notify_all_table " +
                "(landlord_id Text, date Text, reason Text," +
                "Primary key(landlord_id,date))";
        sqLiteDatabase.execSQL(create_notify_all_table);

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

    public Cursor get_pinfo(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("landlord_table",new String[]{"username","name","age","adhar","mobile","address"},"username=?",new String[]{String.valueOf(username)},null,null,null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytag",cursor.getString(0));
            Log.d("mytag",cursor.getString(1));
        }
        else{
            Log.d("mytag","Some error");
        }
        return cursor;
    }

    public Cursor get_labour_pinfo(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(""+TABLE_NAME_LABOUR,new String[]{"username","name","age","adhar","mobile","address","no_of_team","work","wage","working_days"},"username=?",new String[]{String.valueOf(username)},null,null,null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytag",cursor.getString(0));
        }
        else{
            Log.d("mytag","Some error");
        }
        return cursor;
    }

    public Cursor get_salary(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT wage from labour_table WHERE username=?",new String[]{username});
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytag",cursor.getString(0));
        }
        else{
            Log.d("mytag","Some error");
        }
        return cursor;
    }

    public ArrayList get_job_alert(String labour_id){
        ArrayList job_alert = new ArrayList();
        ArrayList job_alerts = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT landlord_id,date,reason FROM notify_table WHERE labour_id=?",new String[]{labour_id});
        if(cursor.getCount()>0){
            int i=0;
//            Log.d("mytag",""+cursor.getCount());
//            cursor.moveToFirst();
            while (cursor.moveToNext()){
                Log.d("mytag",""+cursor.getString(2));
                job_alert.add(cursor.getString(0));
                job_alert.add(cursor.getString(1));
                job_alert.add(cursor.getString(2));
//                job_alert.add(cursor.getString(3));

                job_alerts.add(i,job_alert);
                i++;

            }
        }
        else{
            Log.d("mytag","Some error");
        }
        db.close();
        return job_alerts;
    }
    public ArrayList get_job_available(){
        ArrayList job_available = new ArrayList();
        ArrayList jobs_available = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT landlord_id,date,reason FROM notify_all_table",null);
        if(cursor.getCount()>0){
            int i=0;
//            Log.d("mytag",""+cursor.getCount());
//            cursor.moveToFirst();
            while (cursor.moveToNext()){
                Log.d("mytag",""+cursor.getString(2));
                job_available.add(cursor.getString(0));
                job_available.add(cursor.getString(1));
                job_available.add(cursor.getString(2));
//                job_alert.add(cursor.getString(3));

                jobs_available.add(i,job_available);
                i++;

            }
        }
        else{
            Log.d("mytag","Some error");
        }
        db.close();
        return jobs_available;
    }

    public ArrayList get_users(){
        ArrayList user = new ArrayList();
        ArrayList users = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username,role FROM login_table",null);
        if(cursor.getCount()>0){
            int i=0;
//            Log.d("mytag",""+cursor.getCount());
//            cursor.moveToFirst();
            while (cursor.moveToNext()){
//                Log.d("mytag",""+cursor.getString(2));
                user.add(cursor.getString(0));
                user.add(cursor.getString(1));
//                user.add(cursor.getString(2));
//                job_alert.add(cursor.getString(3));

                users.add(i,user);
                i++;

            }
        }
        else{
            Log.d("mytag","Some error");
        }
        db.close();
        return users;
    }

    public ArrayList get_labour(){
        ArrayList labour_info = new ArrayList();
        ArrayList labour_infos = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username,work,wage,mobile FROM labour_table",null);
        if(cursor.getCount()>0){
            int i=0;

            while (cursor.moveToNext()){
                Log.d("mytag",""+cursor.getString(2));
                labour_info.add(cursor.getString(0));
                labour_info.add(cursor.getString(1));
                labour_info.add(cursor.getString(2));
                labour_info.add(cursor.getString(3));
//                job_alert.add(cursor.getString(3));
                labour_infos.add(i,labour_info);
                i++;
            }
        }
        else{
            Log.d("mytag","Some error");
        }
        db.close();
        return labour_infos;
    }

    public void add_admin(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("role","Admin");
        long k = db.insert(TABLE_NAME_LOGIN,null,values);
        db.close();
    }

    public long add_landlord(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        ContentValues values_landlord = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("role","Landlord");
        long k = db.insert(TABLE_NAME_LOGIN,null,values);
        values_landlord.put("username",username);
        values_landlord.put("name","Null");
        values_landlord.put("age",0);
        values_landlord.put("adhar","Null");
        values_landlord.put("mobile","Null");
        values_landlord.put("address","Null");
        long l = db.insert(TABLE_NAME_LANDLORD,null,values_landlord);
        Log.d("mytag", String.valueOf(l));
        db.close();
        return l;
    }

    public long add_labour(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        ContentValues values_labour = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("role","Labour");
        long k = db.insert(TABLE_NAME_LOGIN,null,values);
        values_labour.put("username",username);
        values_labour.put("name","Null");
        values_labour.put("age",0);
        values_labour.put("adhar","Null");
        values_labour.put("mobile","Null");
        values_labour.put("address","Null");
        values_labour.put("no_of_team",0);
        values_labour.put("work","Null");
        values_labour.put("wage",0);
        values_labour.put("working_days",0);
        long l = db.insert(TABLE_NAME_LABOUR,null,values_labour);
        Log.d("mytag", String.valueOf(l));
        db.close();
        return l;
    }

    public long delete_member(String username_entry){
        SQLiteDatabase db = this.getWritableDatabase();
        String username = "username";
        long k =db.delete(""+TABLE_NAME_LOGIN,username+"=?",new String[]{username_entry});
        long l =db.delete(""+TABLE_NAME_LANDLORD,username+"=?",new String[]{username_entry});
        long m =db.delete(""+TABLE_NAME_LABOUR,username+"=?",new String[]{username_entry});
        db.close();
        Log.d("mytag", String.valueOf(k));
        return k;
    }

    public boolean landlord_update(String username_entered, String fullname, int age, String adhar, String mobile, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values_landlord = new ContentValues();
        values_landlord.put("username",username_entered);
        values_landlord.put("name",fullname);
        values_landlord.put("age",age);
        values_landlord.put("adhar",adhar);
        values_landlord.put("mobile",mobile);
        values_landlord.put("address",address);
        long k = db.update(""+TABLE_NAME_LANDLORD,values_landlord,"username=?",new String[]{username_entered});
        db.close();
        return true;

    }

    public boolean labour_update(String username_entered, String fullname, int age, String adhar, String mobile, String address,int no_of_team_member, String work, int wage, int working_days){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values_labour = new ContentValues();
        values_labour.put("username",username_entered);
        values_labour.put("name",fullname);
        values_labour.put("age",age);
        values_labour.put("adhar",adhar);
        values_labour.put("mobile",mobile);
        values_labour.put("address",address);
        values_labour.put("no_of_team",no_of_team_member);
        values_labour.put("work",work);
        values_labour.put("wage",wage);
        values_labour.put("working_days",working_days);
        long k = db.update(""+TABLE_NAME_LABOUR,values_labour,"username=?",new String[]{username_entered});
        db.close();
        return true;

    }

    public long take_attendance(String landlord_id, String labour_id,String present, String date, int payment, int incentive, int advance){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("landlord_id",landlord_id);
        values.put("labour_id",labour_id);
        values.put("date",date);
        values.put("present",present);
        values.put("payment",payment);
        values.put("incentive",incentive);
        values.put("advance",advance);
        long k = db.insert(""+TABLE_NAME_ATTENDANCE,null,values);
        Log.d("mytag", String.valueOf(k));
        db.close();
        return k;
    }

    public Cursor get_attendance(String landlord_id, String labour_id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT labour_id, count(date),sum(payment),sum(incentive),sum(advance) FROM attendance_table WHERE landlord_id=? and labour_id=?",new String[]{landlord_id,labour_id});
        if(cursor != null && cursor.moveToFirst()){
//            Log.d("mytag",cursor.getString(0));
//            Log.d("mytag",cursor.getString(1));
//            Log.d("mytag",cursor.getString(2));
//            Log.d("mytag",cursor.getString(3));
//            Log.d("mytag",cursor.getString(4));
        }
        else{
            Log.d("mytag","Some error");
        }
        db.close();
        return cursor;
    }

    public long add_notification(String landlord_id, String labour_id,String date, String reason){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("landlord_id",landlord_id);
        values.put("labour_id",labour_id);
        values.put("date",date);
        values.put("reason",reason);
        long k = db.insert(""+TABLE_NAME_NOTIFY,null,values);
        Log.d("mytag", String.valueOf(k));
        db.close();
        return k;
    }

    public long add_notification_to_all(String landlord_id, String date, String reason){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("landlord_id",landlord_id);
        values.put("date",date);
        values.put("reason",reason);
        long k = db.insert(""+TABLE_NAME_NOTIFY_ALL,null,values);
        Log.d("mytag", String.valueOf(k));
        db.close();
        return k;
    }



}
