package com.example.sqlitecrudoperations;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_user";
    private static final String table = "user";

    public DatabaseHandler(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS " + table +
                "(username varchar," +
                "password varchar);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void addUser(User user) throws NoSuchAlgorithmException {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] hashInBytes = md.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));

        // bytes to hex
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }

        values.put("username", user.getUsername());
        values.put("password", sb.toString());

        Log.d("DEBUG", user.getUsername() + " " + sb.toString());

        db.insert(table, null, values);
        db.close();

    }

    public User getUser(String username){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(table, new String[]{"username", "password"},
                "username" + "=?", new String[] {username},
                null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        User user = new User(cursor.getString(0), cursor.getString(1));
        Log.d("DEBUG", user.getUsername() + " " + user.getPassword());

        return user;
    }
}
