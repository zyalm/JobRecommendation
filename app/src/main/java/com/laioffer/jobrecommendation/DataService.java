package com.laioffer.jobrecommendation;

import java.util.List;

public class DataService {
    public static List<Jobs> getJobsData() {
        List<Jobs> jobs;
        GitHubJobsAPI g = new GitHubJobsAPI();
        jobs = g.search("https://jobs.github.com/positions.json?description=python&location=new+york");
        for(int i = 0; i < jobs.size(); i++) {
            Jobs.JobsBuilder builder = new Jobs.JobsBuilder();
            builder.setCompany(jobs.get(i).getCompany());
            builder.setLocation(jobs.get(i).getLocation());
            builder.setTitle(jobs.get(i).getTitle());
        }
        return jobs;
    }
}
