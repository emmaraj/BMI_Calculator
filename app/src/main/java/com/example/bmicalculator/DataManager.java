package com.example.bmicalculator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataManager {

    //fetch all data
    public static ArrayList<MyNotes> fetchAllNotes(NoteDBHelper helper) {
        ArrayList<MyNotes> notes = new ArrayList<>();
        SQLiteDatabase database = helper.getWritableDatabase();

        String[] columns = {DataEntry.COLUMN_ID,
                DataEntry.COLUMN_TITLE,
                DataEntry.COLUMN_CONTENT};

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
        int positionTitle = cursor.getColumnIndex(DataEntry.COLUMN_TITLE);
        int positionContent = cursor.getColumnIndex(DataEntry.COLUMN_CONTENT);


        while (cursor.moveToNext()) {
            int ID = cursor.getInt(positionID);
            String title = cursor.getString(positionTitle);
            String content = cursor.getString(positionContent);

            notes.add(new MyNotes(ID, title, content));
        }
        cursor.close();
        return notes;
    }

    //save to db
}
