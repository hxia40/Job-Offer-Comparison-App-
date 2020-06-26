package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class CurrentJobDetails extends AppCompatActivity implements View.OnClickListener {

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

    private void cancelCurrentJobDetails() {
    }

    private void saveCurrentJobDetails() {
    }
}
