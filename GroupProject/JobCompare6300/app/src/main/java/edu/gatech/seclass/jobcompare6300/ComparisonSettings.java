package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

public class ComparisonSettings extends AppCompatActivity {
    private EditText yearlySalaryWeight;
    private EditText signingBonusWeight;
    private EditText yearlyBonusWeight;
    private EditText retirementBenefitsWeight;
    private EditText leaveTimeWeight;
    private Button saveButton;
    private Button cancelButton;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefFile";

    private TextView testText1;
    private TextView testText2;
    private TextView testText3;
    private TextView testText4;
    private TextView testText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_settings);

        yearlySalaryWeight = (EditText) findViewById(R.id.ysw);
        signingBonusWeight = (EditText) findViewById(R.id.sbw);
        yearlyBonusWeight = (EditText) findViewById(R.id.ybw);
        retirementBenefitsWeight = (EditText) findViewById(R.id.rbw);
        leaveTimeWeight = (EditText) findViewById(R.id.ltw);
        saveButton = (Button) findViewById(R.id.saveButton);

        // FOR TESTING ONLY
        testText1 = (TextView) findViewById(R.id.testText1);
        testText2 = (TextView) findViewById(R.id.testText2);
        testText3 = (TextView) findViewById(R.id.testText3);
        testText4 = (TextView) findViewById(R.id.testText4);
        testText5 = (TextView) findViewById(R.id.testText5);
        // FOR TESTING ONLY

        // get data
//        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);
//        if (prefs.contains("ysw")){
//            int yswValue = prefs.getInt("ysw", 1);
//            testText1.setText(String.valueOf(yswValue));
//        }
//        if (prefs.contains("sbw")){
//            int sbwValue = prefs.getInt("sbw", 1);
//            testText2.setText(String.valueOf(sbwValue));
//        }
//        if (prefs.contains("ybw")){
//            int ybwValue = prefs.getInt("ybw", 1);
//            testText3.setText(String.valueOf(ybwValue));
//        }
//        if (prefs.contains("rbw")){
//            int rbwValue = prefs.getInt("rbw", 1);
//            testText4.setText(String.valueOf(rbwValue));
//        }
//        if (prefs.contains("ltw")){
//            int ltwValue = prefs.getInt("ltw", 1);
//            testText5.setText(String.valueOf(ltwValue));
//        }
    }
    public void onClickSave(View v) {
        boolean noError = true;
        myPrefs = getSharedPreferences(PREFS_NAME, 0);
        if(yearlySalaryWeight.getText().toString().isEmpty()){
            yearlySalaryWeight.setError("Invalid Yearly Salary Weight!");
            noError = false;
        }
        if(signingBonusWeight.getText().toString().isEmpty()){
            signingBonusWeight.setError("Invalid Signing Bonus Weight!");
            noError = false;
        }
        if(yearlyBonusWeight.getText().toString().isEmpty()){
            yearlyBonusWeight.setError("Invalid Yearly Bonus Weight!");
            noError = false;
        }
        if(retirementBenefitsWeight.getText().toString().isEmpty()){
            retirementBenefitsWeight.setError("Invalid Retirement Benefits Weight!");
            noError = false;
        }
        if(leaveTimeWeight.getText().toString().isEmpty()){
            leaveTimeWeight.setError("Invalid Leave Time Weight!");
            noError = false;
        }

        if (noError) {
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.putInt("ysw", Integer.parseInt(yearlySalaryWeight.getText().toString()));
            editor.putInt("sbw", Integer.parseInt(signingBonusWeight.getText().toString()));
            editor.putInt("ybw", Integer.parseInt(yearlyBonusWeight.getText().toString()));
            editor.putInt("rbw", Integer.parseInt(retirementBenefitsWeight.getText().toString()));
            editor.putInt("ltw", Integer.parseInt(leaveTimeWeight.getText().toString()));
            editor.commit();

            // show preference data - FOR TESTING ONLY
            SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
            if (prefs.contains("ysw")) {
                int yswValue = prefs.getInt("ysw", 1);
                testText1.setText(String.valueOf(yswValue));
            }
            if (prefs.contains("sbw")) {
                int sbwValue = prefs.getInt("sbw", 1);
                testText2.setText(String.valueOf(sbwValue));
            }
            if (prefs.contains("ybw")) {
                int ybwValue = prefs.getInt("ybw", 1);
                testText3.setText(String.valueOf(ybwValue));
            }
            if (prefs.contains("rbw")) {
                int rbwValue = prefs.getInt("rbw", 1);
                testText4.setText(String.valueOf(rbwValue));
            }
            if (prefs.contains("ltw")) {
                int ltwValue = prefs.getInt("ltw", 1);
                testText5.setText(String.valueOf(ltwValue));
            }
            // show preference data - FOR TESTING ONLY
        }
    }
}
