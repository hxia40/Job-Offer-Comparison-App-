package edu.gatech.seclass.jobcompare6300;

public class Weights {
    public int yearlySalaryWeight;
    public int signingBonusWeight;
    public int yearlyBonusWeight;
    public int retirementBenefitsWeight;
    public int leaveTimeWeight;

    public Weights getWeights() {
        Weights weights = new Weights();
        /* Get weights from database */
        return weights;
    }

    public int getWeightSum( Weights weights) {
        return weights.yearlySalaryWeight + weights.signingBonusWeight + weights.yearlyBonusWeight + weights.retirementBenefitsWeight + weights.leaveTimeWeight;
    }

}
