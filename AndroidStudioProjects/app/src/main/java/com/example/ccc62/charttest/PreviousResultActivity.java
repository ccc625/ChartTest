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
import com.example.ccc62.charttest.chartList.ChartListManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PreviousResultActivity extends AppCompatActivity
{
    private ListView chartList;

    private ChartListAdapter chartListAdapter;
    private ArrayList<ChartListData> chartListDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privious_result);

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

        chartListDatas = ChartListManager.manager().getListDatas();

        initDisplayObject();
        initListener();
    }

    private void initDisplayObject()
    {
        chartList = ( ListView ) findViewById( R.id.chartList );
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

    }
}
