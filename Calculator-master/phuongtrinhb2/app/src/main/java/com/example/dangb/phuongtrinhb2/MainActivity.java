package com.example.dangb.phuongtrinhb2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText txt1,txt2;
    public Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (EditText)this.findViewById(R.id.textView2);
        txt2 = (EditText)this.findViewById(R.id.textView3);
        btn1 = (Button)this.findViewById(R.id.btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result();
            }
        });
    }
    public void result()
    {
        double text1 = Double.parseDouble(txt1.getText().toString());
        double text2 = Double.parseDouble(txt2.getText().toString());
        double result = -text2/text1;
        String kq = String.valueOf(result);
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("result",result);
        //intent.putExtra("num2",text2)
        this.startActivity(intent);
    }
}
