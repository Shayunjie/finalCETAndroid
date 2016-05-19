package com.example.administrator.myapplication.activity.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 沙云杰 on 2016/4/19.
 */
public class DBManager {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBManager(Context context){
        dbHelper=new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
//---------------------------insesrt-----------------------------------------------
    public void insert(String tablename,String mTitle,String mContext){

        ContentValues cValuer = new ContentValues();
        cValuer.put("title",mTitle);
        cValuer.put("context",mContext);
        db.insert(tablename,null,cValuer);
    }
    public  void insert(String tablename,String mTitle,String mContext,String options,String answer){

        ContentValues cValuer = new ContentValues();
        cValuer.put("title",mTitle);
        cValuer.put("context",mContext);
        cValuer.put("options",options);
        cValuer.put("answer",answer);
        db.insert(tablename,null,cValuer);
    }
    public void insert(String tablename,String mTitle, int score){

        ContentValues cValuer = new ContentValues();
        cValuer.put("title",mTitle);
        cValuer.put("tablename",tablename);
        cValuer.put("score",score);
        db.insert("score",null,cValuer);
    }

    public Cursor queryTheCursor(String tablename) {
        Cursor c = db.rawQuery("SELECT * FROM "+tablename , null);
        return c;
    }
    public Cursor queryScoreCursor(String tablename) {
        Cursor c = db.rawQuery("SELECT * FROM score WHERE tablename = '"+tablename+"'", null);
        return c;
    }
  public void update(String tablename,String input,int id){
      String update = "update "+tablename+" set input = \""+ input +"\" where _id = "+id+";";
      db.execSQL(update);
  }
    public void delete(String tablename,String mtitle){
        String delete = "delete from "+tablename+"where title ="+mtitle;
    }
    public void closeDB(){
        db.close();

    }
}
