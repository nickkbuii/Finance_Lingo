
package com.financelingo.financelingo;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import Global.Global;
import database.Database;
import Lessons.TaxesReadings;

public class Lessons extends AppCompatActivity{

    //retrieve score from user class
    private int budg_score = Global.user.getQScore(Global.BUDGETING);
    private int debt_score = Global.user.getQScore(Global.DEBT);
    private int tax_score = Global.user.getQScore(Global.TAXES);
    private int invest_score = Global.user.getQScore(Global.INVESTMENTS);

    //initialize account name text view
    private TextView accName;

    //initialize bar amount
    int budg_barAmount = 0;
    int debt_barAmount = 0;
    int tax_barAmount = 0;
    int inv_barAmount = 0;

    Database db;

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set screen to lessons.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons);

        db = new Database();

        //define account name text view
        accName = findViewById(R.id.accName);
        if(db.getAuth().getCurrentUser().getDisplayName() == null){
            accName.setText(Global.user.getUsername());
        }
        else{
            accName.setText(db.getAuth().getCurrentUser().getDisplayName().toString().toUpperCase());
        }

        ProgressBar budgetingProgressBar = findViewById(R.id.budgetingProgressBar);
        ProgressBar debtProgressBar = findViewById(R.id.debtProgressBar);
        ProgressBar taxProgressBar = findViewById(R.id.taxesProgressBar);
        ProgressBar invProgressBar = findViewById(R.id.investmentsProgressBar);

        //animate progress bar based on score
        animateBar(budgetingProgressBar, budg_score, budg_barAmount);
        animateBar(debtProgressBar, debt_score, debt_barAmount);
        animateBar(taxProgressBar, tax_score, tax_barAmount);
        animateBar(invProgressBar, invest_score, inv_barAmount);

    }

    //method that changes from lessons (home) class to the lesson class
    public void toLesson(View v){
        switchActivities(Lessons.this, BudgetingLesson.class);
        if(budg_score!=5){
            Global.user.setQScore(Global.BUDGETING, 0);
            db.updateScore(Global.BUDGETING);
        }
    }

    //method that changes from lessons (home) class to the reading class
    public void toReading(View v){
        switchActivities(Lessons.this, BudgetingReading.class);
    }

    //method that changes from lessons (home) class to the account settings class
    public void toAccSettings(View v){
        switchActivities(Lessons.this, AccSettings.class);
    }

    //method that changes from lessons (home) class to the tutorial class
    public void toTutorial(View v){
        switchActivities(Lessons.this, Tutorial.class);
    }

    public void toDebtLesson(View view){
        switchActivities(Lessons.this, DebtLesson.class);
    }

    //switch from lessons to budgeting reading
    public void toDebtReading(View view){
        switchActivities(Lessons.this, DebtReading.class);
    }

    //switch from lessons to taxes lesson
    public void toTaxesLesson(View view){ switchActivities(Lessons.this, TaxLesson.class);}

    //switch from  lessons to taxes reading
    public void toTaxesReading(View view) {
        switchActivities(Lessons.this, TaxesReading.class);
    }

    public void toInvestReading(View view){
        switchActivities(Lessons.this, InvestmentsReading.class);
    }
    public void toInvestLesson(View view){ switchActivities(Lessons.this, InvestmentsLesson.class); }

    //method to increment progress bar
    public void animateBar(ProgressBar bar, int amount, int barAmount){
        ValueAnimator animator = ValueAnimator.ofInt(barAmount, (barAmount+amount)*20);
        animator.setDuration(100);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation){
                bar.setProgress((Integer)animation.getAnimatedValue());
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // start your activity here
            }
        });
        animator.start();
    }

    //method that allows us to switch methods and UI aka activities
    public void switchActivities(Context context, Class c){
        Intent switchActivityIntent = new Intent (context, c);
        startActivity(switchActivityIntent);
    }

}
