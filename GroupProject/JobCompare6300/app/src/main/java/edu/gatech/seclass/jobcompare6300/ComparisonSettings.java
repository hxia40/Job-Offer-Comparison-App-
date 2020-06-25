package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
    private TextView testText;
    private Button saveButton;
    private Button cancelButton;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_settings);

        yearlySalaryWeight = (EditText) findViewById(R.id.ysw);
        signingBonusWeight = (EditText) findViewById(R.id.sbw);
        yearlyBonusWeight = (EditText) findViewById(R.id.ybw);
        retirementBenefitsWeight = (EditText) findViewById(R.id.rbw);
        leaveTimeWeight = (EditText) findViewById(R.id.ltw);

        testText = (TextView) findViewById(R.id.testText);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putInt("ysw", Integer.parseInt(yearlySalaryWeight.getText().toString()));
                editor.commit();
            }
        });
        // get dara for ysw
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);
        if (prefs.contains("ysw")){
            String yswValue = prefs.getString("ysw", "ysw not found");
            testText.setText("YSW:" + yswValue);
        }

    }
}
