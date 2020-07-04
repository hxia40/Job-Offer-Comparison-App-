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

    @Query("Select city  from offers where current = 'True'")
    public String readCurrentCity();

    @Query("Select company  from offers where current = 1")
    public String readCurrentcompany();

    @Query("Select costOfLiving  from offers where current = 'True'")
    public Double readCurrentcostOfLiving();

    @Query("Select leaveTime  from offers where current = 'True'")
    public Integer readCurrentleaveTime();

    @Query("Select retiremnetBenifits  from offers where current = 'True'")
    public Float readCurrentretirementBonus();

    @Query("Select signingBonus  from offers where current = 'True'")
    public Double readCurrentsigningBonus();

    @Query("Select state  from offers where current = 'True'")
    public String readCurrentstate();

    @Query("Select yearlyBonus  from offers where current = 'True'")
    public Double readCurrentyearlyBonus();

    @Query("Select yearlySalary  from offers where current = 'True'")
    public Double readCurrentyearlySalary();

    @Update
    public  void updateJob(JobOffer offers);

    @Delete
    public void deleteJob(JobOffer offers);
}
