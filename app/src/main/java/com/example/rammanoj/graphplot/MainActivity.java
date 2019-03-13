package com.example.rammanoj.graphplot;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] labels = {"Score"};
        float[] ranges = {12.34f, 34.56f, 56.56f, 98.43f, 65.21f, 68.43f, 43.43f};
        String topic = "TOpic 1";
        setInputs(labels, ranges, topic);
    }
    /*
    * labes: String array (topic names, Note::First Topic name has to be empty string)
    * ranges: Float, the performaces of the students in the order of the above array.
    */
    public void setInputs(final String[] labels, float[] ranges, String topic)
    {

        pieChart = (PieChart) findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setCenterText(topic);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setDrawEntryLabels(false);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yvalues = new ArrayList<>();
        for(int i=0; i<labels.length; i++) {
            yvalues.add(new PieEntry(ranges[i], labels[i]));
        }

        PieDataSet dataSet = new PieDataSet(yvalues, "Topics");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.WHITE);


        pieChart.setData(data);
    }
}
