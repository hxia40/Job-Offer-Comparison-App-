package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// hui test
import android.content.SharedPreferences;
import android.content.Context;
// hui test

public class JobOffers extends AppCompatActivity implements View.OnClickListener {
    EditText title, company, city, state, costOfLiving, yearlySalary, signingBonus, yearlyBonus, retirementBonus, leaveTime;
    Button add, save, compare, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offers);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_job_offers_save:
                saveJobOffers();
                break;
            case R.id.btn_job_offers_cancel:
                cancelJobOffers();
                break;
            case R.id.btn_job_offers_add:
                addJobOffers();
                break;
            case R.id.btn_job_offers_compare:
                compareJobOffers();
                break;
        }
    }

    private void init(){
        title = (EditText)findViewById(R.id.txt_job_offers_title);
        company = (EditText)findViewById(R.id.txt_job_offers_company);
        city = (EditText)findViewById(R.id.txt_job_offers_city);
        state = (EditText)findViewById(R.id.txt_job_offers_state);
        costOfLiving = (EditText)findViewById(R.id.txt_job_offers_costofliving);
        yearlySalary = (EditText)findViewById(R.id.txt_job_offers_yearly_salary);
        signingBonus = (EditText)findViewById(R.id.txt_job_offers_signing_bonus);
        yearlyBonus = (EditText)findViewById(R.id.txt_job_offers_yearly_bonus);
        retirementBonus = (EditText)findViewById(R.id.txt_job_offers_retirement_bonus);
        leaveTime = (EditText)findViewById(R.id.txt_job_offers_leave_time);

        add = (Button)findViewById(R.id.btn_job_offers_add);
        save = (Button)findViewById(R.id.btn_job_offers_save);
        compare = (Button)findViewById(R.id.btn_job_offers_compare);
        cancel = (Button)findViewById(R.id.btn_job_offers_cancel);

        add.setOnClickListener(this);
        save.setOnClickListener(this);
        compare.setOnClickListener(this);
        cancel.setOnClickListener(this);

        // hui test
        TextView yearlySalaryWeight = (TextView) findViewById(R.id.huiOffer);
        SharedPreferences mPreferences = getSharedPreferences(ComparisonSettings.PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();
        int yswValue = mPreferences.getInt("ysw", 1);
        yearlySalaryWeight.setText(String.valueOf(yswValue));
        // hui test
    }

    private void compareJobOffers() {
//        System.out.println(title.getText().toString() + company.getText().toString() + city.getText().toString() + state.getText().toString() + costOfLiving.getText().toString() + yearlySalary.getText().toString() + signingBonus.getText().toString() + yearlyBonus.getText().toString() + retirementBonus.getText().toString() + leaveTime.getText().toString());
    }

    private void addJobOffers() {
//        System.out.println(title.getText().toString() + company.getText().toString() + city.getText().toString() + state.getText().toString() + costOfLiving.getText().toString() + yearlySalary.getText().toString() + signingBonus.getText().toString() + yearlyBonus.getText().toString() + retirementBonus.getText().toString() + leaveTime.getText().toString());
    }

    private void cancelJobOffers() {
//        System.out.println(title.getText().toString() + company.getText().toString() + city.getText().toString() + state.getText().toString() + costOfLiving.getText().toString() + yearlySalary.getText().toString() + signingBonus.getText().toString() + yearlyBonus.getText().toString() + retirementBonus.getText().toString() + leaveTime.getText().toString());
    }

    private void saveJobOffers() {
//        System.out.println(title.getText().toString() + company.getText().toString() + city.getText().toString() + state.getText().toString() + costOfLiving.getText().toString() + yearlySalary.getText().toString() + signingBonus.getText().toString() + yearlyBonus.getText().toString() + retirementBonus.getText().toString() + leaveTime.getText().toString());
    }
}
