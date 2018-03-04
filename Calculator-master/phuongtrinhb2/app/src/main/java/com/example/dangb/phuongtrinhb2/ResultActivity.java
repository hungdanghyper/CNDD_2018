package com.example.dangb.phuongtrinhb2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    public TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txt1 = (TextView)this.findViewById(R.id.textView2) ;
        Intent intent = this.getIntent();
        String result = intent.getStringExtra("result");
        txt1.setText(result);
    }
}
