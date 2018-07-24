package com.example.user.travelbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int Db_Version=1;
    private static final String Db_Name="NEW";
    private static final String Table_Name="USERS";
    private static final String User_name="username";
    private static final String User_password="password";
    //constructor here
    public DbHandler(Context context)
    {
        super(context,Db_Name,null,Db_Version);
    }
    //creating table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // writing command for sqlite to create table with required columns
        String Create_Table="CREATE TABLE IF NOT EXISTS " + Table_Name + "(" + User_name
                + " TEXT," + User_password + " TEXT" + ")";
        db.execSQL(Create_Table);
    }
    //Upgrading the Db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        //create the table again
        onCreate(db);
    }
    //Add new User by calling this method
    void addUser(User user)
    {
        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        // cv.put(User_id,usr.getId());
        values.put(User_name,user.getUsername());
        values.put(User_password,user.getPassword());
        //inserting row
        db.insert(Table_Name, null, values);
        //close the database to avoid any leak
        db.close();
    }

    //method to return list of rows from table in database
    public List<User> getAllUsers(){
        List<User> userList=new ArrayList<User>();
        String selectQuery="SELECT * FROM " + Table_Name;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setUsername(cursor.getString(0));
                user.setPassword(cursor.getString(1));
                userList.add(user);
            }
            while (cursor.moveToNext());
        }
        return userList;
        }

}

