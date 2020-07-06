package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Query;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.HashMap;
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



//        String readCurrentCity = DAI.readCurrentCity();
//
//        String readCurrentcompany = DAI.readCurrentcompany();


        //public Double readCurrentcostOfLiving();


        //public Integer readCurrentleaveTime();


        //public Float readCurrentretirementBonus();


        //public Double readCurrentsigningBonus();


        //public String readCurrentstate();

        //public Double readCurrentyearlyBonus();

        //public Double readCurrentyearlySalary();
        //System.out.println(offers);

        EditText r1 = (EditText)findViewById(R.id.txt_current_job_details_title);
//        r1.setText(DAI.readCurrentTitle());
        EditText r2 = (EditText)findViewById(R.id.txt_current_job_details_company);
//        r2.setText(DAI.readCurrentcompany());
        EditText r3 = (EditText)findViewById(R.id.txt_current_job_details_city);
//        r3.setText(DAI.readCurrentCity());
        EditText r4 = (EditText)findViewById(R.id.txt_current_job_details_state);
//        r4.setText(DAI.readCurrentstate());
        EditText r5 = (EditText)findViewById(R.id.txt_current_job_details_yearly_salary);
//        r5.setText(DAI.readCurrentyearlySalary().toString());
        EditText r6 = (EditText)findViewById(R.id.txt_current_job_details_signing_bonus);
//        r6.setText(DAI.readCurrentsigningBonus().toString());
        EditText r7 = (EditText)findViewById(R.id.txt_current_job_details_yearly_bonus);
//        r7.setText(DAI.readCurrentyearlyBonus().toString());
        EditText r8 = (EditText)findViewById(R.id.txt_current_job_details_retirement_bonus);
//        r8.setText(DAI.readCurrentretirementBonus().toString());
        EditText r9 = (EditText)findViewById(R.id.txt_current_job_details_leave_time);
//        r9.setText(DAI.readCurrentleaveTime().toString());
        EditText r10 = (EditText)findViewById(R.id.txt_current_job_details_costofliving);
//        r10.setText(DAI.readCurrentcostOfLiving().toString());

        int job1Id = DAI.getCurrentJobId();
        if (job1Id > 0) {
            r1.setText(DAI.getTitleById(job1Id));
            r2.setText(DAI.getCompanyById(job1Id));
            r3.setText(DAI.getCityById(job1Id));
            r4.setText(DAI.getStateById(job1Id));
            r10.setText(Double.toString(DAI.getCOLById(job1Id)));
            r5.setText(Double.toString(DAI.getSalaryById(job1Id)));
            r6.setText(Double.toString(DAI.getSigningById(job1Id)));
            r7.setText(Double.toString(DAI.getBonusById(job1Id)));
            r8.setText(Double.toString(DAI.getRetirementById(job1Id)));
            r9.setText(Integer.toString(DAI.getLeaveById(job1Id)));

        }
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
        finish();
    }

    private void saveCurrentJobDetails() {

        costOfLiving.setText(Double.toString(getCostOfLiving(city.getText().toString(), state.getText().toString())));

        if(!validateMandatoryFields()) {
            AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                    .allowMainThreadQueries()
                    .build();

            DAI DAI = database.AppDatabaseObject();
            //DAI.DeleteCurrent();
            if(DAI.currentJobCount() == 0) {
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
                offer.setcurrent(1);

                DAI.addJob(offer);
            }
            else {
                DAI.updateCurrentJob(title.getText().toString(), city.getText().toString(), company.getText().toString(), Double.valueOf(costOfLiving.getText().toString()), Integer.valueOf(leaveTime.getText().toString()), Float.valueOf(retirementBonus.getText().toString()), Double.valueOf(signingBonus.getText().toString()), state.getText().toString(), Double.valueOf(yearlyBonus.getText().toString()), Double.valueOf(yearlySalary.getText().toString()));
            }
            System.out.println(DAI.readCurrentcompany());

            Context context = getApplicationContext();
            CharSequence text = "";
            text = "Current job " + title.getText().toString() + " at " + company.getText().toString() + " has been saved!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
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

    public double getCostOfLiving(String city, String state){
        double col = 0;
        String temp = "";
        HashMap<String, Integer> COL_MAP = new HashMap<>();
        COL_MAP.put("Anchorage,AL", 186);
        COL_MAP.put("Phoenix,AZ", 166);
        COL_MAP.put("Tucson,AZ", 144);
        COL_MAP.put("Mountain View,CA", 262);
        COL_MAP.put("San Francisco,CA", 251);
        COL_MAP.put("Oakland,CA", 222);
        COL_MAP.put("Los Angeles,CA", 210);
        COL_MAP.put("San Jose,CA", 198);
        COL_MAP.put("San Diego,CA", 188);
        COL_MAP.put("Sacramento,CA", 187);
        COL_MAP.put("Riverside,CA", 156);
        COL_MAP.put("Denver,CO", 195);
        COL_MAP.put("Colorado Springs,CO", 155);
        COL_MAP.put("Washington,DC", 225);
        COL_MAP.put("Miami,FL", 201);
        COL_MAP.put("Orlando,FL", 169);
        COL_MAP.put("Tampa,FL", 163);
        COL_MAP.put("Jacksonville,FL", 146);
        COL_MAP.put("Atlanta,GA", 163);
        COL_MAP.put("Honolulu,HI", 203);
        COL_MAP.put("Boise,ID", 142);
        COL_MAP.put("Chicago,IL", 200);
        COL_MAP.put("Indianapolis,IN", 151);
        COL_MAP.put("Louisville,KY", 143);
        COL_MAP.put("New Orleans,LA", 156);
        COL_MAP.put("Boston,MA", 214);
        COL_MAP.put("Baltimore,MD", 164);
        COL_MAP.put("Detroit,MI", 150);
        COL_MAP.put("Minneapolis,MN", 171);
        COL_MAP.put("St. Louis,MO", 152);
        COL_MAP.put("Kansas City,MO", 144);
        COL_MAP.put("Charlotte,NC", 168);
        COL_MAP.put("Raleigh,NC", 154);
        COL_MAP.put("Omaha,NE", 142);
        COL_MAP.put("Jersey City,NJ", 235);
        COL_MAP.put("Albuquerque,NM", 133);
        COL_MAP.put("Las Vegas,NV", 160);
        COL_MAP.put("New York,NY", 260);
        COL_MAP.put("Cleveland,OH", 155);
        COL_MAP.put("Cincinnati,OH", 140);
        COL_MAP.put("Portland,OR", 189);
        COL_MAP.put("Philadelphia,PA", 179);
        COL_MAP.put("Pittsburg,PA", 171);
        COL_MAP.put("Providence,RI", 161);
        COL_MAP.put("Charleston,SC", 163);
        COL_MAP.put("Nashville,TN", 158);
        COL_MAP.put("Memphis,TN", 130);
        COL_MAP.put("Austin,TX", 171);
        COL_MAP.put("Fort Worth,TX", 167);
        COL_MAP.put("Dallas,TX", 162);
        COL_MAP.put("Houston,TX", 152);
        COL_MAP.put("San Antonio,TX", 144);
        COL_MAP.put("Salt Lake City,UT", 168);
        COL_MAP.put("Burlington,VT", 166);
        COL_MAP.put("Seattle,WA", 205);
        COL_MAP.put("Spokane,WA", 151);
        COL_MAP.put("Milwaukee,WI", 149);

        temp = city + "," + state;

        if (COL_MAP.get(temp) == null) {col = 200;}
        else {col = COL_MAP.get(temp);}
//        System.out.println("colllll:"+ col);
        return col;
    }

}
