package com.example.dangb.eventclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOutput extends AppCompatActivity {
    private Button btnResult;
    private TextView txtA, txtB;
    public static String RESULT_AB ="result_ab";
    private int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        getWidget();
        getData();
        setEvent();
    }
    public void getData(){
        Intent intent = getIntent();
        int A = intent.getIntExtra(ActivityInput.NUMBER_A,0);
        int B = intent.getIntExtra(ActivityInput.NUMBER_B,0);
        txtA.setText(String.valueOf(A));
        txtA.setText(String.valueOf(B));
    }
    public void getWidget(){
        txtA = (TextView) findViewById(R.id.txtA);
        txtB = (TextView) findViewById(R.id.txtB);
        btnResult = (Button) findViewById(R.id.btnResult);
    }
    public void setEvent(){
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(RESULT_AB,a+b);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
