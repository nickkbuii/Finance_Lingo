package com.financelingo.financelingo;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.core.content.ContextCompat;

import android.os.Build;
=======

>>>>>>> 9d36513fb3d6aad31ac53d9462fb6af6e661aa99
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

import database.DatabaseHelper;
import database.User;

public class create extends AppCompatActivity {
<<<<<<< HEAD

    Users user;
    JSONObject json;
=======
    Button create;
>>>>>>> 9d36513fb3d6aad31ac53d9462fb6af6e661aa99

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
<<<<<<< HEAD
        user = new Users();
        json = new JSONObject();

        if(!checkPermission()){
            requestPermissions();
        }
    }

    boolean checkPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            return Environment.isExternalStorageManager();
        }
        else{
            int readcheck = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        }
    }

    public void makeAcc(View v) throws JSONException{
=======

    }

    public void makeAcc(View v){
>>>>>>> 9d36513fb3d6aad31ac53d9462fb6af6e661aa99
        TextView t = findViewById(R.id.user);
        String username = t.getText().toString();

        t = findViewById(R.id.pw);
        String password = t.getText().toString();

        User user = new User(username, password);
        DatabaseHelper db = new DatabaseHelper(create.this);
        if(db.addUser(user)){
            Log.d("info", user.toString());
        }
        else{
            Log.d("info", "No");
        }

<<<<<<< HEAD
=======


>>>>>>> 9d36513fb3d6aad31ac53d9462fb6af6e661aa99
    }

}