package com.example.myfragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE user_data (" +
                "nama TEXT, " +
                "email TEXT, " +
                "password TEXT);";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user_data");
        onCreate(sqLiteDatabase);
    }


    public long insertData(String nama, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama", nama);
        contentValues.put("email", email);
        contentValues.put("password", password);
        return db.insert("user_data", null, contentValues);
    }

    public List<Account> getAllData() {
        List<Account> accountList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_data", null);

        while (cursor.moveToNext()) {
            String nama = cursor.getString(0);
            String email = cursor.getString(1);
            String password = cursor.getString(2);
            accountList.add(new Account(nama, email, password));
        }

        cursor.close();
        return accountList;
    }

}
