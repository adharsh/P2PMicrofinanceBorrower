package com.example.adharshbabu.p2pmicrofinance_borrower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    private TextView borrowerName;
    private TextView borrowerLocation;
    private ProgressBar funding;
    //private Textview amountRequested;
    //private Textview amountRecieved;


    private DatabaseReference database;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        borrowerName = (TextView) findViewById(R.id.borrowername_textview);
        borrowerLocation = (TextView) findViewById(R.id.borrowerlocation_textview);
        funding = (ProgressBar) findViewById(R.id.funding_progressbar);

        database = FirebaseDatabase.getInstance().getReference();
        user = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseReference rootRef = database.child(user.getUid());
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot messageSnapshot: snapshot.getChildren()) {
                        borrowerName.setText("Name :" + (String) messageSnapshot.child("borrowerName").getValue());
                        borrowerLocation.setText("Location :" + (String) messageSnapshot.child("borrowerLocation").getValue());
                        Double amount = (Double) messageSnapshot.child("message").getValue();
                    }
                }
                else{
                    //Create intent to another activity for application
                    //Once that intent is done comes back to HomeActivity

                    Intent intent = new Intent(getApplicationContext(), CreateApplicationActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast error = Toast.makeText(getApplicationContext(), "Error in onCancelled @ HomeActivity", Toast.LENGTH_LONG);
                error.show();
            }
        });

    }
}
