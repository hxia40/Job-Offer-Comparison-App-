package edu.gatech.seclass.jobcompare6300;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<String> {
    private List<String> jobs = new ArrayList<>();
    private Context context;

    public ListViewAdapter(List<String> jobs, Context context) {
        super(context,R.layout.item_layout, jobs);
        this.context = context;
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(R.layout.item_layout,parent,false);
        TextView job = row.findViewById(R.id.job);
        job.setText(jobs.get(position));

        return row;
    }
}
