package com.example.ccc62.charttest.tick;

/**
 * Created by ccc62 on 2017-05-19.
 */

public class TickObject
{
    private int min;
    private int max;

    public TickObject( int min, int max )
    {
        this.min = min;
        this.max = max;
    }

    public void setMin( int value )
    {
        this.min = value;
    }

    public void setMax( int value )
    {
        this.max = value;
    }

    public int getMin()
    {
        return this.min;
    }

    public int getMax()
    {
        return this.max;
    }
}
