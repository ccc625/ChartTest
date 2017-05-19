package com.example.ccc62.charttest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ccc62.charttest.chartList.ChartListAdapter;
import com.example.ccc62.charttest.chartList.ChartListData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

public class StartActivity extends AppCompatActivity
{
    private static final int CHART_ACTIVITY = 101;

    private ListView chartList;
    private Button btnStart;

    private ChartListAdapter chartListAdapter;
    private ArrayList<ChartListData> chartListDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        init();
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        setChartList();
    }

    private void init()
    {
        chartListAdapter = new ChartListAdapter( this );

        initDisplayObject();
        initListener();
    }

    private void initDisplayObject()
    {
        chartList = ( ListView ) findViewById( R.id.chartList );
        btnStart = ( Button ) findViewById( R.id.btnStart );
    }

    private void setChartList()
    {
        if( chartListDatas == null )
            chartListDatas = new ArrayList<ChartListData>();

        chartListAdapter.setChartListDatas( ( ArrayList<ChartListData> ) chartListDatas.clone() );
        chartList.setAdapter( chartListAdapter );
    }

    private void initListener()
    {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent( getApplicationContext(), ChartActivity.class );
                startActivityForResult( intent, CHART_ACTIVITY );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == CHART_ACTIVITY )
        {
            if( resultCode == Activity.RESULT_OK )
            {
                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String formatDate = sdfNow.format(date);

                ArrayList<String> lineData1 = data.getStringArrayListExtra( "arrLineData1" );
                ArrayList<String> lineData2 = data.getStringArrayListExtra( "arrLineData2" );
                ArrayList<String> lineData3 = data.getStringArrayListExtra( "arrLineData3" );

                ChartListData chartListData = new ChartListData();
                chartListData.setHeadText( formatDate );
                chartListData.setLineData1( lineData1 );
                chartListData.setLineData2( lineData2 );
                chartListData.setLineData3( lineData3 );

                chartListDatas.add( chartListData );

                setChartList();
            }
        }
    }
}
