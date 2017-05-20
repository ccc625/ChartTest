package com.example.ccc62.charttest.infoFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ccc62.charttest.R;

/**
 * Created by ccc62 on 2017-05-20.
 */

public class InfoAllFragment extends Fragment
{
    private ViewGroup rootView;

    public InfoAllFragment()
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
        rootView = ( ViewGroup ) inflater.inflate( R.layout.fragment_info_all, container, false );

        return rootView;
    }
}
