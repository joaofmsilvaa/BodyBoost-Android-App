package com.example.bodyboost.Report_classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReportViewHolder extends RecyclerView.ViewHolder{

    TextView weightValue;


    public ReportViewHolder(@NonNull View itemView) {
        super(itemView);

        weightValue = itemView.findViewById(R.id.weightValue);


    }
}
