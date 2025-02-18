package com.example.datacommunication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtUsername;
    TextView txtPassword;
    Button btnBack;
    String username, password;
    EditText edtRollNumber;
    String extractedRollNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initViews();
        getAndBindData();
    }

    private void initViews(){
        txtUsername = findViewById(R.id.textViewUsername);
        txtPassword = findViewById(R.id.textViewPassword);
        btnBack = findViewById(R.id.btnBack);
        edtRollNumber = findViewById(R.id.edtRollNumber);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                extractedRollNumber = edtRollNumber.getText().toString();
                i.putExtra("rollnumber",extractedRollNumber);
                setResult(1,i);
                finish();
            }
        });
    }

    private void getAndBindData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        username = bundle.getString("username");
        password = bundle.getString("password");

        txtUsername.setText(username);
        txtPassword.setText(password);
    }

}