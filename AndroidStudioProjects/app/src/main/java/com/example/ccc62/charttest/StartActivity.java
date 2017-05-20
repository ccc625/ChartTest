package com.example.ccc62.charttest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ccc62.charttest.chartList.ChartListData;
import com.example.ccc62.charttest.chartList.ChartListManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StartActivity extends AppCompatActivity
{
    private static final int CHART_ACTIVITY = 101;

    private Button btnStart;
    private Button btnPreviousResult;
    private Button btnInfoAll;

    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        init();
    }

    private void init()
    {
        initDisplayObject();
        initListener();
    }

    private void initDisplayObject()
    {
        btnStart = ( Button ) findViewById( R.id.btnStart );
        btnPreviousResult = ( Button ) findViewById( R.id.btnPreviousResult );
        btnInfoAll = ( Button ) findViewById( R.id.btnInfoAll );
    }

    private void initListener()
    {
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (view.getId() == btnStart.getId())
                {
                    Intent intent = new Intent(getApplicationContext(), ChartActivity.class);
                    startActivityForResult(intent, CHART_ACTIVITY);
                }
                else if (view.getId() == btnPreviousResult.getId())
                {
                    Intent intent = new Intent(getApplicationContext(), PreviousResultActivity.class);
                    startActivity( intent );
                }
                else if (view.getId() == btnInfoAll.getId())
                {

                }
            }
        };

        btnStart.setOnClickListener( onClickListener );
        btnPreviousResult.setOnClickListener( onClickListener );
        btnInfoAll.setOnClickListener( onClickListener );
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

                ChartListManager.manager().addListData( chartListData );
            }
        }
    }
}
