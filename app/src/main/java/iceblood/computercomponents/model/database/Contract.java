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
    public static final class AssemblyEntity implements BaseColumns{
        public static final String TABLE_NAME = "Assemblies";

        public static final String NAME = "name";
        public static final String CPU_ID = "cpu_id";
        public static final String MOTHERBOARD_ID = "motherboard_id";
        public static final String GPU_ID = "gpu_id";
        public static final String GPU2_ID = "gpu2_id";
        public static final String GPU3_ID = "gpu3_id";
        public static final String GPU4_ID = "gpu4_id";
        public static final String GPU5_ID = "gpu5_id";
        public static final String GPU6_ID = "gpu6_id";
        public static final String RAM_SIZE = "ram_size";

    }
}
