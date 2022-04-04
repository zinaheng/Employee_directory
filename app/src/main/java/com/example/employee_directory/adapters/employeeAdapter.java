package com.example.employee_directory.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.employee_directory.R;
import com.example.employee_directory.models.Employee;

import java.util.List;

public class employeeAdapter extends RecyclerView.Adapter<employeeAdapter.ViewHolder> {

    Context context;
    List<Employee> employees;

    public employeeAdapter(Context context, List<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    //inflates a layout from XML and returns the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("employeeAdapter", "onCreateViewHolder");
        View employeeView = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(employeeView);
    }

    //populate the data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("employeeAdapter", "onBindViewHolder " + position);
        //get the employee position
        Employee employee = employees.get(position);
        // bind the employee data into the view holder
        holder.bind(employee);
    }

    // returns the total count of the items in the list
    @Override
    public int getItemCount() {
        return employees.size();
    }

    // Clear all elements in the recycler
    public void clear() {
        employees.clear();
        notifyDataSetChanged();
    }

        public void addAll (List < Employee > employees) {
            employees.addAll(employees);
            notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvName, tvTeam, tvSummary;
            ImageView ivImage;

            // constructor
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvName = itemView.findViewById(R.id.tvName);
                tvTeam = itemView.findViewById(R.id.tvTeam);
                tvSummary = itemView.findViewById(R.id.tvSummary);
                ivImage = itemView.findViewById(R.id.ivImage);
            }

            public void bind(Employee employee) {
                tvName.setText(employee.getFull_name());
                tvTeam.setText(employee.getTeam());
                tvSummary.setText(employee.getBiography());
                Glide.with(context).load(employee.getPhoto_url()).into(ivImage);
            }
        }
    }


