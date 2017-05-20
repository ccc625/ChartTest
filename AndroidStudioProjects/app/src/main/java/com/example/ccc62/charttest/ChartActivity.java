package com.example.ccc62.charttest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ccc62.charttest.tick.TickManager;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity
{
    private int minValue1;
    private int maxValue1;

    private int minValue2;
    private int maxValue2;

    private int minValue3;
    private int maxValue3;

    private LineChart lineChart1;
    private LineChart lineChart2;
    private LineChart lineChart3;

    private Button btnEnd;

    private ArrayList<String> labels;

    private ArrayList<Entry> line1;
    private ArrayList<Entry> line2;
    private ArrayList<Entry> line3;

    private ArrayList<String> arrLineData1;
    private ArrayList<String> arrLineData2;
    private ArrayList<String> arrLineData3;

    private LineData lineData1;
    private LineData lineData2;
    private LineData lineData3;

    private LineDataSet lineDataSet1;
    private LineDataSet lineDataSet2;
    private LineDataSet lineDataSet3;

    private int index;

    Handler h = new Handler();
    final int delay = 1000; //milliseconds
    private boolean isStop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        init();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    private void init()
    {
        index = 0;

        minValue1 = TickManager.manager().getObject( 0 ).getMin();
        maxValue1 = TickManager.manager().getObject( 0 ).getMax();
        minValue2 = TickManager.manager().getObject( 1 ).getMin();
        maxValue2 = TickManager.manager().getObject( 1 ).getMax();
        minValue3 = TickManager.manager().getObject( 2 ).getMin();
        maxValue3 = TickManager.manager().getObject( 2 ).getMax();

        System.out.println("min1 = " + minValue1 + ", max1 = " + maxValue1);
        System.out.println("min2 = " + minValue2 + ", max2 = " + maxValue2);
        System.out.println("min1 = " + minValue3 + ", max1 = " + maxValue3);

        arrLineData1 = new ArrayList<>();
        arrLineData2 = new ArrayList<>();
        arrLineData3 = new ArrayList<>();

        initDisplayObject();
        initListener();

        setChart();
        setLineData();

        loop();
    }

    private void initDisplayObject()
    {
        lineChart1 = ( LineChart ) findViewById( R.id.lineChart1 );
        lineChart2 = ( LineChart ) findViewById( R.id.lineChart2 );
        lineChart3 = ( LineChart ) findViewById( R.id.lineChart3 );

        btnEnd = ( Button ) findViewById( R.id.btnEnd );
    }

    private void initListener()
    {
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                isStop = true;

                Intent intent = new Intent();
                intent.putExtra( "arrLineData1", arrLineData1);
                intent.putExtra( "arrLineData2", arrLineData2);
                intent.putExtra( "arrLineData3", arrLineData3);

                setResult( Activity.RESULT_OK, intent );
                finish();
            }
        });
    }

    private void setChart()
    {
        if( labels == null )
        {
            labels = new ArrayList<String>();
        }
        else
        {
            labels.clear();
        }

        setChartData();
    }

    private void setChartData()
    {
        if( line1 == null )
        {
            line1 = new ArrayList<Entry>();
        }
        else
        {
            line1.clear();
        }

        if( line2 == null )
        {
            line2 = new ArrayList<Entry>();
        }
        else
        {
            line2.clear();
        }

        if( line3 == null )
        {
            line3 = new ArrayList<Entry>();
        }
        else
        {
            line3.clear();
        }

        lineDataSet1 = new LineDataSet( line1, "test" );
        lineDataSet1.setColor(Color.RED);
        lineDataSet1.setCircleColor(Color.RED);
        lineDataSet1.setDrawCubic(true);
        lineDataSet1.setDrawFilled( false );
        lineDataSet1.setDrawValues( false );

        lineDataSet2 = new LineDataSet( line2, "test" );
        lineDataSet2.setColor(Color.BLUE);
        lineDataSet2.setCircleColor(Color.BLUE);
        lineDataSet2.setDrawCubic(true);
        lineDataSet2.setDrawFilled( false );
        lineDataSet2.setDrawValues( false );

        lineDataSet3 = new LineDataSet( line3, "test" );
        lineDataSet3.setColor(Color.GREEN);
        lineDataSet3.setCircleColor(Color.GREEN);
        lineDataSet3.setDrawCubic(true);
        lineDataSet3.setDrawFilled( false );
        lineDataSet3.setDrawValues( false );

        if( lineData1 != null )
        {
            lineData1.clearValues();
            lineData1 = null;
        }
        lineData1 = new LineData( labels, lineDataSet1);

        if( lineData2 != null )
        {
            lineData2.clearValues();
            lineData2 = null;
        }
        lineData2 = new LineData( labels, lineDataSet2 );

        if( lineData3 != null )
        {
            lineData3.clearValues();
            lineData3 = null;
        }
        lineData3 = new LineData( labels, lineDataSet3 );
    }

    private void drawChart()
    {
        lineData1.notifyDataChanged();
        lineData2.notifyDataChanged();
        lineData3.notifyDataChanged();

        lineChart1.notifyDataSetChanged();
        lineChart1.invalidate();

        lineChart2.notifyDataSetChanged();
        lineChart2.invalidate();

        lineChart3.notifyDataSetChanged();
        lineChart3.invalidate();

    }

    private void setLineData()
    {
        lineChart1.setData( lineData1 );
        lineChart2.setData( lineData2 );
        lineChart3.setData( lineData3 );
    }

    Runnable runnable = new Runnable() {

        @Override
        public void run()
        {
            if( isStop )
                return;

            try
            {
                addValue();
                drawChart();
                System.out.println("tick " + index);
            }
            finally
            {
                h.postDelayed( runnable, delay );
            }
        }
    };

    private void loop()
    {
        isStop = false;
        runnable.run();
    }

    private void addXValue()
    {
        labels.add( "lable" + index );
    }

    private void addEntry()
    {
        double value1 = 0;
        double value2 = 0;
        double value3 = 0;

        value1 = ( Math.random() * ( maxValue1 - minValue1 ) ) + minValue1;
        value2 = ( Math.random() * ( maxValue2 - minValue2 ) ) + minValue2;
        value3 = ( Math.random() * ( maxValue3 - minValue3 ) ) + minValue3;

        System.out.println( "value1 = " + value1 );
        System.out.println( "value2 = " + value2 );
        System.out.println( "value3 = " + value3 );

        arrLineData1.add( String.valueOf( value1 ) );
        arrLineData2.add( String.valueOf( value2 ) );
        arrLineData3.add( String.valueOf( value3 ) );

        lineData1.addEntry( new Entry(Float.valueOf( String.valueOf(value1) ), index), 0 );
        lineData2.addEntry( new Entry(Float.valueOf( String.valueOf(value2) ), index), 0 );
        lineData3.addEntry( new Entry(Float.valueOf( String.valueOf(value3) ), index), 0 );
    }

    private void addValue()
    {
        addXValue();
        addEntry();
        index++;
    }
}
