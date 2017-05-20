package com.example.ccc62.charttest.chartList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ccc62.charttest.InfoActivity;
import com.example.ccc62.charttest.OutputActivity;
import com.example.ccc62.charttest.R;

import java.util.ArrayList;

/**
 * Created by ccc62 on 2017-05-19.
 */

public class ChartListItem extends LinearLayout
{
    private Context mContext;
    private ChartListData data;

    private LinearLayout rootLayout;
    private TextView txtChartHead;
    private Button btnInfo;

    public ChartListItem( Context context )
    {
        super(context);

        mContext = context;
        init();
    }

    private void init()
    {
        initDisplayObject();
        initListener();
    }

    private void initDisplayObject()
    {
        LayoutInflater inflater = ( LayoutInflater ) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        rootLayout = ( LinearLayout ) inflater.inflate( R.layout.chart_listitem, this, true );

        txtChartHead = ( TextView ) rootLayout.findViewById( R.id.txtChartHead );
        btnInfo = ( Button ) rootLayout.findViewById( R.id.btnInfo );
    }

    private void initListener()
    {
        btnInfo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent( mContext, InfoActivity.class);
                intent.putExtra( "arrLineData1", ( ArrayList<String> ) data.getLineData1().clone() );
                intent.putExtra( "arrLineData2", ( ArrayList<String> ) data.getLineData2().clone() );
                intent.putExtra( "arrLineData3", ( ArrayList<String> ) data.getLineData3().clone() );

                mContext.startActivity( intent );
            }
        });
    }

    public void setData( ChartListData data )
    {
        this.data = data;
        txtChartHead.setText( this.data.getHeadText() );
    }
}
