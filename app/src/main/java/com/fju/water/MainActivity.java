package com.fju.water;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="TAG" ;
    private EditText months;
    private EditText nexts;
    boolean isNext =false;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestory");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        months =findViewById(R.id.month);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        Switch sw=findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext=isChecked;
                TextView text=findViewById(R.id.type);
                text.setText(isNext?getText(R.string.every_other_monthly):getText(R.string.monthly));
            }
        });
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String monthString =months.getText().toString();
                if(!TextUtils.isEmpty(monthString)){
                    float degree=Float.parseFloat(monthString);
                    float fee =0f;
                    if (degree>=1&&degree<=10) {
                        fee =degree*7.35f;
                    }
                    else if(degree>=11&&degree<=30){
                        fee =degree*9.45f-21;
                    }
                    else if(degree>=31&&degree<=50){
                        fee =degree*11.55f-84;
                    }
                    else if(degree>=51){
                        fee =degree*12.075f-110.25f;
                    }
                    Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra(getString(R.string.extra_fee),fee);
                    startActivity(intent);
                    // new AlertDialog.Builder(MainActivity.this)
                     //       .setTitle("每月抄表費用")
                       //     .setMessage(getString(R.string.fee)+ fee)
                       //     .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        //        @Override
                       //          public void onClick(DialogInterface dialog, int which) {
                       //              months.setText("");
                       //                nexts.setText("");
                       //          }
                       //      })
                       //     .show();
                }
                else{
                    String nextString=nexts.getText().toString();
                    if (!TextUtils.isEmpty(nextString)){
                        float degree=Float.parseFloat(nextString);
                        float fee =0f;
                        if (degree>=1&&degree<=20) {
                            fee =degree*7.35f;
                        }
                        else if(degree>=21&&degree<=60){
                            fee =degree*9.45f-42;
                        }
                        else if(degree>=61&&degree<=100){
                            fee =degree*11.55f-168;
                        }
                        else if(degree>=101){
                            fee =degree*12.075f-220.5f;
                        }
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("隔月抄表費用")
                                .setMessage("費用"+ fee)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        months.setText("");
                                        nexts.setText("");
                                    }
                                })
                                .show();
                    }
                }
            }
        });
    }
    public void turn(){
        final String monthString =months.getText().toString();
        if(!TextUtils.isEmpty(monthString)){
            float degree=Float.parseFloat(monthString);
            float fee =0f;
            if (degree>=1&&degree<=10) {
                fee =degree*7.35f;
            }
            else if(degree>=11&&degree<=30){
                fee =degree*9.45f-21;
            }
            else if(degree>=31&&degree<=50){
                fee =degree*11.55f-84;
            }
            else if(degree>=51){
                fee =degree*12.075f-110.25f;
            }
            Intent intent=new Intent(this,ResultActivity.class);
            intent.putExtra("fee",fee);
            startActivity(intent);
           // new AlertDialog.Builder(MainActivity.this)
            //        .setTitle("每月抄表費用")
            //        .setMessage("費用"+ fee)
            //        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
            //            @Override
           //             public void onClick(DialogInterface dialog, int which) {
           //                 months.setText("");
         //                   nexts.setText("");
           //             }
           //         })
            //        .show();
        }
      /*  else{
            String nextString=nexts.getText().toString();
            if (!TextUtils.isEmpty(nextString)){
                float degree=Float.parseFloat(nextString);
                float fee =0f;
                if (degree>=1&&degree<=20) {
                     fee =degree*7.35f;
                }
                else if(degree>=21&&degree<=60){
                     fee =degree*9.45f-42;
                }
                else if(degree>=61&&degree<=100){
                     fee =degree*11.55f-168;
                }
                else if(degree>=101){
                     fee =degree*12.075f-220.5f;
                }
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用"+ fee)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                months.setText("");
                                nexts.setText("");
                            }
                        })
                        .show();
            }
        }*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
