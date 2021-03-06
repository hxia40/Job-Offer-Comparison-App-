package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.DAI;

public class JobOfferList extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;
    private List<String> jobs = new ArrayList<>();
    public static List<String> selectedJobs = new ArrayList<>();
    public static boolean isActionMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer_list);
        getJobs();
        listView = findViewById(R.id.jobsListView);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(modeListener);
        adapter = new ListViewAdapter(jobs, this);
        listView.setAdapter(adapter);
        selectedJobs.clear();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_compare:
                compareJobs();
                break;
            case R.id.btn_cancel:
                cancelSelection();
                break;
        }
    }

    private void compareJobs() {

        if (selectedJobs.size() == 2) {
//            text = "Jobs selected: " + selectedJobs.get(0) + " and " + selectedJobs.get(1);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "";
            text = "Select exactly 2 job offers for comparison";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        if (selectedJobs.size() == 2) {
            Intent i = new Intent(getApplicationContext(), JobOfferCompare.class);
            String[] selJobs = selectedJobs.get(0).split(" ");
            i.putExtra("Job1", selJobs[0]);
            String[] selJob2 = selectedJobs.get(1).split(" ");
            i.putExtra("Job2", selJob2[0]);
            startActivity(i);
//            i.putExtra("Job1", selectedJobs.get(0));
//            i.putExtra("Job2", selectedJobs.get(1));
        }
    }

    private void cancelSelection() {
        selectedJobs.clear();
        this.finish();
    }

    private void getJobs() {
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "offers")
                .allowMainThreadQueries()
                .build();

        DAI DAI = database.AppDatabaseObject();
//        Populate jobs ranked by job score
        // Get the jobs from database (weighted and COL adjusted sorted list)
        //String[] items = {"01 Amazon SDE Seattle", "02 Amazon SDET Seattle", "03 Microsoft SE2 Redmond", "04 Google SE Sunnyvale"};


        // I couldn't access them from the weights class
        Weights weights = new Weights();
        SharedPreferences mPreferences = getSharedPreferences(ComparisonSettings.PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();
        weights.yearlySalaryWeight = mPreferences.getInt("ysw", 1);
        weights.signingBonusWeight = mPreferences.getInt("sbw", 1);
        weights.yearlyBonusWeight = mPreferences.getInt("ybw", 1);
        weights.retirementBenefitsWeight = mPreferences.getInt("rbw", 1);
        weights.leaveTimeWeight = mPreferences.getInt("ltw", 1);
        //

        int sum = weights.yearlySalaryWeight + weights.signingBonusWeight + weights.yearlyBonusWeight + weights.retirementBenefitsWeight + weights.leaveTimeWeight;

//        String[] company = DAI.readCompany(weights.yearlySalaryWeight,weights.signingBonusWeight,weights.yearlyBonusWeight,weights.retirementBenefitsWeight,weights.leaveTimeWeight,sum);
//        String[] title = DAI.readTitle(weights.yearlySalaryWeight,weights.signingBonusWeight,weights.yearlyBonusWeight,weights.retirementBenefitsWeight,weights.leaveTimeWeight,sum);
//        String[] city = DAI.readCity(weights.yearlySalaryWeight,weights.signingBonusWeight,weights.yearlyBonusWeight,weights.retirementBenefitsWeight,weights.leaveTimeWeight,sum);
//        String[] current = DAI.readCurrentInd();
//        int size = DAI.readsize();
//        String[] items = new String[size];
//
//
//        for(int i=0; i < size; i++){
//
//            items[i] = i + " " + company[i] + " " + title[i] + " " + city[i] + " " + current[i];
//        }

        int size = DAI.readsize();
        String[] items = new String[size];

        int[] jobOffers = DAI.readOffer(weights.yearlySalaryWeight,weights.signingBonusWeight,weights.yearlyBonusWeight,weights.retirementBenefitsWeight,weights.leaveTimeWeight,sum);
        int currentId = DAI.getCurrentJobId();
        for (int i=0; i< size; i++) {
            if (jobOffers[i] == currentId){
                items[i] = jobOffers[i] + " " + DAI.getTitleById(jobOffers[i]) + " " + DAI.getCompanyById(jobOffers[i]) + " " + DAI.getCityById(jobOffers[i]) + " (Current Job)";
            }
            else{
                items[i] = jobOffers[i] + " " + DAI.getTitleById(jobOffers[i]) + " " + DAI.getCompanyById(jobOffers[i]) + " " + DAI.getCityById(jobOffers[i]);
            }
        }

        for (String item : items) {
            jobs.add(item);
        }
    }

    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            isActionMode = true;
            return false;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            isActionMode = false;
            selectedJobs.clear();
        }
    };
}
