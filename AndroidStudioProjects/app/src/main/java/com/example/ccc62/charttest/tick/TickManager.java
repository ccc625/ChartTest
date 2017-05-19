package com.example.ccc62.charttest.tick;

import java.util.ArrayList;

/**
 * Created by ccc62 on 2017-05-15.
 */

public class TickManager
{
    private static TickManager _manager;

    private ArrayList<TickObject> tickObjects;

    public TickManager( SingleTon singleTon )
    {
        clear();
    }

    public static TickManager manager()
    {
        if( _manager == null )
        {
            _manager = new TickManager( new SingleTon() );
        }

        return _manager;
    }

    public void clear()
    {
        if( tickObjects != null )
        {
            tickObjects.clear();
        }

        tickObjects = new ArrayList<TickObject>();
    }

    public void addTickObject( TickObject object )
    {
        if( tickObjects == null )
            tickObjects = new ArrayList<TickObject>();

        tickObjects.add( object );
    }

    public void removeAtTickObject( int index )
    {
        if( tickObjects == null )
            return;

        tickObjects.remove( index );
    }

    public void removeTickObject( TickObject object )
    {
        if( tickObjects == null )
            return;

        tickObjects.remove( object );
    }

    public void removeAllTickObject()
    {
        if( tickObjects == null )
            return;

        tickObjects.clear();
    }

    public int getTickObjectSize()
    {
        return tickObjects.size();
    }

    public TickObject getObject( int index )
    {
        return tickObjects.get( index );
    }

    private static class SingleTon{}
}
