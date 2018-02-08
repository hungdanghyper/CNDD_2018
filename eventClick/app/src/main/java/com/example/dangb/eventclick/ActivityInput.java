package com.example.dangb.eventclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityInput extends AppCompatActivity {
    private EditText editTextA, editTextB;
    private Button btnStartActivity;
    public static final String NUMBER_A="NUMBER_A";
    public static final String NUMBER_B="NUMBER_B";
    public static final int REQUEST_CODE=2018;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        _setEvent();
    }
    public void getWidget(){
        editTextA = (EditText) findViewById(R.id.editTextA);
        editTextB = (EditText) findViewById(R.id.editTextB);
        btnStartActivity = (Button) findViewById(R.id.btn);
    }
    public void _setEvent(){
        btnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(editTextA.getText().toString())&&!TextUtils.isEmpty(editTextB.getText().toString())){
                    int numberA = Integer.parseInt(editTextA.getText().toString());
                    int numberB = Integer.parseInt(editTextB.getText().toString());
                    Intent intent = new Intent(ActivityInput.this,ActivityOutput.class);
                    intent.putExtra(NUMBER_A,numberA);
                    intent.putExtra(NUMBER_B,numberB);
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            if(resultCode== RESULT_OK){
                Toast.makeText(ActivityInput.this,String.valueOf(data.getIntExtra(ActivityOutput.RESULT_AB,0)),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
