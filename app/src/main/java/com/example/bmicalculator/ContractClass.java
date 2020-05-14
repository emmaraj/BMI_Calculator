package com.example.bmicalculator;

import android.provider.BaseColumns;

public class ContractClass {
    static class DataEntry implements BaseColumns {
        static final String TABLE_NAME = "weights";
        static final String COLUMN_ID = _ID;
        static final String COLUMN_WEIGHT = "WEIGHT";
        static final String COLUMN_DATE = "DATE";
        static final String COLUMN_BMI = "INDEX";

        static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WEIGHT + " TEXT NOT NULL, " +
                COLUMN_DATE + " TEXT NOT NULL, " +
                COLUMN_BMI + " TEXT NOT NULL)";

        static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
