package com.example.cropconnect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CropDB";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE crops (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "price TEXT," +
                "phone TEXT)";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS crops");
        onCreate(db);
    }

    public void addCrop(String name, String price, String phone) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("price", price);
        values.put("phone", phone);

        db.insert("crops", null, values);
        db.close();
    }

    public ArrayList<Crop> getAllCrops() {

        ArrayList<Crop> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM crops", null);

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String price = cursor.getString(2);
                String phone = cursor.getString(3);

                list.add(new Crop(id, name, price, phone));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }

    public void deleteCrop(int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("crops", "id=?", new String[]{String.valueOf(id)});

        db.close();
    }
}
