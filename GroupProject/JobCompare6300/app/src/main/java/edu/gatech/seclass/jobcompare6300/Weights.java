package edu.gatech.seclass.jobcompare6300;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class Weights extends AppCompatActivity {
    public int yearlySalaryWeight;
    public int signingBonusWeight;
    public int yearlyBonusWeight;
    public int retirementBenefitsWeight;
    public int leaveTimeWeight;

    public Weights getWeights() {
        Weights weights = new Weights();
        /* Get weights from database */
        // hui - reading preferences
        SharedPreferences mPreferences = getSharedPreferences(ComparisonSettings.PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();
        weights.yearlySalaryWeight = mPreferences.getInt("ysw", 1);
        weights.signingBonusWeight = mPreferences.getInt("sbw", 1);
        weights.yearlyBonusWeight = mPreferences.getInt("ybw", 1);
        weights.retirementBenefitsWeight = mPreferences.getInt("rbw", 1);
        weights.leaveTimeWeight = mPreferences.getInt("ltw", 1);
        // hui - end of reading preferences
        return weights;
    }

    public int getWeightSum( Weights weights) {
        return weights.yearlySalaryWeight + weights.signingBonusWeight + weights.yearlyBonusWeight + weights.retirementBenefitsWeight + weights.leaveTimeWeight;
    }

}
