package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "offers")
public class JobOffer {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "company")
    public String company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @ColumnInfo(name = "city")
    public String city;
    
    // state
	@ColumnInfo(name = "state")
    public String state;

	public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }

    // state
    @ColumnInfo(name = "current")
    public boolean current;

    public boolean getcurrent() {
        return current;
    }

    public void setcurrent(boolean current) {
        this.current = current;
    }
	
	
	// costOfLiving
	@ColumnInfo(name = "costOfLiving")
    public double costOfLiving;

	public double getcostOfLiving() {
        return costOfLiving;
    }

    public void setcostOfLiving(double costOfLiving) {
        this.costOfLiving = costOfLiving;
    }
	
	
	// yearlySalary
	@ColumnInfo(name = "yearlySalary")
    public double yearlySalary;

	public double getyearlySalary() {
        return yearlySalary;
    }

    public void setyearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }
	
	
	// signingBonus
	@ColumnInfo(name = "signingBonus")
    public double signingBonus;

	public double getsigningBonus() {
        return signingBonus;
    }

    public void setsigningBonus(double signingBonus) {
        this.signingBonus = signingBonus;
    }
	
	
	
	// yearlyBonus
	@ColumnInfo(name = "yearlyBonus")
    public double yearlyBonus;

	public double getyearlyBonus() {
        return yearlyBonus;
    }

    public void setyearlyBonus(double yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }
	
	
	
	
	
	// retiremnetBenifits
	@ColumnInfo(name = "retiremnetBenifits")
    public float retiremnetBenifits;

	public float getretiremnetBenifits() {
        return retiremnetBenifits;
    }

    public void setretiremnetBenifits(float retiremnetBenifits) {
        this.retiremnetBenifits = retiremnetBenifits;
    }
	
	
	// leaveTime
	@ColumnInfo(name = "leaveTime")
    public int leaveTime;

	public int getleaveTime() {
        return leaveTime;
    }

    public void setleaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
    }

}
