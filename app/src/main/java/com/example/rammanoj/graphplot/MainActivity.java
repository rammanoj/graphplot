package com.example.rammanoj.graphplot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    * labes: String array (topic names, Note::First Topic name has to be empty string)
    * ranges: Float, the performaces of the students in the order of the above array.
    */
    public void setInputs(final String[] labels, float[] ranges)
    {
        barChart = (BarChart) findViewById(R.id.bargraph);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(1000);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);


        // Adding the ranges of the Bar graphs here
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for(int i=0; i<labels.length; i++) {
            float f = (float)(i+1);
            barEntries.add(new BarEntry(f, ranges[i]));
        }
        BarDataSet barDataSet = new BarDataSet(barEntries, "Topics");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                try {
                    return labels[(int)value];
                } catch (Exception e) {
                    return "";
                }
            }
        };

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.9f);
        barChart.setData(barData);


        // Configuring the X-axis here
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(5);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(false);
        xAxis.setAxisMinimum(1);
        xAxis.setValueFormatter(formatter);
    }
}
