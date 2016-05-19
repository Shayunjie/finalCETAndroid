package com.example.administrator.myapplication.activity.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 沙云杰 on 2016/4/19.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test.db"; //数据库名称
    private static final int version = 1; //数据库版本
    public DBHelper(Context context) {
        super(context, DB_NAME,null,version);
    }

    public void onCreate(SQLiteDatabase db){
        String sql3 = "create table if not exists listenning(_id integer primary key autoincrement,title text,context text,answer text)";
        String sql5 = "create table if not exists writting(_id integer primary key autoincrement,title text,context text,input text)";
        String sql = "create table if not exists selectword(_id integer primary key autoincrement,title text,context text,options text,answer text)";
        String sql1 = "create table if not exists long(_id integer primary key autoincrement,title text,context text,options text,answer text)";
        String sql2 = "create table if not exists short(_id integer primary key autoincrement,title text,context text,option text,answer text)";
        String sql6 = "create table if not exists translation(_id integer primary key autoincrement,title text,context text,sample text,input text)";
        String sql4 = "create table if not exists score(_id integer primary key autoincrement,tablename text,title text,score SMALLINT)";


        db.execSQL(sql);
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
    }
}
