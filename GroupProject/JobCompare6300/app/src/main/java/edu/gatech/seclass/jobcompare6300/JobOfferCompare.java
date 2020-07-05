package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.DAI;

public class JobOfferCompare extends AppCompatActivity {

    private EditText job1_title_id;
    private EditText job2_title_id;
    private EditText job1_company_id;
    private EditText job2_company_id;
    private EditText job1_city_id;
    private EditText job1_state_id;
    private EditText job1_col_id;
    private EditText job1_salary_id;
    private EditText job1_signing_id;
    private EditText job1_bonus_id;
    private EditText job1_retirement_id;
    private EditText job1_leave_id;
    private EditText job2_city_id;
    private EditText job2_state_id;
    private EditText job2_col_id;
    private EditText job2_salary_id;
    private EditText job2_signing_id;
    private EditText job2_bonus_id;
    private EditText job2_retirement_id;
    private EditText job2_leave_id;
    public String job1, job2;
    public int job1Id, job2Id;

    private String
            job1_title = "SDE",
            job1_company = "Amazon",
            job1_city = "Seattle",
            job1_state = "WA",
            job1_col = "205",
            job1_salary = "$250,000",
            job1_signing = "$50,000",
            job1_bonus = "$37,500",
            job1_retirement = "8%",
            job1_leave = "15";
    private String
            job2_title = "SSE",
            job2_company = "Microsoft",
            job2_city = "New York",
            job2_state = "NY",
            job2_col = "260",
            job2_salary = "$280,000",
            job2_signing = "$35,000",
            job2_bonus = "$56,000",
            job2_retirement = "12%",
            job2_leave = "18";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer_compare);

        Intent i = getIntent();
//        job1 = i.getStringExtra("Job1");
//        job2 = i.getStringExtra("Job2");

        job1_title_id = findViewById(R.id.txt_job_offer1_title);
        job1_company_id = findViewById(R.id.txt_job_offer1_company);
        job1_city_id = findViewById(R.id.txt_job_offer1_city);
        job1_state_id = findViewById(R.id.txt_job_offer1_state);
        job1_col_id = findViewById(R.id.txt_job_offer1_COL);
        job1_salary_id = findViewById(R.id.txt_job_offer1_yearly_salary);
        job1_signing_id = findViewById(R.id.txt_job_offer1_signing_bonus);
        job1_bonus_id = findViewById(R.id.txt_job_offer1_yearly_bonus);
        job1_retirement_id = findViewById(R.id.txt_job_offer1_retirement_bonus);
        job1_leave_id = findViewById(R.id.txt_job_offer1_leave_time);

        job2_title_id = findViewById(R.id.txt_job_offer2_title);
        job2_company_id = findViewById(R.id.txt_job_offer2_company);
        job2_city_id = findViewById(R.id.txt_job_offer2_city);
        job2_state_id = findViewById(R.id.txt_job_offer2_state);
        job2_col_id = findViewById(R.id.txt_job_offer2_COL);
        job2_salary_id = findViewById(R.id.txt_job_offer2_yearly_salary);
        job2_signing_id = findViewById(R.id.txt_job_offer2_signing_bonus);
        job2_bonus_id = findViewById(R.id.txt_job_offer2_yearly_bonus);
        job2_retirement_id = findViewById(R.id.txt_job_offer2_retirement_bonus);
        job2_leave_id = findViewById(R.id.txt_job_offer2_leave_time);

        //Populate job1 and job2
//        job1Id = Integer.parseInt(job1);
//        job2Id = Integer.parseInt(job2);
        job1Id = Integer.parseInt(i.getStringExtra("Job1"));
        job2Id = Integer.parseInt(i.getStringExtra("Job2"));

        if ((job1Id > 0) && (job2Id > 0)){
            AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                    .allowMainThreadQueries()
                    .build();
            DAI DAI = database.AppDatabaseObject();

            job1_title = DAI.getTitleById(job1Id);
            job1_company = DAI.getCompanyById(job1Id);
            job1_city = DAI.getCityById(job1Id);
            job1_state = DAI.getStateById(job1Id);
            job1_col = Double.toString(DAI.getCOLById(job1Id));
            job1_salary = Double.toString(DAI.getSalaryById(job1Id));
            job1_signing = Double.toString(DAI.getSigningById(job1Id));
            job1_bonus = Double.toString(DAI.getBonusById(job1Id));
            job1_retirement = Double.toString(DAI.getRetirementById(job1Id));
            job1_leave = Double.toString(DAI.getLeaveById(job1Id));

            job2_title = DAI.getTitleById(job2Id);
            job2_company = DAI.getCompanyById(job2Id);
            job2_city = DAI.getCityById(job2Id);
            job2_state = DAI.getStateById(job2Id);
            job2_col = Double.toString(DAI.getCOLById(job2Id));
            job2_salary = Double.toString(DAI.getSalaryById(job2Id));
            job2_signing = Double.toString(DAI.getSigningById(job2Id));
            job2_bonus = Double.toString(DAI.getBonusById(job2Id));
            job2_retirement = Double.toString(DAI.getRetirementById(job2Id));
            job2_leave = Double.toString(DAI.getLeaveById(job2Id));

            job1_title_id.setText(job1_title);
            job1_company_id.setText(job1_company);
            job1_city_id.setText(job1_city);
            job1_state_id.setText(job1_state);
            job1_col_id.setText(job1_col);
            job1_salary_id.setText(job1_salary);
            job1_signing_id.setText(job1_signing);
            job1_bonus_id.setText(job1_bonus);
            job1_retirement_id.setText(job1_retirement);
            job1_leave_id.setText(job1_leave);

            job2_title_id.setText(job2_title);
            job2_company_id.setText(job2_company);
            job2_city_id.setText(job2_city);
            job2_state_id.setText(job2_state);
            job2_col_id.setText(job2_col);
            job2_salary_id.setText(job2_salary);
            job2_signing_id.setText(job2_signing);
            job2_bonus_id.setText(job2_bonus);
            job2_retirement_id.setText(job2_retirement);
            job2_leave_id.setText(job2_leave);
        }


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                this.finish();
                break;
            case R.id.btn_home:
//                AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
//                        .allowMainThreadQueries()
//                        .build();
//                DAI DAI = database.AppDatabaseObject();
//                DAI.Nuke();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
