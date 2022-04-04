package com.example.employee_directory.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class Employee {

    String full_name;
    String team;
    String biography;
    String photo_url;

    // create a constructor
    public Employee(JSONObject jsonObject) throws JSONException {
        full_name = jsonObject.getString("full_name");
        team = jsonObject.getString("team");
        biography = jsonObject.getString("biography");
        photo_url = jsonObject.getString("photo_url_small");
    }
     // method to iterate through the json array  and construct an Employee for each element in the JSON Array
    public static List<Employee> fromJsonArray (JSONArray employeeJsonArray) throws JSONException {
        List<Employee> employees = new ArrayList<>();
        for(int i=0;i<employeeJsonArray.length();i++){
             employees.add(new Employee(employeeJsonArray.getJSONObject(i)));
        }
        return employees;
    }

    public String getPhoto_url() {
        return String.format(photo_url);
    }

    public String getFull_name() {
        return full_name;
    }

    public String getTeam() {
        return team;
    }

    public String getBiography() {
        return biography;
    }
}
