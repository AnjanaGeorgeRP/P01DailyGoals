package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] info = i.getStringArrayExtra("info");
        // Get the TextView object
        TextView tv1 = (TextView) findViewById(R.id.textView);
        Button back = (Button) findViewById(R.id.back);

        // Display the name and age on the TextView
        tv1.setText("Read up on materials before class: " + info[0] + "\n Arrive on time soa as not to miss impoertant part of the lesson: " + info[1]+"\n Attempt the problem myself:"+info[2]+"\n Relection:"+info[3]);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);

            }});
    }


}
