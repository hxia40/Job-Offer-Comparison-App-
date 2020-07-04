package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

import java.util.List;
import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.DAI;
import edu.gatech.seclass.jobcompare6300.database.JobOffer;

public class ComparisonSettings extends AppCompatActivity {
    private EditText yearlySalaryWeight;
    private EditText signingBonusWeight;
    private EditText yearlyBonusWeight;
    private EditText retirementBenefitsWeight;
    private EditText leaveTimeWeight;
    private Button saveButton;
    private Button resetButton;
    public SharedPreferences myPrefs;
    public static final String PREFS_NAME = "myPrefFile";

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
        resetButton = (Button) findViewById(R.id.resetButton);
        myPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);


        // get data
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        if (prefs.contains("ysw")){
            int yswValue = prefs.getInt("ysw", 1);
            yearlySalaryWeight.setText(String.valueOf(yswValue));
        }
        if (prefs.contains("sbw")){
            int sbwValue = prefs.getInt("sbw", 1);
            signingBonusWeight.setText(String.valueOf(sbwValue));
        }
        if (prefs.contains("ybw")){
            int ybwValue = prefs.getInt("ybw", 1);
            yearlyBonusWeight.setText(String.valueOf(ybwValue));
        }
        if (prefs.contains("rbw")){
            int rbwValue = prefs.getInt("rbw", 1);
            retirementBenefitsWeight.setText(String.valueOf(rbwValue));
        }
        if (prefs.contains("ltw")){
            int ltwValue = prefs.getInt("ltw", 1);
            leaveTimeWeight.setText(String.valueOf(ltwValue));
        }

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

            // show preference data in place
            SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            if (prefs.contains("ysw")){
                int yswValue = prefs.getInt("ysw", 1);
                yearlySalaryWeight.setText(String.valueOf(yswValue));
            }
            if (prefs.contains("sbw")){
                int sbwValue = prefs.getInt("sbw", 1);
                signingBonusWeight.setText(String.valueOf(sbwValue));
            }
            if (prefs.contains("ybw")){
                int ybwValue = prefs.getInt("ybw", 1);
                yearlyBonusWeight.setText(String.valueOf(ybwValue));
            }
            if (prefs.contains("rbw")){
                int rbwValue = prefs.getInt("rbw", 1);
                retirementBenefitsWeight.setText(String.valueOf(rbwValue));
            }
            if (prefs.contains("ltw")){
                int ltwValue = prefs.getInt("ltw", 1);
                leaveTimeWeight.setText(String.valueOf(ltwValue));
            }
            // show preference data in place
        }
    }

    public void onClickReset(View v) {
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putInt("ysw", 1);
        editor.putInt("sbw", 1);
        editor.putInt("ybw", 1);
        editor.putInt("rbw", 1);
        editor.putInt("ltw", 1);
        editor.commit();
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        if (prefs.contains("ysw")){
            int yswValue = prefs.getInt("ysw", 1);
            yearlySalaryWeight.setText(String.valueOf(yswValue));
        }
        if (prefs.contains("sbw")){
            int sbwValue = prefs.getInt("sbw", 1);
            signingBonusWeight.setText(String.valueOf(sbwValue));
        }
        if (prefs.contains("ybw")){
            int ybwValue = prefs.getInt("ybw", 1);
            yearlyBonusWeight.setText(String.valueOf(ybwValue));
        }
        if (prefs.contains("rbw")){
            int rbwValue = prefs.getInt("rbw", 1);
            retirementBenefitsWeight.setText(String.valueOf(rbwValue));
        }
        if (prefs.contains("ltw")){
            int ltwValue = prefs.getInt("ltw", 1);
            leaveTimeWeight.setText(String.valueOf(ltwValue));
        }

    }


}
