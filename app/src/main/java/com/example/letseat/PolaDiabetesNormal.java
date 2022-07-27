package com.example.letseat;

import static com.example.letseat.SignInActivity.newuser;
import static com.example.letseat.SignInActivity.usernm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PolaDiabetesNormal extends AppCompatActivity {

    private ImageView btnBack;
    private TextView txtUserTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pola_diabetes_normal);

        btnBack = findViewById(R.id.bBackDiabetesNormal);
        txtUserTV = findViewById(R.id.txtUserAsamuratNormal);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user").child(newuser);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usernm  = snapshot.child("name").getValue(String.class);
                txtUserTV.setText(usernm + " !");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(PolaDiabetesNormal.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}