package com.example.ccc62.charttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ccc62.charttest.infoFragment.InfoAllFragment;
import com.example.ccc62.charttest.infoFragment.InfoBreathFragment;
import com.example.ccc62.charttest.infoFragment.InfoOximeterFragment;
import com.example.ccc62.charttest.infoFragment.InfoPulseFragment;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity
{
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private LinearLayout fragmentContainer;

    private InfoBreathFragment infoBreathFragment;
    private InfoPulseFragment infoPulseFragment;
    private InfoOximeterFragment infoOximeterFragment;
    private InfoAllFragment infoAllFragment;
    private Fragment currentFragment;

    private Button btnInfoBreath;
    private Button btnInfoPulse;
    private Button btnInfoOximiter;

    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        init();
    }

    private void init()
    {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        initDisplayObject();
        initListener();
        setData();

        setFragmentContent(infoBreathFragment);
    }

    private void setFragmentContent( Fragment fragment )
    {
        if( currentFragment != null && ( currentFragment.getId() == fragment.getId() ) )
            return;

        fragmentTransaction.replace( fragmentContainer.getId(), fragment );
        fragmentTransaction.commit();
    }

    private void initDisplayObject()
    {
        btnInfoBreath = ( Button ) findViewById( R.id.btnInfoBreath );
        btnInfoPulse = ( Button ) findViewById( R.id.btnInfoPulse );
        btnInfoOximiter = ( Button ) findViewById( R.id.btnInfoOximiter );

        fragmentContainer = ( LinearLayout ) findViewById( R.id.fragmentContainer );

        infoBreathFragment = new InfoBreathFragment();
        infoPulseFragment = new InfoPulseFragment();
        infoOximeterFragment = new InfoOximeterFragment();
        infoAllFragment = new InfoAllFragment();
    }

    private void initListener()
    {
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if( view.getId() == btnInfoBreath.getId() )
                {
                    setFragmentContent( infoBreathFragment );
                }
                else if( view.getId() == btnInfoPulse.getId() )
                {
                    setFragmentContent( infoPulseFragment );
                }
                else if( view.getId() == btnInfoOximiter.getId() )
                {
                    setFragmentContent( infoOximeterFragment );
                }
            }
        };

        btnInfoBreath.setOnClickListener( onClickListener );
        btnInfoOximiter.setOnClickListener( onClickListener );
        btnInfoPulse.setOnClickListener( onClickListener );
    }

    private void setData()
    {
        ArrayList<String> lineData1 = getIntent().getStringArrayListExtra( "arrLineData1" );
        ArrayList<String> lineData2 = getIntent().getStringArrayListExtra( "arrLineData2" );
        ArrayList<String> lineData3 = getIntent().getStringArrayListExtra( "arrLineData3" );

        infoBreathFragment.setData( lineData1 );
    }
}
