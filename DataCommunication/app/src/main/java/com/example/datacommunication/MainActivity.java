package com.example.datacommunication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnNext;
    String rN;
    TextView txtView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnNext = findViewById(R.id.btnNext);
        txtView1 = findViewById(R.id.txtView1);

        btnNext.setOnClickListener(new BtnNextClickListener());
    }

    class BtnNextClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("username",edtUsername.getText().toString());
            intent.putExtra("password",edtPassword.getText().toString());

//            startActivity(intent);

            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        rN = bundle.getString("rollnumber");
        Log.e("tag",rN);
        txtView1.setText(rN);
    }
}