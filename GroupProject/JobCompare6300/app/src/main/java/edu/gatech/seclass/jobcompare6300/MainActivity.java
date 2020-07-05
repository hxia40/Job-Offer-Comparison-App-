package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.DAI;
import edu.gatech.seclass.jobcompare6300.database.JobOffer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ComparisonSettings(View view){
        Intent i = new Intent(getApplicationContext(),ComparisonSettings.class);
        startActivity(i);
    }

    public void Nuke(View view){
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                .allowMainThreadQueries()
                .build();
        DAI DAI = database.AppDatabaseObject();
        DAI.Nuke();
    }


    public void JobOffers(View view){
        Intent i = new Intent(getApplicationContext(),JobOffers.class);
        startActivity(i);
    }

    public void CompareJobOffers(View view){
        Intent i = new Intent(getApplicationContext(),JobOfferList.class);
        startActivity(i);
    }


    public void CurrentJobDetails(View view){
        Intent i = new Intent(getApplicationContext(),CurrentJobDetails.class);
        startActivity(i);
    }

    public void JobOffersListDisplay(View view){
        Intent i = new Intent(getApplicationContext(),JobOffersListDisplay.class);
        startActivity(i);
    }

 }
