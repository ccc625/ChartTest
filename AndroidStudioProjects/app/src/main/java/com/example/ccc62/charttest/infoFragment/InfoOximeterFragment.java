package com.example.ccc62.charttest.infoFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ccc62.charttest.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

/**
 * Created by ccc62 on 2017-05-20.
 */

public class InfoOximeterFragment extends Fragment
{
    private ViewGroup rootView;

    private PieChart infoOximeterPieChart;

    private double aveOxiValue;

    private ArrayList<String> lables;
    private PieDataSet pieDataSet;
    private ArrayList<Entry> entries;

    private PieData pieData;

    public InfoOximeterFragment()
    {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        rootView = ( ViewGroup ) inflater.inflate( R.layout.fragment_info_oximeter, container, false );

        init();

        return rootView;
    }

    public void setData( ArrayList<String> inData )
    {
        if( lables == null )
            lables = new ArrayList<String>();
        lables.clear();

        if( entries == null )
            entries = new ArrayList<Entry>();
        entries.clear();

        double aveValues = 0;

        for( int i = 0; i < inData.size(); i++ )
        {
            aveValues += Double.valueOf( inData.get( i ) );
        }
        aveValues = aveValues / inData.size();

        Entry entry = new Entry( Float.valueOf( Double.toString( aveValues ) ), 0 );
        Entry entry1 = new Entry( Float.valueOf( Double.toString( 100 - aveValues ) ), 1 );
        entries.add( entry );
        entries.add( entry1 );
        lables.add( "1" );
        lables.add( "2" );
    }

    private void init()
    {
        initDisplayObject();

        setPieChart();
    }

    private void initDisplayObject()
    {
        infoOximeterPieChart = ( PieChart ) rootView.findViewById( R.id.infoOximeterPieChart );
    }

    private void setPieChart()
    {
        pieDataSet = new PieDataSet(entries, "평균 산소포화도");
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add( Color.CYAN );
        colors.add( Color.WHITE );
        pieDataSet.setColors( colors );

        pieData = new PieData(lables, pieDataSet);

        drawChart();
    }

    private void drawChart()
    {
        infoOximeterPieChart.setData( pieData );

        infoOximeterPieChart.notifyDataSetChanged();
        infoOximeterPieChart.invalidate();
    }
}
