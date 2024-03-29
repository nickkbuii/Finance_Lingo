package com.financelingo.financelingo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;

import database.Database;
import Global.Global;

public class BudgetingResults extends AppCompatActivity {

    //retrieve score from user database class
    private int score = Global.user.getQScore(Global.BUDGETING);
    private TextView budgeting_results;
    Database db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set screen to lessons.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budgeting_results);
        //display score out of total questions
        //define budgeting results text view
        budgeting_results = findViewById(R.id.debt_results_text);
        budgeting_results.setText(score+"/5");
        db = new Database();
    }

    //method that switches from budgeting results screen to lessons screen
    public void switchToHome(View view){
        switchActivities(BudgetingResults.this, Lessons.class);
    }

    //method that switches from budgeting results screen to lesson
    //so user can restart
    public void restartLesson(View view){
        Global.user.setQScore(Global.BUDGETING, 0);
        db.updateScore(Global.BUDGETING);
        switchActivities(BudgetingResults.this, BudgetingLesson.class);
    }

    //method to switch classes
    public void switchActivities(Context context, Class c){
        Intent switchActivityIntent = new Intent (context, c);
        startActivity(switchActivityIntent);
    }

}