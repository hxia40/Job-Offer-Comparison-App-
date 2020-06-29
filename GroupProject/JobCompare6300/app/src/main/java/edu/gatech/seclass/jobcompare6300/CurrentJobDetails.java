package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CurrentJobDetails extends AppCompatActivity implements View.OnClickListener {
    EditText title, company, city, state, costOfLiving, yearlySalary, signingBonus, yearlyBonus, retirementBonus, leaveTime;
    Button save, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job_details);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_current_job_details_save:
                saveCurrentJobDetails();
                break;
            case R.id.btn_current_job_details_cancel:
                cancelCurrentJobDetails();
                break;    
        }
    }
    
    private void init(){
        title = (EditText)findViewById(R.id.txt_current_job_details_title);
        company = (EditText)findViewById(R.id.txt_current_job_details_company);
        city = (EditText)findViewById(R.id.txt_current_job_details_city);
        state = (EditText)findViewById(R.id.txt_current_job_details_state);
        costOfLiving = (EditText)findViewById(R.id.txt_current_job_details_costofliving);
        yearlySalary = (EditText)findViewById(R.id.txt_current_job_details_yearly_salary);
        signingBonus = (EditText)findViewById(R.id.txt_current_job_details_signing_bonus);
        yearlyBonus = (EditText)findViewById(R.id.txt_current_job_details_yearly_bonus);
        retirementBonus = (EditText)findViewById(R.id.txt_current_job_details_retirement_bonus);
        leaveTime = (EditText)findViewById(R.id.txt_current_job_details_leave_time);

        save = (Button)findViewById(R.id.btn_current_job_details_save);
        cancel = (Button)findViewById(R.id.btn_current_job_details_cancel);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    private void cancelCurrentJobDetails() {
    }

    private void saveCurrentJobDetails() {
    }
}
