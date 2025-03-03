package com.example.sqlite_database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context : Context?,
               db : String?,
               factory: CursorFactory?,
               version : Int) : SQLiteOpenHelper(context,db,factory,version) {

    override fun onCreate(db : SQLiteDatabase?) {
        Log.e("tag", "onCreate method called")

        /* if (db != null) {
            db.execSQL("create table Product(id integer primary key, title text NOT NULL, price integer);")
        } */

        // we can replace if with ? so above and below both are same
        db?.execSQL("create table Product(id integer primary key, title text NOT NULL, price integer);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        Log.e("tag", "onUpgrade method called")
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
        Log.e("tag", "onDownGrade method called")
    }
}