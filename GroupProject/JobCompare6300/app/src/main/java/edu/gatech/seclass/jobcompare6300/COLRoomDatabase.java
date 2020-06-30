package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = CostOfLiving.class, version = 1)
public abstract class COLRoomDatabase extends RoomDatabase {
    public abstract COLDao COLDao();
    private static volatile COLRoomDatabase COLRoomInstance;
    static COLRoomDatabase getDatabase(final Context context) {
        if (COLRoomInstance == null){
            synchronized (COLRoomDatabase.class){
                if (COLRoomInstance == null) {
                    COLRoomInstance = Room.databaseBuilder(context.getApplicationContext(), COLRoomDatabase.class, "col_database").build();
                }
            }
        }
        return COLRoomInstance;
    }
}
