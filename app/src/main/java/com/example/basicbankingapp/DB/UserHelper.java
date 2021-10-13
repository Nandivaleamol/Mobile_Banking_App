package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(5000,'Amol', 'amol@gmail.com','4857','8483945783', 5440)");
        db.execSQL("insert into " + TABLE_NAME + " values(4893,'Shubham', 'shubham@gmail.com','3453','8574934833', 7600)");
        db.execSQL("insert into " + TABLE_NAME + " values(8576,'Vikas', 'vikas@gmail.com','5746','9854323452', 13000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1358,'Rohan', 'rohan@gmail.com','4758','8855443293', 9500)");
        db.execSQL("insert into " + TABLE_NAME + " values(5943,'Suresh', 'suresh@gmail.com','8578','9069347323', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2334,'Ganesh', 'ganesh@gmail.com','8574','657349283', 9080)");
        db.execSQL("insert into " + TABLE_NAME + " values(8874,'Vishal', 'vishal@gmail.com','5607','9846332153', 4800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9845,'Ankit', 'ankit@gmail.com','5847','985848347', 9300)");
        db.execSQL("insert into " + TABLE_NAME + " values(5374,'Suraj', 'suraj@gmail.com','7586','9857347833', 8900)");
        db.execSQL("insert into " + TABLE_NAME + " values(4973,'Aniket', 'aniket@gmail.com','5450','986746345', 8900)");
        db.execSQL("insert into " + TABLE_NAME + " values(5834,'Kiran ', 'kiran@gmail.com','9655','9057886433', 8500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8975,'Ashok', 'ashok@gmail.com','8703','9893738499', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3498,'Prasad', 'prasad@gmail.com','6566','894579284', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(5849,'Aakash', 'aakash@gmail.com','5683','9847346235', 9500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9588,'Anand', 'anand@gmail.com','9587','9857463422', 9480)");
        db.execSQL("insert into " + TABLE_NAME + " values(5849,'Subhash', 'subhash@gmail.com','5623','9997346235', 8500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9588,'Mahesh', 'mahesh@gmail.com','9547','9857456422', 9660)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}