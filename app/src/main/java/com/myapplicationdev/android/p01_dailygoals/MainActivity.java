package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        et = (EditText) findViewById(R.id.editText);
        // Get the RadioGroup object
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg3 = (RadioGroup) findViewById(R.id.radioGroup3);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();

                // Get the radio button object from the Id we had gotten above
                RadioButton rb1 = (RadioButton) findViewById(selectedButtonId1);
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);

                // Create an intent to start another activity
                Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                String[] info = {rb1.getText().toString(),rb2.getText().toString(),rb3.getText().toString(),et.getText().toString()};
                intent.putExtra("info", info);
                startActivity(intent);

            }});
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strRef = et.getText().toString();
        int radio1 = rg1.getCheckedRadioButtonId();
        int radio2 = rg2.getCheckedRadioButtonId();
        int radio3 = rg3.getCheckedRadioButtonId();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("reflection",strRef);
        prefEdit.putInt("radio1",radio1);
        prefEdit.putInt("radio2",radio2);
        prefEdit.putInt("radio3",radio3);
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String strRef = prefs.getString("reflection","");
        int radio1 = prefs.getInt("radio1",1);
        int radio2 = prefs.getInt("radio2",1);
        int radio3 = prefs.getInt("radio3",1);
        et.setText(strRef);
        rg1.check(radio1);
        rg2.check(radio2);
        rg3.check(radio3);
    }
}
