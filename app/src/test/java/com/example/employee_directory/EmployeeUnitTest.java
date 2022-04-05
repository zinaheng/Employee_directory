package com.example.employee_directory;

import com.example.employee_directory.models.Employee;
import org.junit.Assert;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class EmployeeUnitTest {

    JSONObject jsonObject = new JSONObject();
    Employee employee;

    @Test
    //T test getFullName function
    public void getFullNameTest() throws JSONException {
        initializeEmployee();
        employee = new Employee(jsonObject);

        Assert.assertEquals("John Doe",employee.getFull_name());
        Assert.assertNotEquals("Doe John",employee.getFull_name());

    }
     //To test getPhoto_url function
    public void getPhoto_urlTest() throws JSONException{
        initializeEmployee();
        employee = new Employee(jsonObject);

        Assert.assertEquals("https://images.pexels.com/photos/11632988/pexels-photo-11632988.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",employee.getPhoto_url());
        Assert.assertNotEquals("url",employee.getPhoto_url());
    }
    //To test the getTeam function
    public void getTeamTest() throws JSONException {
        initializeEmployee();
        employee = new Employee(jsonObject);

        Assert.assertEquals("Team a",employee.getTeam());
        Assert.assertNotEquals("45",employee.getTeam());

    }
    //To test the getBiography function
    public void getBiographyTest()throws JSONException {
        initializeEmployee();
        employee = new Employee(jsonObject);

        Assert.assertEquals("Bio",employee.getBiography());
        Assert.assertNotEquals("student",employee.getBiography());

    }

    private void initializeEmployee() throws JSONException {
        jsonObject.put("full_name","John Doe");
        jsonObject.put("team","Team a");
        jsonObject.put("biography","bio");
        jsonObject.put("photo_url_small","url");

    }

}
