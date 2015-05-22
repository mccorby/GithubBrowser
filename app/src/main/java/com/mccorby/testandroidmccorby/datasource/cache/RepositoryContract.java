package com.mccorby.testandroidmccorby.datasource.cache;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by JAC on 21/05/2015.
 */
public class RepositoryContract {

    /**
     * The authority clients use to get access to this content provider.
     */
    public static final String AUTHORITY = "com.mccorby.testandroidmccorby.provider";

    public static final Uri REPOSITORIES_URI = Uri.parse("content://" + AUTHORITY + "/repositories");

    public static class Repository implements BaseColumns {
        /** The table name for this type. */
        public static final String TABLENAME = "repository";

        /*
         * MIME type definitions
         * Return this in getType() method in ContentProvider
         */

        /**
         * The MIME type providing a list of messages.
         * Build the name as vnd.<project_or_company>.<table_or_type>
         */
        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/vnd.xingtest.repository";

        /**
         * The MIME type of a single message.
         */
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/vnd.xingtest.repository";

		/*
		 * Column definition
		 */

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_OWNER = "owner";

        /**
         * Columns to retrieve in query to the content provider.
         */
        public static final String[] ALL_COLUMNS_PROJECTION = { _ID,
                COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_OWNER
        };
    }
}
