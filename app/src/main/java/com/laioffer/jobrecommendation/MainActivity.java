package com.laioffer.jobrecommendation;

import androidx.appcompat.app.AppCompatActivity;


import android.os.AsyncTask;
import android.widget.ListView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    JobAdapter adapter;
    ListView jobListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml.
        jobListView = (ListView) findViewById(R.id.job_list);
        // Initialize an adapter.
        adapter = new JobAdapter(this);

        new JobAsyncTask().execute( "https://jobs.github.com/positions.json?description=python&location=new+york");

    }


    private class JobAsyncTask extends AsyncTask<String, Void, List<Jobs>> {
        private static final String URL = "https://jobs.github.com/positions.json?description=python&location=new+york";
        @Override
        protected List<Jobs> doInBackground(String... strings) {
            GitHubJobsAPI g1 = new GitHubJobsAPI();
            List<Jobs> result = g1.search(URL);
            return result;
        }

        @Override
        protected void onPostExecute(List<Jobs> jobs) {
            super.onPostExecute(jobs);
            try{
                adapter.jobData.addAll(jobs);
                // Assign adapter to ListView.
                jobListView.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

}


