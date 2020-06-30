package edu.gatech.seclass.jobcompare6300;

public class Job {
    private String company;
    private String city;
    private String state;
    private int costOfLiving;
    private int yearlySalary;
    private int signingBonus;
    private int yearlyBonus;
    private int retirementBenefits;
    private int leaveTime;

    public Job getAdjustedSalary(Job job) {
        int avgCOL = getAvgCOL();
        int costOfLiving = getCostOfLiving(job.city,job.state);
        double costFactor = avgCOL / costOfLiving;
        job.yearlySalary = (int) (job.yearlySalary * costFactor);
        job.leaveTime = (int) (job.leaveTime * costFactor);
        job.retirementBenefits = (int) (job.retirementBenefits * costFactor);
        job.signingBonus = (int) (job.signingBonus * costFactor);
        job.yearlyBonus = (int) (job.yearlyBonus * costFactor);
        job.costOfLiving = costOfLiving;
        return job;
    }

    public int getCostOfLiving(String city, String state) {
        int costOfLiving = 0;
        /* get cost of living from database passing city and state */

        return costOfLiving;
    }

    public int getAvgCOL() {
        int avgCOL = 0;
        /* get all Jobs and calculate average COL*/

        return avgCOL;
    }

}
