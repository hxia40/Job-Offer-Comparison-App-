package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public class JobOfferList extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;
    private List<String> jobs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer_list);
        getJobs();
        listView = findViewById(R.id.jobsListView);
        adapter = new ListViewAdapter(jobs, this);
        listView.setAdapter(adapter);
    }

    private void getJobs() {
        String[] items = {"Amazon SDE Seattle", "Amazon SDET Seattle", "Microsoft SE2 Redmond", "Google SE Sunnyvale"};
        for (String item : items) {
            jobs.add(item);
        }
    }
}
