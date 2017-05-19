package com.example.ccc62.charttest.chartList;

import java.util.ArrayList;

/**
 * Created by ccc62 on 2017-05-19.
 */

public class ChartListData
{
    private long id;
    private String headText;
    private ArrayList<String> lineData1;
    private ArrayList<String> lineData2;
    private ArrayList<String> lineData3;

    public ChartListData()
    {

    }

    public void setHeadText( String value )
    {
        this.headText = value;
    }

    public String getHeadText()
    {
        return this.headText;
    }

    public void setId( long value )
    {
        this.id = value;
    }

    public long getId()
    {
        return this.id;
    }

    public void setLineData1( ArrayList<String> value )
    {
        this.lineData1 = value;
    }

    public ArrayList<String> getLineData1()
    {
        return this.lineData1;
    }

    public void setLineData2( ArrayList<String> value )
    {
        this.lineData2 = value;
    }

    public ArrayList<String> getLineData2()
    {
        return this.lineData2;
    }

    public void setLineData3( ArrayList<String> value )
    {
        this.lineData3 = value;
    }

    public ArrayList<String> getLineData3()
    {
        return this.lineData3;
    }
}
