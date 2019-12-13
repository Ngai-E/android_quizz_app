package com.example.quizzapp;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {
    /**
     1: a,b,c
     2: a
     3: b
     4: b
     5: c
     6: a
     7: c
     8 : a
     **/
//questions and pictures taken from 'https://www.proprofs.com/quiz-school/story.php?title=pq-test-your-knowledge-on-health-and-body'
    int totalScore = 0;
    String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit (View view) {
        //get the person's name
       EditText editText = (EditText) findViewById(R.id.name);
       name = editText.getText().toString();
       gradeUser();
//       Toast toast = Toast.makeText(getApplicationContext(), "Sending results...", Toast.LENGTH_SHORT);
//       toast.show();
       String summary = this.getSummary();
        TextView textView = (TextView) findViewById(R.id.results);
        textView.setText(summary);
    }

    private void  gradeUser() {
        CheckBox checkBox;
        RadioButton radioButton;
        int test = 0;

        //grade question one
        checkBox = (CheckBox) findViewById(R.id._1a);
        if (checkBox.isChecked()) {
            test++;
        }
        checkBox = (CheckBox) findViewById(R.id._1b);
        if (checkBox.isChecked()) {
            test++;
        }
        checkBox = (CheckBox) findViewById(R.id._1c);
        if (checkBox.isChecked()) {
            test++;
        }
        checkBox = (CheckBox) findViewById(R.id._1c);
        if (checkBox.isChecked()) {
            test = -1;
        }

        if (test == 3) {
            this.totalScore++;
        }

        //grade question two
        radioButton = (RadioButton) findViewById(R.id._2a);
        if (radioButton.isChecked()) {
            this.totalScore++;
        }
        //grade question three
        radioButton = (RadioButton) findViewById(R.id._3b);
        if (radioButton.isChecked()) {
            this.totalScore++;
        }
        //grade question four
        radioButton = (RadioButton) findViewById(R.id._4b);
        if (radioButton.isChecked()) {
            this.totalScore++;
        }
        //grade question five
        radioButton = (RadioButton) findViewById(R.id._5c);
        if (radioButton.isChecked()) {
            this.totalScore++;
        }
        //grade question six
        radioButton = (RadioButton) findViewById(R.id._6a);
        if (radioButton.isChecked()) {
            this.totalScore++;
        }
    }
    public  void reset(View  view){
     this.totalScore = 0;
     this.name = "";
    }
    private String getSummary() {
        String summary = "Name: " + this.name ;
        summary += "\n Health quiz score is " + this.totalScore + '/' + "6";
        summary += "\n" + "Thank you!";
        return  summary;
    }

}
