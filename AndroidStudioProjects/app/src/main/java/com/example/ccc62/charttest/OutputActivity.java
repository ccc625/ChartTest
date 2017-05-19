package com.example.ccc62.charttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class OutputActivity extends AppCompatActivity
{
    private TextView txtLineData1;
    private TextView txtLineData2;
    private TextView txtLineData3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        init();

        setText();
    }

    private void init()
    {
        initDisplayObject();
    }

    private void initDisplayObject()
    {
        txtLineData1 = ( TextView ) findViewById( R.id.txtLineData1 );
        txtLineData2 = ( TextView ) findViewById( R.id.txtLineData2 );
        txtLineData3 = ( TextView ) findViewById( R.id.txtLineData3 );
    }

    private void setText()
    {
        ArrayList<String> lineData1 = getIntent().getStringArrayListExtra( "arrLineData1" );
        ArrayList<String> lineData2 = getIntent().getStringArrayListExtra( "arrLineData2" );
        ArrayList<String> lineData3 = getIntent().getStringArrayListExtra( "arrLineData3" );

        double aveLineData1 = 0;
        double aveLineData2 = 0;
        double aveLineData3 = 0;

        for( int i = 0; i < lineData1.size(); i++ )
        {
            aveLineData1 += Double.valueOf( lineData1.get( i ) );
        }
        aveLineData1 = aveLineData1 / lineData1.size();

        for( int i = 0; i < lineData2.size(); i++ )
        {
            aveLineData2 += Double.valueOf( lineData2.get( i ) );
        }
        aveLineData2 = aveLineData2 / lineData2.size();

        for( int i = 0; i < lineData3.size(); i++ )
        {
            aveLineData3 += Double.valueOf( lineData3.get( i ) );
        }
        aveLineData3 = aveLineData3 / lineData3.size();

        txtLineData1.setText( String.valueOf( aveLineData1 ).substring(0, 6) );
        txtLineData2.setText( String.valueOf( aveLineData2 ).substring(0, 6) );
        txtLineData3.setText( String.valueOf( aveLineData3 ).substring(0, 6) );
    }
}
