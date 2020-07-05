package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.DAI;
import edu.gatech.seclass.jobcompare6300.database.JobOffer;
import android.content.SharedPreferences;
import android.content.Context;
import android.widget.Toast;


public class JobOffers extends AppCompatActivity implements View.OnClickListener {
    EditText title, company, city, state, costOfLiving, yearlySalary, signingBonus, yearlyBonus, retirementBonus, leaveTime;
    Button save, compare, cancel;
    public int job1Id, job2Id;
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

        save = (Button)findViewById(R.id.btn_job_offers_save);
        compare = (Button)findViewById(R.id.btn_job_offers_compare);
        cancel = (Button)findViewById(R.id.btn_job_offers_cancel);

//        add.setOnClickListener(this);
        save.setOnClickListener(this);
        compare.setOnClickListener(this);
        cancel.setOnClickListener(this);

        Intent i = getIntent();
        job1Id = Integer.parseInt(i.getStringExtra("Job1"));
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                .allowMainThreadQueries()
                .build();
        DAI DAI = database.AppDatabaseObject();

        if (job1Id > 0) {
            title.setText(DAI.getTitleById(job1Id));
            company.setText(DAI.getCompanyById(job1Id));
            city.setText(DAI.getCityById(job1Id));
            state.setText(DAI.getStateById(job1Id));
            costOfLiving.setText(Double.toString(DAI.getCOLById(job1Id)));
            yearlySalary.setText(Double.toString(DAI.getSalaryById(job1Id)));
            signingBonus.setText(Double.toString(DAI.getSigningById(job1Id)));
            yearlyBonus.setText(Double.toString(DAI.getBonusById(job1Id)));
            retirementBonus.setText(Double.toString(DAI.getRetirementById(job1Id)));
            leaveTime.setText(Double.toString(DAI.getLeaveById(job1Id)));
        }

//        // hui test
//        TextView yearlySalaryWeight = (TextView) findViewById(R.id.huiOffer);
//        SharedPreferences mPreferences = getSharedPreferences(ComparisonSettings.PREFS_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = mPreferences.edit();
//        int yswValue = mPreferences.getInt("ysw", 1);
//        yearlySalaryWeight.setText(String.valueOf(yswValue));
//        // hui test

    }

    private void compareJobOffers() {
//        System.out.println(title.getText().toString() + company.getText().toString() + city.getText().toString() + state.getText().toString() + costOfLiving.getText().toString() + yearlySalary.getText().toString() + signingBonus.getText().toString() + yearlyBonus.getText().toString() + retirementBonus.getText().toString() + leaveTime.getText().toString());
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        DAI DAI = database.AppDatabaseObject();
        job2Id = DAI.getCurrentJobId();
        if (job1Id <= 0){
            job1Id = DAI.getMaxId();
        }
        Intent i = new Intent(getApplicationContext(), JobOfferCompare.class);
        i.putExtra("Job1", Integer.toString(job1Id));
        i.putExtra("Job2", Integer.toString(job2Id));
        startActivity(i);
    }

    private void addJobOffers() {
//        System.out.println(title.getText().toString() + company.getText().toString() + city.getText().toString() + state.getText().toString() + costOfLiving.getText().toString() + yearlySalary.getText().toString() + signingBonus.getText().toString() + yearlyBonus.getText().toString() + retirementBonus.getText().toString() + leaveTime.getText().toString());
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        DAI DAI = database.AppDatabaseObject();
        JobOffer offer = new JobOffer();
        offer.settitle(title.getText().toString());
        offer.setCity(city.getText().toString());
        offer.setCompany(company.getText().toString());
        offer.setcostOfLiving((Double.valueOf(costOfLiving.getText().toString())));
        offer.setleaveTime(Integer.valueOf(leaveTime.getText().toString()));
        offer.setretiremnetBenifits(Float.valueOf(retirementBonus.getText().toString()));
        offer.setsigningBonus(Double.valueOf(signingBonus.getText().toString()));
        offer.setstate(state.getText().toString());
        offer.setyearlyBonus(Double.valueOf(yearlyBonus.getText().toString()));
        offer.setyearlySalary(Double.valueOf(yearlySalary.getText().toString()));

        DAI.addJob(offer);
    }

    private void cancelJobOffers() {
        finish();
    }

    private void saveJobOffers() {
//        System.out.println(title.getText().toString() + company.getText().toString() + city.getText().toString() + state.getText().toString() + costOfLiving.getText().toString() + yearlySalary.getText().toString() + signingBonus.getText().toString() + yearlyBonus.getText().toString() + retirementBonus.getText().toString() + leaveTime.getText().toString());
        if(!validateMandatoryFields()) {
            AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

            DAI DAI = database.AppDatabaseObject();
            JobOffer offer = new JobOffer();
            offer.settitle(title.getText().toString());
            offer.setCity(city.getText().toString());
            offer.setCompany(company.getText().toString());
            offer.setcostOfLiving((Double.valueOf(costOfLiving.getText().toString())));
            offer.setleaveTime(Integer.valueOf(leaveTime.getText().toString()));
            offer.setretiremnetBenifits(Float.valueOf(retirementBonus.getText().toString()));
            offer.setsigningBonus(Double.valueOf(signingBonus.getText().toString()));
            offer.setstate(state.getText().toString());
            offer.setyearlyBonus(Double.valueOf(yearlyBonus.getText().toString()));
            offer.setyearlySalary(Double.valueOf(yearlySalary.getText().toString()));

            DAI.addJob(offer);
            Context context = getApplicationContext();
            CharSequence text = "";
            text = "Job offer for " + title.getText().toString() + " at " + company.getText().toString() + " has been saved!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            //System.out.println(DAI.readCompany());
        }
    }
    
	private boolean validateMandatoryFields(){
        boolean isError = false;
        if( title.getText().toString().trim().equals("")){
            title.setError( "Title is required!" );
            title.setHint("Please enter Title");
            isError = true;
        } if( company.getText().toString().trim().equals("")){
            company.setError( "Company is required!" );
            company.setHint("Please enter Company");
            isError = true;
        }if( city.getText().toString().trim().equals("")){
            city.setError( "City is required!" );
            city.setHint("Please enter City");
            isError = true;
        }if( state.getText().toString().trim().equals("")){
            state.setError( "State is required!" );
            state.setHint("Please enter State");
            isError = true;
        }if( costOfLiving.getText().toString().trim().equals("")){
            costOfLiving.setError( "Cost Of Living is required!" );
            costOfLiving.setHint("Please enter Cost Of Living");
            isError = true;
        }if( yearlySalary.getText().toString().trim().equals("")){
            yearlySalary.setError( "Yearly Salary is required!" );
            yearlySalary.setHint("Please enter Yearly Salary");
            isError = true;
        }if( signingBonus.getText().toString().trim().equals("")){
            signingBonus.setError( "Signing Bonus is required!" );
            signingBonus.setHint("Please enter Signing Bonus");
            isError = true;
        }if( yearlyBonus.getText().toString().trim().equals("")){
            yearlyBonus.setError( "Yearly Bonus is required!" );
            yearlyBonus.setHint("Please enter Yearly Bonus");
            isError = true;
        }if( retirementBonus.getText().toString().trim().equals("")){
            retirementBonus.setError( "Retirement Bonus is required!" );
            retirementBonus.setHint("Please enter Retirement Bonus");
            isError = true;
        }if( leaveTime.getText().toString().trim().equals("")){
            leaveTime.setError( "Leave Time is required!" );
            leaveTime.setHint("Please enter Leave Time");
            isError = true;
        }
        return isError;
    }
}
