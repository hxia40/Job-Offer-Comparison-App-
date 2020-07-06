package edu.gatech.seclass.jobcompare6300;
import java.util.HashMap;
import java.util.UUID;

import edu.gatech.seclass.jobcompare6300.Weights;
public class Job {
    private String id;
    private String title;
    private String company;
    private String city;
    private String state;
    private int costOfLiving;
    private int yearlySalary;
    private int signingBonus;
    private int yearlyBonus;
    private int retirementBenefits;
    private int leaveTime;
    private boolean current;
    private int jobScore;

    public Job saveJob(Job job) {
        job.id = UUID.randomUUID().toString();
        job.costOfLiving = getCostOfLiving(job.city, job.state);
//        job.jobScore = getWeightedJobScore(job, weights);
        /* Save job to database */
        return job;
    }

    public Job getJobDetails(String id) {
        Job job = new Job();
        //get job details
        return job;
    }

    public Job getAdjustedSalary(Job job) {
        int avgCOL = getAvgCOL();
        int costOfLiving = getCostOfLiving(job.city,job.state);
        double costFactor = avgCOL / costOfLiving;
        job.yearlySalary = (int) (job.yearlySalary * costFactor);
        job.signingBonus = (int) (job.signingBonus * costFactor);
        job.yearlyBonus = (int) (job.yearlyBonus * costFactor);
        job.costOfLiving = costOfLiving;
        return job;
    }

    public int getCostOfLiving(String city, String state) {
        double col = 0;
        String temp = "";
        HashMap<String, Integer> COL_MAP = new HashMap<>();
        COL_MAP.put("Anchorage,AL", 186);
        COL_MAP.put("Phoenix,AZ", 166);
        COL_MAP.put("Tucson,AZ", 144);
        COL_MAP.put("Mountain View,CA", 262);
        COL_MAP.put("San Francisco,CA", 251);
        COL_MAP.put("Oakland,CA", 222);
        COL_MAP.put("Los Angeles,CA", 210);
        COL_MAP.put("San Jose,CA", 198);
        COL_MAP.put("San Diego,CA", 188);
        COL_MAP.put("Sacramento,CA", 187);
        COL_MAP.put("Riverside,CA", 156);
        COL_MAP.put("Denver,CO", 195);
        COL_MAP.put("Colorado Springs,CO", 155);
        COL_MAP.put("Washington,DC", 225);
        COL_MAP.put("Miami,FL", 201);
        COL_MAP.put("Orlando,FL", 169);
        COL_MAP.put("Tampa,FL", 163);
        COL_MAP.put("Jacksonville,FL", 146);
        COL_MAP.put("Atlanta,GA", 163);
        COL_MAP.put("Honolulu,HI", 203);
        COL_MAP.put("Boise,ID", 142);
        COL_MAP.put("Chicago,IL", 200);
        COL_MAP.put("Indianapolis,IN", 151);
        COL_MAP.put("Louisville,KY", 143);
        COL_MAP.put("New Orleans,LA", 156);
        COL_MAP.put("Boston,MA", 214);
        COL_MAP.put("Baltimore,MD", 164);
        COL_MAP.put("Detroit,MI", 150);
        COL_MAP.put("Minneapolis,MN", 171);
        COL_MAP.put("St. Louis,MO", 152);
        COL_MAP.put("Kansas City,MO", 144);
        COL_MAP.put("Charlotte,NC", 168);
        COL_MAP.put("Raleigh,NC", 154);
        COL_MAP.put("Omaha,NE", 142);
        COL_MAP.put("Jersey City,NJ", 235);
        COL_MAP.put("Albuquerque,NM", 133);
        COL_MAP.put("Las Vegas,NV", 160);
        COL_MAP.put("New York,NY", 260);
        COL_MAP.put("Cleveland,OH", 155);
        COL_MAP.put("Cincinnati,OH", 140);
        COL_MAP.put("Portland,OR", 189);
        COL_MAP.put("Philadelphia,PA", 179);
        COL_MAP.put("Pittsburg,PA", 171);
        COL_MAP.put("Providence,RI", 161);
        COL_MAP.put("Charleston,SC", 163);
        COL_MAP.put("Nashville,TN", 158);
        COL_MAP.put("Memphis,TN", 130);
        COL_MAP.put("Austin,TX", 171);
        COL_MAP.put("Fort Worth,TX", 167);
        COL_MAP.put("Dallas,TX", 162);
        COL_MAP.put("Houston,TX", 152);
        COL_MAP.put("San Antonio,TX", 144);
        COL_MAP.put("Salt Lake City,UT", 168);
        COL_MAP.put("Burlington,VT", 166);
        COL_MAP.put("Seattle,WA", 205);
        COL_MAP.put("Spokane,WA", 151);
        COL_MAP.put("Milwaukee,WI", 149);

        temp = city + "," + state;

        if (COL_MAP.get(temp) == null) {col = 220;}
        else {col = COL_MAP.get(temp);}
//        System.out.println("colllll in job:"+ col);
        return (int) Math.round(col);
    }

    public int getAvgCOL() {
        int avgCOL = 0;
        /* get all Jobs and calculate average COL*/

        return avgCOL;
    }

    /*public int getJobScore(Job job) {
        int jobScore = 0;
        job = getAdjustedSalary(job);
        jobScore = job.yearlySalary + job.signingBonus + job.yearlyBonus + (job.yearlySalary * job.retirementBenefits) + (job.leaveTime * job.yearlySalary / 260);
        return jobScore;
    }*/

    public int getWeightedJobScore(Job job, Weights weights) {
        int jobScore = 0;
//        Weights weights = new Weights();
//        weights.getWeights();
        int base = weights.getWeightSum(weights);
        job = getAdjustedSalary(job);
        jobScore = ( job.yearlySalary * weights.yearlySalaryWeight / base ) +
                (job.signingBonus * weights.signingBonusWeight / base ) +
                (job.yearlyBonus * weights.yearlyBonusWeight / base ) +
                (job.yearlySalary * job.retirementBenefits * weights.retirementBenefitsWeight / base ) +
                (job.leaveTime * job.yearlySalary / 260) * ( weights.leaveTimeWeight / base );
        return jobScore;
    }

}
