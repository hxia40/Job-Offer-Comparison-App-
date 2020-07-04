package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Query;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.DAI;
import edu.gatech.seclass.jobcompare6300.database.JobOffer;

public class CurrentJobDetails extends AppCompatActivity implements View.OnClickListener {
    EditText title, company, city, state, costOfLiving, yearlySalary, signingBonus, yearlyBonus, retirementBonus, leaveTime;
    Button save, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job_details);
        init();

        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        DAI DAI = database.AppDatabaseObject();

        String readCurrentCity = DAI.readCurrentCity();

        String readCurrentcompany = DAI.readCurrentcompany();


        //public Double readCurrentcostOfLiving();


        //public Integer readCurrentleaveTime();


        //public Float readCurrentretirementBonus();


        //public Double readCurrentsigningBonus();


        //public String readCurrentstate();

        //public Double readCurrentyearlyBonus();

        //public Double readCurrentyearlySalary();
        //System.out.println(offers);

        EditText rl = (EditText)findViewById(R.id.txt_current_job_details_title);

        System.out.println(DAI.readCurrentcompany());
        //EditText r2 = (EditText)findViewById(R.id);
        rl.setText(DAI.readCurrentcompany());
        //r2.setText(DAI.readCity());
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
        System.out.println("Reached here");
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                .allowMainThreadQueries()
                .build();

        DAI DAI = database.AppDatabaseObject();
        JobOffer offer = new JobOffer();
        offer.setCity(city.getText().toString());
        offer.setCompany(company.getText().toString());
        offer.setcostOfLiving((Double.valueOf(costOfLiving.getText().toString())));
        offer.setleaveTime(Integer.valueOf(leaveTime.getText().toString()));
        offer.setretiremnetBenifits(Float.valueOf(retirementBonus.getText().toString()));
        offer.setsigningBonus(Double.valueOf(signingBonus.getText().toString()));
        offer.setstate(state.getText().toString());
        offer.setyearlyBonus(Double.valueOf(yearlyBonus.getText().toString()));
        offer.setyearlySalary(Double.valueOf(yearlySalary.getText().toString()));
        offer.setcurrent(true);

        DAI.addJob(offer);

        System.out.println(DAI.readCurrentcompany());
    }
}
