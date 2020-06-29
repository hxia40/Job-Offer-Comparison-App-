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

}
