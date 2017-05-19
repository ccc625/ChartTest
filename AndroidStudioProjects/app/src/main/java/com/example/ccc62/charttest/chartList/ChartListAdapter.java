package com.example.ccc62.charttest.chartList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by ccc62 on 2017-05-19.
 */

public class ChartListAdapter extends BaseAdapter
{
    private Context mContext;
    private ArrayList<ChartListData> chartListDatas;

    public ChartListAdapter( Context context )
    {
        mContext = context;
    }

    public void setChartListDatas( ArrayList<ChartListData> datas )
    {
        chartListDatas = datas;
    }

    @Override
    public int getCount()
    {
        return chartListDatas.size();
    }

    @Override
    public Object getItem(int position)
    {
        return chartListDatas.get( position );
    }

    @Override
    public long getItemId(int position)
    {
        return chartListDatas.get( position ).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ChartListItem item;
        if( convertView == null )
        {
            item = new ChartListItem( mContext );
        }
        else
        {
            item = ( ChartListItem ) convertView;
        }

        item.setData( chartListDatas.get( position ) );

        return item;
    }
}
