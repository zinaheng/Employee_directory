package com.example.employee_directory;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.employee_directory.adapters.employeeAdapter;
import com.example.employee_directory.models.Employee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {
    public static final String jsonURL = "https://s3.amazonaws.com/sq-mobile-interview/employees.json";
    public static final String TAG = " MAinActivity";
     SwipeRefreshLayout swipeContainer;
    employeeAdapter adapter;
    List<Employee> employees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rvEmployeeList = findViewById(R.id.rvEmployeeList);
        //created a new list with Dummy data to show the effect of pull to refresh
        employees = new ArrayList<>();
        Employee employee ;
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("full_name", "John Doe");
            jsonObject.put("team", "Team a");
            jsonObject.put("biography", "bio");
            jsonObject.put("photo_url_small", "https://images.pexels.com/photos/11632988/pexels-photo-11632988.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            employee = new Employee(jsonObject);
            employees.add(employee);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //create the adapter
         adapter = new employeeAdapter(this, employees);
        //set the adapter on the recycler view
        rvEmployeeList.setAdapter(adapter);
        //set a layout manager on the recycler view
        rvEmployeeList.setLayoutManager(new LinearLayoutManager(this));

        // Lookup the swipe container view
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.i(TAG, "fetching new data");
                populateMainScreen();

            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }
    // creating new instance of the asyncHttpClient
    AsyncHttpClient client = new AsyncHttpClient();

        private void populateMainScreen () {
            //send a json request
            client.get(jsonURL, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Headers headers, JSON json) {
                    Log.d(TAG, "onSuccess");
                    JSONObject jsonObject = json.jsonObject;
                    try {
                        JSONArray results = jsonObject.getJSONArray("employees");
                        employees.addAll(Employee.fromJsonArray(results));
                        Log.i(TAG, "results" + results.toString());


                        adapter.notifyDataSetChanged();

                        swipeContainer.setRefreshing(false);

                        Log.i(TAG, "employees" + employees.size());
                    } catch (JSONException e) {
                        Log.e(TAG, "Hit json exception", e);
                    }
                }

                @Override
                public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                    Log.d(TAG, "onFailure");
                }
            });
        }

    }

