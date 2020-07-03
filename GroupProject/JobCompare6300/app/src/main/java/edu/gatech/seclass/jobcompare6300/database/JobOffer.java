package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "offers")
public class JobOffer {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "company")
    private String company;

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
    private String city;
    
    // state
	//@ColumnInfo(name = "state")
    //private String state;

	//public String getstate() {
    //    return state;
    //}

    //public void setstate(String state) {
    //    this.state = state;
    //}
	
	
	
	// costOfLiving
	//@ColumnInfo(name = "costOfLiving")
    //private double costOfLiving;

	//public double getcostOfLiving() {
    //    return costOfLiving;
    //}

    //public void setcostOfLiving(double costOfLiving) {
    //    this.costOfLiving = costOfLiving;
    //}
	
	
	// yearlySalary
	//@ColumnInfo(name = "yearlySalary")
    //private double yearlySalary;

	//public double getyearlySalary() {
    //    return yearlySalary;
    //}

    //public void setyearlySalary(double yearlySalary) {
    //    this.yearlySalary = yearlySalary;
    //}
	
	
	// signingBonus
	//@ColumnInfo(name = "signingBonus")
    //private double signingBonus;

	//public double getsigningBonus() {
    //    return signingBonus;
    //}

    //public void setyearlySalary(double signingBonus) {
    //    this.signingBonus = signingBonus;
    //}
	
	
	
	// yearlyBonus
	//@ColumnInfo(name = "yearlyBonus")
    //private double yearlyBonus;

	//public double getyearlyBonus() {
    //    return yearlyBonus;
    //}

    //public void setyearlyBonus(double yearlyBonus) {
    //    this.yearlyBonus = yearlyBonus;
    //}
	
	
	
	
	
	// retiremnetBenifits
	//@ColumnInfo(name = "retiremnetBenifits")
    //private float retiremnetBenifits;

	//public float getretiremnetBenifits() {
    //    return retiremnetBenifits;
    //}

    //public void setretiremnetBenifits(float retiremnetBenifits) {
    //    this.retiremnetBenifits = retiremnetBenifits;
    //}
	
	
	// leaveTime
	//@ColumnInfo(name = "leaveTime")
    //private int leaveTime;

	//public int getleaveTime() {
    //    return leaveTime;
    //}

    //public void setleaveTime(int leaveTime) {
    //    this.leaveTime = leaveTime;
    //}

}
