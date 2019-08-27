package com.laioffer.jobrecommendation;

import org.json.JSONException;
import org.json.JSONObject;

public class Jobs {
    private String company;
    private String location;
    private String title;
    private String company_logo;

    public Jobs(JobsBuilder builder) {
        this.company = builder.company;
        this.location = builder.location;
        this.title = builder.title;
        this.company_logo = builder.company_logo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return company_logo;
    }

    public void setImage(String company_logo) {
        this.company_logo = company_logo;
    }

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        try{
            obj.put("company", company);
            obj.put("location", location);
            obj.put("title", title);
            obj.put("company_logo", company_logo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
    // builder pattern
    public static class JobsBuilder {
        private String company;
        private String location;
        private String title;
        private String company_logo;

        public Jobs build() {
            return new Jobs(this);
        }

        public JobsBuilder setCompany(String company) {
            this.company = company;
            return this;
        }
        public JobsBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        public JobsBuilder setLocation(String location) {
            this.location = location;
            return this;
        }
        public JobsBuilder setImage(String company_logo) {
            this.company_logo = company_logo;
            return this;
        }
    }
}
