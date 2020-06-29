package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;



@Database(entities = {JobOffer.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DAI AppDatabaseObject();
}