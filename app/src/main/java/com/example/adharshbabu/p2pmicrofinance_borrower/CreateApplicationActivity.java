package com.example.adharshbabu.p2pmicrofinance_borrower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CreateApplicationActivity extends AppCompatActivity {

    private EditText name;
    private EditText location;
    private Button submit;

    private DatabaseReference database;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_application);

        name = (EditText) findViewById(R.id.name_edittext);
        location = (EditText) findViewById(R.id.location_edittext);
        submit = (Button) findViewById(R.id.submit_button);

        database = FirebaseDatabase.getInstance().getReference();;
        user = FirebaseAuth.getInstance().getCurrentUser();

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map<String, Object> application = new HashMap<>();
                application.put("borrowerName", name.getText());
                application.put("borrowerLocation", location.getText());
                application.put("amountRequested", new Double (1));
                application.put("amountRecieved", new Double (2));
                application.put("amountReturned", new Double (3));
                application.put("description", "sdfds");

                Map<String, Object> uiToApplication = new HashMap<>();
                uiToApplication.put(user.getUid(), application);
                //database.updateChildren(application);
                database.updateChildren(uiToApplication);
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
