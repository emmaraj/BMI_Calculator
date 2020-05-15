package com.example.bmicalculator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import static com.example.bmicalculator.ContractClass.DataEntry;
public class DataManager {

    //fetch all data
    public static ArrayList<BMI> fetchAllEntry(DBHelper helper) {
        ArrayList<BMI> enteriesArrayList = new ArrayList<>();
        SQLiteDatabase database = helper.getWritableDatabase();

        String[] columns = {DataEntry.COLUMN_ID,
                DataEntry.COLUMN_WEIGHT,
                DataEntry.COLUMN_DATE,
                DataEntry.COLUMN_INDEX};

        Cursor cursor = database.query(
                DataEntry.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        int positionID = cursor.getColumnIndex(DataEntry.COLUMN_ID);
        int positionWeight = cursor.getColumnIndex(DataEntry.COLUMN_WEIGHT);
        int positionDateEntered = cursor.getColumnIndex(DataEntry.COLUMN_DATE);
        int positionIndex= cursor.getColumnIndex(DataEntry.COLUMN_INDEX);


        while (cursor.moveToNext()) {
            int ID = cursor.getInt(positionID);
            double weight = cursor.getDouble(positionWeight);
            double index = cursor.getDouble(positionIndex);
            long date = cursor.getLong(positionDateEntered);

            enteriesArrayList.add(new BMI(ID, date, weight, index));
        }
        cursor.close();
        return enteriesArrayList;
    }

    //save to db

}
