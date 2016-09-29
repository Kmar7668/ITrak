package softwaredesign.itrak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE = "my_database";
    private static final String TABLE = "Inventory";
    private static final String ITEM_NAME = "Name";
    private static final String ITEM_SERIAL = "Serial";
    private static final String ITEM_LOCATION = "Location";


    public DataBaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    db.execSQL("create table if not exists" +TABLE+ "(id integer primary key, " +ITEM_NAME+ " text, " +ITEM_SERIAL+ "text, "+ITEM_LOCATION+ "text)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertInventory(Inventory inventory) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put(ITEM_NAME, inventory.getItem_name());
            contentValues.put(ITEM_SERIAL, inventory.getItem_serial());
            contentValues.put(ITEM_LOCATION, inventory.getItem_location());
            db.insert(TABLE, null, contentValues);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Inventory> getAllInventory() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Inventory> inventory = new ArrayList<Inventory>();

        try {
            Cursor cur = db.rawQuery("select * from " + TABLE, null);
            cur.moveToFirst();
            while (cur.isAfterLast() == false) {
                Inventory i = new Inventory();
                i.setId(cur.getInt(cur.getColumnIndex("id")));
                i.setId(cur.getInt(cur.getColumnIndex(ITEM_NAME)));
                i.setId(cur.getInt(cur.getColumnIndex(ITEM_SERIAL)));
                i.setId(cur.getInt(cur.getColumnIndex(ITEM_LOCATION)));
                inventory.add(i);
                cur.moveToNext();
            }
            return inventory;
        } catch (Exception e) {
            return null;
        }
    }
}
