package com.example.ccc62.charttest.infoFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ccc62.charttest.R;

import java.util.ArrayList;

/**
 * Created by ccc62 on 2017-05-20.
 */

public class InfoPulseFragment extends Fragment
{
    private ViewGroup rootView;

    private TextView txtAvePulse;

    private double avePulse;

    public InfoPulseFragment()
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
        rootView = ( ViewGroup ) inflater.inflate( R.layout.fragment_info_pulse, container, false );

        init();

        return rootView;
    }

    private void init()
    {
        initDisplayObject();
    }

    private void initDisplayObject()
    {
        txtAvePulse = ( TextView ) rootView.findViewById( R.id.txtAvePulse );

        txtAvePulse.setText( "평균 심박수 : " + Double.toString( avePulse ).substring(0, 6) );
    }

    public void setData( ArrayList<String> inData )
    {
        double aveValues = 0;

        for( int i = 0; i < inData.size(); i++ )
        {
            aveValues += Double.valueOf( inData.get( i ) );
        }
        aveValues = aveValues / inData.size();

        avePulse = aveValues;
    }
}
