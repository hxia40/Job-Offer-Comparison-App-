package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class JobOffers extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offers);
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

    private void compareJobOffers() {
    }

    private void addJobOffers() {
    }

    private void cancelJobOffers() {
    }

    private void saveJobOffers() {
    }
}
