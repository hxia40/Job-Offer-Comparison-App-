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

    @Query("Select title  from offers where current = 1")
    public String readCurrentTitle();

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

    @Query("Select CASE current WHEN 1 THEN '(Current Job)' ELSE '' END  from offers")
    public String[] readCurrentInd();

    @Query("Select signingBonus  from offers where current = 1")
    public Double readCurrentsigningBonus();

    @Query("Select state  from offers where current = 1")
    public String readCurrentstate();

    @Query("Select yearlyBonus  from offers where current = 1")
    public Double readCurrentyearlyBonus();

    @Query("Select yearlySalary  from offers where current = 1")
    public Double readCurrentyearlySalary();

    @Query("Delete from offers where current = 1")
    public void DeleteCurrent();

    @Query("Delete from offers")
    public void Nuke();
    
    @Query("Select max(id) from offers")
    public int getMaxId();

    @Query("Select id from offers where current = 1")
    public int getCurrentJobId();

    @Query("Select id from (Select id, (:ysw * yearlySalary/:base) + (:sbw * signingBonus/:base) + (:ybw * yearlyBonus/:base) + (yearlySalary * retiremnetBenifits * :rbw/:base) + (leaveTime * yearlySalary/260) * (:ltw/:base) as rank from offers order by rank desc)")
    public int[] readOffer(int ysw, int sbw, int ybw, int rbw, int ltw, int base);

    @Query("Select company from offers where id = :offerId")
    public String getCompanyById(int offerId);

    @Query("Select title from offers where id = :offerId")
    public String getTitleById(int offerId);

    @Query("Select city from offers where id = :offerId")
    public String getCityById(int offerId);

    @Query("Select state from offers where id = :offerId")
    public String getStateById(int offerId);

    @Query("Select costOfLiving from offers where id = :offerId")
    public double getCOLById(int offerId);

    @Query("Select yearlySalary from offers where id = :offerId")
    public double getSalaryById(int offerId);

    @Query("Select signingBonus from offers where id = :offerId")
    public double getSigningById(int offerId);

    @Query("Select yearlyBonus from offers where id = :offerId")
    public double getBonusById(int offerId);

    @Query("Select retiremnetBenifits from offers where id = :offerId")
    public double getRetirementById(int offerId);

    @Query("Select leaveTime from offers where id = :offerId")
    public double getLeaveofferId);ById(int


    @Update
    public  void updateJob(JobOffer offers);

    @Delete
    public void deleteJob(JobOffer offers);
}
