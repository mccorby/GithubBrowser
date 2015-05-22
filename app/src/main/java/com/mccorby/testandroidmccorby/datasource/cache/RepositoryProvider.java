package com.mccorby.testandroidmccorby.datasource.cache;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

public class RepositoryProvider extends ContentProvider {
    public RepositoryProvider() {
    }
    /** The name of this {@link ContentProvider}. */
    public static final String AUTHORITY = "com.mccorby.testandroidmccorby.provider";
    /** Base path for {@link ContentProvider} URIs. */
    private static final String BASE_PATH = "repositories";

    // Build the tree of UriMatcher objects
    /** URI matcher tokens. */
    private static final int SETTINGS = 100;
    /**
     * A projection map used to select columns from the database.
     */
    private static Map<String, String> sSettingsProjectionMap;
    /** Token URI matching table. */
    static final UriMatcher S_URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        // Add a pattern that routes URIs terminated with "tokens"
        // (BASE_PATH) to a FAVORITES operation
        S_URI_MATCHER.addURI(AUTHORITY, BASE_PATH, SETTINGS);

        // Creates a new projection map instance. The map returns a column name
        // given a string. The two are usually equal.
        // Use this to build the queries
        sSettingsProjectionMap = new HashMap<String, String>();

        for (String columnName : RepositoryContract.Repository.ALL_COLUMNS_PROJECTION) {
            sSettingsProjectionMap.put(columnName, columnName);
        }
    }

    /** Handle of a reference to the database helper. */
    private CustomSQLiteHelper mOpenHelper;

    @Override
    public boolean onCreate() {
        // Creates (but not open) the database
        mOpenHelper = new CustomSQLiteHelper(getContext());
        // No problems assumed. Return true to continue
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        // Constructs a new query builder and sets its table name
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(RepositoryContract.Repository.TABLENAME);

        // Set the projection
        qb.setProjectionMap(sSettingsProjectionMap);

        // Opens the database object in "read" mode, since no writes need to be
        // done.
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();

        /*
         * Performs the query. If no problems occur trying to read the database,
         * then a Cursor object is returned; otherwise, the cursor variable
         * contains null. If no records were selected, then the Cursor object is
         * empty, and Cursor.getCount() returns 0.
         */
        Cursor c = qb.query(db, // The database to query
                projection, // The columns to return from the query
                selection, // The columns for the where clause
                selectionArgs, // The values for the where clause
                null, // don't group the rows
                null, // don't filter by row groups
                null // The sort order
        );

        // Tells the Cursor what URI to watch, so it knows when its source data
        // changes
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public String getType(Uri uri) {
        return RepositoryContract.Repository.CONTENT_TYPE;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // Opens the database object in "write" mode.
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        long rowId = db.insert(RepositoryContract.Repository.TABLENAME, null,
                values);
        if (rowId > 0) {
            // Creates a URI with the setting ID pattern and the new row ID
            // appended to it.
            Uri settingUri = ContentUris.withAppendedId(
                    RepositoryContract.REPOSITORIES_URI, rowId);

            // Notifies observers registered against this provider that the data
            // changed.
            // The insert won't trigger the SyncAdapter as it's done "manually"
            getContext().getContentResolver().notifyChange(settingUri, null,
                    false);
            return settingUri;
        }
        // If the insert didn't succeed, then the rowID is <= 0. Throws an
        // exception.
        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // No deletion in Settings
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {

        return 0;
    }

    /**
     * Creates the table for Settings.
     *
     * @param db
     *            the handler of the database
     */
    public static final void createTable(final SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    /**
     * Upgrade the table.
     *
     * @param db
     *            database where upgrade the table.
     */
    public static final void upgradeTable(final SQLiteDatabase db) {
        // TODO We're just dropping and recreating the table.
        // Maybe we should keep the data?
        String sql = "DROP table IF EXISTS "
                + RepositoryContract.Repository.TABLENAME;
        db.execSQL(sql);
    }

    private static final String DATABASE_CREATE = "create table "
            + RepositoryContract.Repository.TABLENAME + "("
            + RepositoryContract.Repository._ID
            + " integer primary key autoincrement, "
            + RepositoryContract.Repository.COLUMN_NAME + " TEXT, "
            + RepositoryContract.Repository.COLUMN_DESCRIPTION + " TEXT, "
            + RepositoryContract.Repository.COLUMN_OWNER + " TEXT "
            + ");";
}
