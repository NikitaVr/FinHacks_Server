package com.example.angeloaustria.uidesignlendr;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;


public class OneFragment extends Fragment{

    private PieChart mChart;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_one, container, false);

        TextView textview=(TextView)view.findViewById(R.id.balanceLabel);
        textview.setText("Current Balance");

        mChart = (PieChart) view.findViewById(R.id.pieChart1);
        mChart.getDescription().setEnabled(false);
        mChart.getLegend().setEnabled(false);

        // radius of the center hole in percent of maximum radius
        mChart.setHoleRadius(35f);
        mChart.setTransparentCircleRadius(40f);


        mChart.setData(generatePieData());

        return view;
    }

    private PieData generatePieData() {

        ArrayList<PieEntry> entries1 = new ArrayList<>();

        entries1.add(new PieEntry((float) 195, "Good Karma"));
        entries1.add(new PieEntry((float) 160, "Bad Karma"));

        PieDataSet ds1 = new PieDataSet(entries1, "Karma");
        ds1.setColors(new int[] { Color.parseColor("#66BB6A"), Color.parseColor("#EF5350") });
        ds1.setSliceSpace(2f);
        ds1.setValueTextColor(Color.WHITE);
        ds1.setValueTextSize(12f);

        PieData d = new PieData(ds1);

        return d;
    }

}