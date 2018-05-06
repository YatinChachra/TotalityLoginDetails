package com.example.android.totalitylogindetails;

/**
 * Created by 300 on 5/3/2018.
 */

import android.net.Uri;
//package com.example.android.totalitylogin;

        import android.content.ContentResolver;
        import android.content.ContentUris;
        import android.net.Uri;
        import android.provider.BaseColumns;

public class TotalityLoginContract implements BaseColumns {

    /**
     * This it the content authority for DroidTermsExample provider.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.totalitylogin";

    /**
     * This is the {@link Uri} on which all other DroidTermsExample Uris are built.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * The path for terms
     */
    public static final String PATH_TERMS = "login_details";

    /**
     * This is the {@link Uri} used to get a full list of terms and definitions.
     */
    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_TERMS).build();


    /**
     * This is a String type that denotes a Uri references a list or directory.
     */
    public static final String CONTENT_TYPE =
            ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TERMS;

    /**
     * This is a String type that denotes a Uri references a single item.
     */
    public static final String CONTENT_ITEM_TYPE =
            ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TERMS;


    // Declaring all these as constants makes code a lot more readable.
    // It also looks a more like SQL.

    /**
     * This is the version of the database for {@link android.database.sqlite.SQLiteOpenHelper}.
     */
    public static final int DATABASE_VERSION = 1;

    /**
     * This is the name of the SQL table for terms.
     */
    public static final String TERMS_TABLE = "login_details";
    /**
     * This is the name of the SQL database for terms.
     */
    public static final String DATABASE_NAME = "totality.db";

    /**
     * This is the column name in the SQLiteDatabase for the word.
     */
    public static final String COLUMN_EAMIL = "login_email";
    /**
     * This is the column name in the SQLiteDatabase for the definition.
     */
    public static final String COLUMN_PASSWORD = "login_password";


    public static final String COLUMN_DATE = "date";


    /**
     * This is an array containing all the column headers in the terms table.
     */
    public static final String[] COLUMNS =
            {_ID, COLUMN_EAMIL, COLUMN_PASSWORD,COLUMN_DATE};

    /**
     * This is the index of the ID in the terms table
     */
    public static final int COLUMN_INDEX_ID = 0;
    /**
     * This is the index of the word in the terms table
     */
    public static final int COLUMN_INDEX_WORD = 1;
    /**
     * This is the index of the definition in the terms table
     */
    public static final int COLUMN_INDEX_DEFINITION = 2;

    /**
     * This method creates a {@link Uri} for a single term, referenced by id.
     * @param id The id of the term.
     * @return The Uri with the appended id.
     */
    public static Uri buildTermUriWithId(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }
}
