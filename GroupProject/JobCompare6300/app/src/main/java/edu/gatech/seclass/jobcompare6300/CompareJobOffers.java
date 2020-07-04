package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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

public class CompareJobOffers extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_job_offer);

        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                .allowMainThreadQueries()
                .build();

        DAI DAI = database.AppDatabaseObject();
        JobOffer offer = new JobOffer();
        offer.setCity("test_city");
        offer.setCompany("test_company");

        DAI.addJob(offer);
        List<String> offers = DAI.readJob();
        System.out.println(offers);

        EditText rl = (EditText)findViewById(R.id.editText2);
        EditText r2 = (EditText)findViewById(R.id.editText3);
        //rl.setText(DAI.readCompany());
        //r2.setText(DAI.readCity());



    }
}
