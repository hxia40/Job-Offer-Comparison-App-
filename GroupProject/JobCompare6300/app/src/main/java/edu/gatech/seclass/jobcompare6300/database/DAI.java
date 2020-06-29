package edu.gatech.seclass.jobcompare6300.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAI {

    @Insert
    public void addJob(JobOffer offers);

    //@Query("Select * from offers")
    //public List<JobOffer> readJob();

    @Query("Select company from offers")
    public List<String> readJob();

    @Query("Select company from offers where id = 1")
    public String readCompany();

    @Query("Select city from offers where id = 1")
    public String readCity();

    @Update
    public  void updateJob(JobOffer offers);

    @Delete
    public void deleteJob(JobOffer offers);
}
