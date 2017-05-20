package com.example.ccc62.charttest.chartList;

import java.util.ArrayList;

/**
 * Created by ccc62 on 2017-05-21.
 */

public class ChartListManager
{
    private static ChartListManager _manager;

    private ArrayList<ChartListData> chartListDatas;

    public ChartListManager( SingleTon singleton )
    {
        clear();
    }

    public static ChartListManager manager()
    {
        if( _manager == null )
        {
            _manager = new ChartListManager( new SingleTon() );
        }

        return _manager;
    }

    public void clear()
    {
        if( chartListDatas != null )
        {
            chartListDatas.clear();
        }

        chartListDatas = new ArrayList<ChartListData>();
    }

    public void addListData( ChartListData value )
    {
        if( chartListDatas == null )
            chartListDatas = new ArrayList<ChartListData>();

        chartListDatas.add( value );
    }

    public ArrayList<ChartListData> getListDatas()
    {
        return chartListDatas;
    }

    private static class SingleTon{}
}
