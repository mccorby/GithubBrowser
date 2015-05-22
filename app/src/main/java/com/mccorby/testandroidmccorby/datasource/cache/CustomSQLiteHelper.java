package com.mccorby.testandroidmccorby.datasource.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JAC on 21/05/2015.
 */
public class CustomSQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;


    public CustomSQLiteHelper(Context context) {
        super(context, RepositoryContract.Repository.TABLENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        RepositoryProvider.createTable(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        RepositoryProvider.upgradeTable(db);
    }
}
