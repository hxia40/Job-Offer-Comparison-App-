package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    public void JobOffers(View view){
        Intent i = new Intent(getApplicationContext(),JobOffers.class);
        startActivity(i);
    }

    public void CurrentJobDetails(View view){
        Intent i = new Intent(getApplicationContext(),CurrentJobDetails.class);
        startActivity(i);
    }
}
