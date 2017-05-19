package com.example.ccc62.charttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ccc62.charttest.tick.TickManager;
import com.example.ccc62.charttest.tick.TickObject;

public class MainActivity extends AppCompatActivity
{
    private EditText txtMin1;
    private EditText txtMax1;

    private EditText txtMin2;
    private EditText txtMax2;

    private EditText txtMin3;
    private EditText txtMax3;

    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        TickManager.manager().clear();
    }

    private void init()
    {
        initDisplayObject();
        initListener();
    }

    private void initDisplayObject()
    {
        txtMin1 = ( EditText ) findViewById( R.id.txtMin1 );
        txtMax1 = ( EditText ) findViewById( R.id.txtMax1 );

        txtMin2 = ( EditText ) findViewById( R.id.txtMin2 );
        txtMax2 = ( EditText ) findViewById( R.id.txtMax2 );

        txtMin3 = ( EditText ) findViewById( R.id.txtMin3 );
        txtMax3 = ( EditText ) findViewById( R.id.txtMax3 );

        btnNext = ( Button ) findViewById( R.id.btnNext );
    }

    private void initListener()
    {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if( (txtMin1.getText().length() <= 0 || txtMax1.getText().length() <= 0) ||
                        (txtMin2.getText().length() <= 0 || txtMax2.getText().length() <= 0) ||
                        (txtMin3.getText().length() <= 0 || txtMax3.getText().length() <= 0) )
                {
                    Toast.makeText(getApplicationContext(), "최소값과 최대값을 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                TickObject tickObject;

                tickObject = new TickObject( Integer.valueOf( txtMin1.getText().toString() ), Integer.valueOf( txtMax1.getText().toString() ) );
                TickManager.manager().addTickObject( tickObject );
                tickObject = new TickObject( Integer.valueOf( txtMin2.getText().toString() ), Integer.valueOf( txtMax2.getText().toString() ) );
                TickManager.manager().addTickObject( tickObject );
                tickObject = new TickObject( Integer.valueOf( txtMin3.getText().toString() ), Integer.valueOf( txtMax3.getText().toString() ) );
                TickManager.manager().addTickObject( tickObject );

                Intent intent = new Intent(getApplicationContext(), StartActivity.class);

                startActivity( intent );
            }
        });
    }
}
