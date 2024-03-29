package com.financelingo.financelingo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import Lessons.*;


public class BudgetingReading extends AppCompatActivity {

    //access readings and definitions from BudgetingReadings.java and initialize reading text view, next/back buttons
    //set default page number to 0
    private BudgetingReadings budgetingReadings = new BudgetingReadings();
    private int pageNumber = 0;
    Button next;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set the screen to budgeting_reading.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budgeting_reading);

        //define text fields to update
        TextView readingView = (TextView)findViewById(R.id.taxes_readingBody);
        TextView pageNum = (TextView)findViewById(R.id.taxes_pageNum);
        TextView rule = (TextView)findViewById(R.id.taxes_ruleTitle);
        ImageView pic = (ImageView)findViewById(R.id.taxes_readingPic);

        readingView.setText(budgetingReadings.readings[pageNumber]);
        pageNum.setText(String.valueOf(pageNumber+1));
        rule.setText(budgetingReadings.rules[pageNumber]);
        pic.setImageDrawable(getDrawable(budgetingReadings.imageList[pageNumber]));

        //set and define button listener for flipping next
        next = (Button)findViewById(R.id.taxes_nextPage);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (pageNumber==3) {
                    pageNumber = 0;
                }else {
                    pageNumber++;
                }
                readingView.setText(budgetingReadings.readings[pageNumber]);
                pageNum.setText(String.valueOf(pageNumber+1));
                rule.setText(budgetingReadings.rules[pageNumber]);
                pic.setImageDrawable(getDrawable(budgetingReadings.imageList[pageNumber]));
            }
        });

        //set and define button listener for flipping back
        back = (Button)findViewById(R.id.taxes_backPage);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (pageNumber==0){
                    pageNumber=3;
                }else{
                    pageNumber--;
                }
                readingView.setText(budgetingReadings.getReading(pageNumber));
                pageNum.setText(String.valueOf(pageNumber+1));
                rule.setText(budgetingReadings.getRule(pageNumber));
                pic.setImageDrawable(getDrawable(budgetingReadings.imageList[pageNumber]));
            }
        });

    }

    public void budg_r_toHome(View v){
        switchActivities(BudgetingReading.this, Lessons.class);
    }

    public void switchActivities(Context context, Class c){
        Intent switchActivityIntent = new Intent (context, c);
        startActivity(switchActivityIntent);
    }
}
