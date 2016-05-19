package com.example.administrator.myapplication.activity.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jz on 2016/4/6.
 */
public class UserDb extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "user";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    public UserDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE `user` (\n" +
                "\t`username`\tTEXT NOT NULL,\n" +
                "\t`password`\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(username)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static long insert(Context context, String userName, String password){
        UserDb UserDb = newUserDb(context);
        SQLiteDatabase sqLiteDatabase = UserDb.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, userName);
        contentValues.put(COLUMN_PASSWORD, password);
        return sqLiteDatabase.insert(TABLE_NAME,
                "insert into user(username, password) values(?,?)",
                contentValues);
    }

    public static Boolean isUserExist(Context context, String userName) {
        Boolean b = false;
        Cursor cursor = query(context, userName);
        b = cursor.moveToFirst();
        cursor.close();
        return b;
    }

    public static long update(Context context,String userName, String password) {
        UserDb UserDb = newUserDb(context);
        SQLiteDatabase sqLiteDatabase = UserDb.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PASSWORD, password);
        return sqLiteDatabase.update(TABLE_NAME, contentValues, "username=?", new String[]{userName});
    }

    public static UserDb newUserDb(Context context){
        return new UserDb(context, "user", null, 1);
    }

    public static boolean login(Context context, String userName, String password) {
        UserDb UserDb = newUserDb(context);

        SQLiteDatabase sqLiteDatabase = UserDb.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{"*"},
                    "username=? and password=?",
                    new String[]{userName, password},
                    null, null, null);
            return cursor != null && cursor.moveToNext();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }

        return false;
    }

    public static Cursor query(Context context, String userName) {
        UserDb userDb = newUserDb(context);
        SQLiteDatabase sqLiteDatabase = userDb.getReadableDatabase();

        return  sqLiteDatabase.query(TABLE_NAME, new String[]{"*"},
                "username=?", new String[]{userName}, null, null, null);
    }
    
}
