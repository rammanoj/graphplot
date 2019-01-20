package com.example.rammanoj.graphplot;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
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

        String[] labels = {"permutations", "combinations", "algebra", "probability", "aptitude", "quants", "helloworld"};
        float[] ranges = {12.34f, 34.56f, 56.56f, 98.43f, 65.21f, 68.43f, 43.43f};
        setInputs(labels, ranges);
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
//        int[] colors = new int[ranges.length];
//        for(int i=0; i<ranges.length; i++) {
//            if(ranges[i] >= 80) {
//                // Bar color: Green
//                colors[i] = Color.GREEN;
//            } else if(ranges[i] <= 30) {
//                // Bar color: Red
//                colors[i] = Color.RED;
//            } else if(ranges[i] >=60 && ranges[i] < 80) {
//                // Bar color: Light Green
//                colors[i] = R.color.LightGreen;
//            } else if(ranges[i] >=40 && ranges[i] < 60) {
//                // Bar color: Yellow
//                colors[i] = Color.YELLOW;
//            } else if(ranges[i] > 30 && ranges[i] < 40 ) {
//                // Bar color: Light read
//                colors[i] = R.color.LightRed;
//            }
//        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "Topics");
//        barDataSet.setColors(colors);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                try {
                    return labels[(int)(value-1)];
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
        xAxis.setLabelCount(3);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(false);
        xAxis.setAxisMinimum(1);
        xAxis.setValueFormatter(formatter);
    }
}
