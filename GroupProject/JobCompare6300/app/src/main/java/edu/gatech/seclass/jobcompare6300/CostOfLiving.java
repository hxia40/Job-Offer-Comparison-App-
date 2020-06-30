package edu.gatech.seclass.jobcompare6300;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "COL")
public class CostOfLiving {
    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getCost() {
        return this.cost;
    }

    private @PrimaryKey String city;
    private @PrimaryKey String state;
    private int cost;

    public CostOfLiving(String city, String state, int cost) {
        this.city = city;
        this.state = state;
        this.cost = cost;
    }

}
