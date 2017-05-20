package com.example.ccc62.charttest.infoFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ccc62.charttest.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 * Created by ccc62 on 2017-05-20.
 */

public class InfoBreathFragment extends Fragment
{
    private ViewGroup rootView;

    private LineChart infoBreathLineChart;

    private ArrayList<String> lables;

    private LineDataSet baseLineDataSet;
    private ArrayList<LineDataSet> lowerLineDataSets;

    private ArrayList<Entry> baseEntries;
    private ArrayList<ArrayList<Entry>> lowerEntriesArray;

    private LineData lineData;

    public InfoBreathFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = ( ViewGroup ) inflater.inflate( R.layout.fragment_info_breath, container, false );

        init();

        return rootView;
    }

    public void setData( ArrayList<String> inData )
    {
        if( lables == null )
            lables = new ArrayList<String>();
        lables.clear();

        if( baseEntries == null )
            baseEntries = new ArrayList<Entry>();
        baseEntries.clear();

        if( lowerEntriesArray == null )
            lowerEntriesArray = new ArrayList<ArrayList<Entry>>();
        lowerEntriesArray.clear();

        Float value;
        Entry entry;
        ArrayList<Entry> lowerDataArray = new ArrayList<Entry>();
        for( int i = 0; i < inData.size(); i++ )
        {
            lables.add( Integer.toString( i ) );

            value = Float.valueOf( inData.get(i) );
            entry = new Entry( 1, i );

            baseEntries.add( entry );

            if( value <= 1500 )
            {
                if( lowerDataArray.size() != 0 )
                {
                    int prevIndex = lowerDataArray.get( lowerDataArray.size() - 1 ).getXIndex();
                    if( i - prevIndex > 1 )
                    {
                        lowerEntriesArray.add( lowerDataArray );

                        lowerDataArray = new ArrayList<Entry>();
                    }
                }

                lowerDataArray.add( entry );
            }
        }
        entry = null;
        lowerDataArray = null;
    }

    private void init()
    {
        initDisplayObject();
        initListener();

        setLineChart();
    }

    private void initDisplayObject()
    {
        infoBreathLineChart = ( LineChart ) rootView.findViewById( R.id.infoBreathLineChart );
    }

    private void initListener()
    {

    }

    private void setLineChart()
    {
        baseLineDataSet = new LineDataSet( baseEntries, "호흡" );
        baseLineDataSet.setColor( Color.GREEN );
        baseLineDataSet.setFillColor( Color.GREEN );
        baseLineDataSet.setDrawCircles( false );
        baseLineDataSet.setDrawFilled( true );

        lowerLineDataSets = new ArrayList<LineDataSet>();
        LineDataSet lowerLineDataSet;
        ArrayList<Entry> lowerEntries;
        for( int i = 0; i < lowerEntriesArray.size(); i++ )
        {
            lowerEntries = lowerEntriesArray.get(i);

            if( lowerEntries.size() <= 1 )
                continue;

            lowerLineDataSet = new LineDataSet( lowerEntries, Integer.toString( lowerEntries.get(0).getXIndex() ) );
            lowerLineDataSet.setColor( Color.RED );
            lowerLineDataSet.setFillColor( Color.RED );
            lowerLineDataSet.setDrawCircles( false );
            lowerLineDataSet.setDrawFilled( true );

            lowerLineDataSets.add( lowerLineDataSet );
        }

        lineData = new LineData( lables );
        lineData.addDataSet( baseLineDataSet );
        for( int i = 0; i < lowerLineDataSets.size(); i++ )
        {
            lineData.addDataSet( lowerLineDataSets.get(i) );
        }

        drawChart();
    }

    private void drawChart()
    {
        infoBreathLineChart.setData( lineData );
        infoBreathLineChart.setMaxVisibleValueCount( 0 );

        infoBreathLineChart.notifyDataSetChanged();
        infoBreathLineChart.invalidate();
    }
}
