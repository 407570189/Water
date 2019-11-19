package com.fju.water;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.service.autofill.TextValueSanitizer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent =getIntent();
        float fee =intent.getFloatExtra("fee",-1);
        Log.d("ResultActivity",fee+"");
        TextView feetext=findViewById(R.id.money);
        int n=(int) (fee+0.5f);
        feetext.setText(fee+"");
    }

}
