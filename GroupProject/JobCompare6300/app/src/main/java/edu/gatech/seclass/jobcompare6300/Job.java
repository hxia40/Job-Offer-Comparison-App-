package edu.gatech.seclass.jobcompare6300;
import java.util.UUID;

import edu.gatech.seclass.jobcompare6300.Weights;
public class Job {
    private String id;
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
        job.jobScore = getWeightedJobScore(job);
        /* Save job to database */
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
        int costOfLiving = 0;
        /* get cost of living from database passing city and state */

        if (costOfLiving == 0) {
            costOfLiving = getAvgCOL();
        }
        return costOfLiving;
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

    public int getWeightedJobScore(Job job) {
        int jobScore = 0;
        Weights weights = new Weights();
        weights.getWeights();
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
