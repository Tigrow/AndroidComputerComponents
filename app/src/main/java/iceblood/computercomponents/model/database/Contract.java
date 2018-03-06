package iceblood.computercomponents.model.database;


import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Contracts BD
 */

public final class Contract {
    public static final String DATABASE_NAME = "COMPONENT";
    public static final int DATABASE_VERSION = 1;
    public static final String CONTENT_AUTHORITY = "iceblood.computercomponents";

    public static final class SimpleEntity implements BaseColumns {

        public static final String TABLE_NAME = "liked_name";//name of table

        public final static String _ID = BaseColumns._ID;
        public static final String KEY_NAME = "name";
        public static final String KEY_DESCRIPTION = "description";
        public static final String KEY_PRIORITY = "date_of_liked";
    }
}
