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

    @Query("Select company from (Select company, (:ysw * yearlySalary/:base) + (:sbw * signingBonus/:base) + (:ybw * yearlyBonus/:base) + (yearlySalary * retiremnetBenifits * :rbw/:base) + (leaveTime * yearlySalary/260) * (:ltw/:base) as rank from offers order by rank desc)")
    public String[] readCompany(int ysw, int sbw, int ybw, int rbw, int ltw, int base);


    @Query("Select title from (Select title, (:ysw * yearlySalary/:base) + (:sbw * signingBonus/:base) + (:ybw * yearlyBonus/:base) + (yearlySalary * retiremnetBenifits * :rbw/:base) + (leaveTime * yearlySalary/260) * (:ltw/:base) as rank from offers order by rank desc)")
    public String[] readTitle(int ysw, int sbw, int ybw, int rbw, int ltw, int base);

    @Query("Select city from (Select city, (:ysw * yearlySalary/:base) + (:sbw * signingBonus/:base) + (:ybw * yearlyBonus/:base) + (yearlySalary * retiremnetBenifits * :rbw/:base) + (leaveTime * yearlySalary/260) * (:ltw/:base) as rank from offers order by rank desc)")
    public String[] readCity(int ysw, int sbw, int ybw, int rbw, int ltw, int base);

    @Query("Select count(*) from offers")
    public int readsize();



    @Query("Select city  from offers where current = 1")
    public String readCurrentCity();

    @Query("Select company  from offers where current = 1")
    public String readCurrentcompany();

    @Query("Select costOfLiving  from offers where current = 1")
    public Double readCurrentcostOfLiving();

    @Query("Select leaveTime  from offers where current = 1")
    public Integer readCurrentleaveTime();

    @Query("Select retiremnetBenifits  from offers where current = 1")
    public Float readCurrentretirementBonus();

    @Query("Select signingBonus  from offers where current = 1")
    public Double readCurrentsigningBonus();

    @Query("Select state  from offers where current = 1")
    public String readCurrentstate();

    @Query("Select yearlyBonus  from offers where current = 1")
    public Double readCurrentyearlyBonus();

    @Query("Select yearlySalary  from offers where current = 1")
    public Double readCurrentyearlySalary();

    @Update
    public  void updateJob(JobOffer offers);

    @Delete
    public void deleteJob(JobOffer offers);
}
