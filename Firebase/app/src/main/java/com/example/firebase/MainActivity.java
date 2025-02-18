package com.example.firebase;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private FirebaseFirestore db;
    private TextView textViewData; // TextView to display Firestore data

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseApp.initializeApp(this);
        // Enable Edge-to-Edge UI
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();
        textViewData = findViewById(R.id.textViewData); // Linking to TextView

        // Add and fetch user data
        addUser();
        fetchUsers();
    }

    private void addUser() {
        User newUser = new User("Laksh", "Innani", 2006);  // Create User object

        db.collection("users")
                .add(newUser)
                .addOnSuccessListener(documentReference -> Log.d(TAG, "User added with ID: " + documentReference.getId()))
                .addOnFailureListener(e -> Log.e(TAG, "Error adding user", e));
    }

    private void fetchUsers() {
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            StringBuilder userData = new StringBuilder();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String first = document.getString("first");
                                String last = document.getString("last");
                                Long born = document.getLong("born");

                                userData.append("Name: ").append(first).append(" ").append(last)
                                        .append("\nBorn: ").append(born)
                                        .append("\n\n");
                            }
                            textViewData.setText(userData.toString()); // Display data in TextView
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}