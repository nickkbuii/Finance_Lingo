package com.financelingo.financelingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import database.DatabaseHelper;
import database.User;

public class Create extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        db = new DatabaseHelper(Create.this);
    }

    private void switchActivities(Class c){
        Intent switchActivityIntent = new Intent (this, c);
        startActivity(switchActivityIntent);
    }


    public void makeAcc(View v){
        TextView t = findViewById(R.id.user);
        String username = t.getText().toString();

        if(!db.checkUser(username)){
            Toast.makeText(Create.this, "USER TAKEN", Toast.LENGTH_SHORT).show();
            return;
        }

        t = findViewById(R.id.pw);
        String password = t.getText().toString();

        if(checkPass(password) != null){
            Toast.makeText(Create.this, checkPass(password), Toast.LENGTH_LONG).show();
            return;
        }

        /*Testing something*/
        Button b = findViewById(R.id.createButton);
        if(b.getTag().equals("correct")){
            Log.d("Testing", "this is correct");
        }

        User user = new User(username, password);

        if(db.addUser(user)){
            Toast.makeText(Create.this, "Account Created", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(Create.this, "Create Failed", Toast.LENGTH_SHORT).show();
        }
        //Log.d("testing", db.getUser("testing", "testing").toString());
        switchActivities(Create.this, MainActivity.class);
    }

    public String checkPass(String pass){
        if(!Character.isUpperCase(pass.charAt(0))){
            return "Password must have atleast 1 uppercase Letter!";
        }
        if(pass.length() < 8){
            return "Password must be atleast 8 letters long!";
        }
        if(pass.matches(".*\\d.*")){
            return "Password must contain a number!";
        }

        return null;
    }

    public void switchActivities(Context context, Class c){
        Intent switchActivityIntent = new Intent (context, c);
        startActivity(switchActivityIntent);
    }
}