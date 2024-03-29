package com.financelingo.financelingo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class Tutorial extends AppCompatActivity {

    //declare initial text number
    private int textNum = 0;

    //initializing buttons
    private Button next;
    private Button back;

    //initializing image elements
    private ImageView t_budgeting_image;
    private TextView t_budgetingLabel;
    private ImageView t_budgeting_info;
    private ImageView t_acc_pic;
    private ImageView t_budgeting_button;

    //initializing text fields
    private TextView tutorialText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        //set screen to tutorial.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        //define image elements for tutorial page
        t_budgeting_image = findViewById(R.id.tutorialBudgetingImage);
        t_budgetingLabel = findViewById(R.id.tutorialBudgetingLabel);
        t_budgeting_info = findViewById(R.id.tutorialBudgetingReadingInfo);
        t_acc_pic = findViewById(R.id.tutorialAccPic);
        t_budgeting_button = findViewById(R.id.tutorialBudgetingButton);

        //define text fields for tutorial text
        tutorialText = findViewById(R.id.tutorialText);

        //set initial tutorial text
        tutorialText.setText(tutorialTexts[textNum]);

        //set initial image visibilities
        t_budgeting_image.setVisibility(View.INVISIBLE);
        t_budgetingLabel.setVisibility(View.INVISIBLE);
        t_budgeting_info.setVisibility(View.INVISIBLE);
        t_acc_pic.setVisibility(View.INVISIBLE);
        t_budgeting_button.setVisibility(View.INVISIBLE);

        //define buttons for flipping tutorial texts
        next = findViewById(R.id.nextText);
        back = findViewById(R.id.backText);

        //set button listener for flipping next
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textNum == 4) {
                    textNum = 0;
                } else {
                    textNum++;
                }
                tutorialText.setText(tutorialTexts[textNum]);
                determineVisibility();
            }
        });

        //set button listener for flipping back
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (textNum==0) {
                    textNum = 4;
                }else {
                    textNum--;
                }
                tutorialText.setText(tutorialTexts[textNum]);
                determineVisibility();
            }
        });
    }

    //method that determines visibility of image elements based on the tutorial text num
    public void determineVisibility(){
        if(textNum==0){
            t_budgeting_image.setVisibility(View.INVISIBLE);
            t_budgetingLabel.setVisibility(View.INVISIBLE);
            t_budgeting_info.setVisibility(View.INVISIBLE);
            t_acc_pic.setVisibility(View.INVISIBLE);
            t_budgeting_button.setVisibility(View.INVISIBLE);
        }else if(textNum==1){
            t_acc_pic.setVisibility(View.VISIBLE);
        }else if(textNum==2){
            t_acc_pic.setVisibility(View.INVISIBLE);
            t_budgeting_button.setVisibility(View.VISIBLE);
            t_budgeting_image.setVisibility(View.VISIBLE);
        }else if(textNum==3){
            t_budgeting_button.setVisibility(View.INVISIBLE);
            t_budgeting_image.setVisibility(View.INVISIBLE);
            t_budgeting_info.setVisibility(View.VISIBLE);
        }else if(textNum==4){
            t_budgeting_image.setVisibility(View.INVISIBLE);
            t_budgetingLabel.setVisibility(View.INVISIBLE);
            t_budgeting_info.setVisibility(View.INVISIBLE);
            t_acc_pic.setVisibility(View.INVISIBLE);
            t_budgeting_button.setVisibility(View.INVISIBLE);
        }
    };

    //method to switch from tutorial to lessons screen
    public void tutorialToLessons(View v){
        switchActivities(Tutorial.this, Lessons.class);
    }

    //array of tutorial texts
    public String[] tutorialTexts = {
            "Welcome to FinanceLingo! We will be going over a quick app tutorial. Click on the right side of the screen to advance.",
            "Click image icons like this to update your account settings, profile, or join a class.",
            "Click on image icons like this to start a lesson.",
            "Click on image icons like this to access readings that will introduce different financial topics which will help you complete your lesson.",
            "Congrats on taking your first steps to financial literacy. Have fun and get started!"
    };

    //method to switch screens
    public void switchActivities(Context context, Class c){
        Intent switchActivityIntent = new Intent (context, c);
        startActivity(switchActivityIntent);
    }
}