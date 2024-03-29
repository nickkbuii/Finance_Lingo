package Global;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import database.User;

public class Global extends AppCompatActivity {
    public static User user = new User();
    private FirebaseAuth fAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();

    public static final String BUDGETING = "Budgeting";
    public static final String DEBT = "Debt";
    public static final String TAXES = "Taxes";
    public static final String INVESTMENTS = "Investments";

    public User getUser(){
        String fUser = fAuth.getCurrentUser().getUid().toString();
        String fEmail = fAuth.getCurrentUser().getEmail().toString();
        fStore.collection("User").document(fUser + " + " + fEmail).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot doc) {
                if(doc.exists()){
                    //Get data here
                    //Set Data to user object that makes it global
                    //Allow a way to access data throughout the app
                }
            }
        });

        return null;
    }

    //method that switches screens
    public void switchActivities(Context context, Class c){
        Intent switchActivityIntent = new Intent (context, c);
        startActivity(switchActivityIntent);
    }
}
