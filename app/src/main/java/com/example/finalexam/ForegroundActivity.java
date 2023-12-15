package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForegroundActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "CPTR320";
    public static final String KEY_STU = "studentinfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground);
        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(this);
    }

    public void onClick(View view){
        try{
        Log.d(TAG, "Send button clicked!");
        EditText id = findViewById(R.id.sidEntry);
        int sid = Integer.parseInt(id.getText().toString());

        EditText first = findViewById(R.id.firstNameEntry);
        String firstName = first.getText().toString();
        EditText last = findViewById(R.id.lastNameEntry);
        String lastName = last.getText().toString();
        EditText maj = findViewById(R.id.majorEntry);
        String major = maj.getText().toString();

        Student student = new Student(firstName, lastName, sid, major);
        Intent intent = new Intent(this, BackgroundActivity.class);
        intent.putExtra(KEY_STU, student);
        startActivity(intent);
        } catch (NumberFormatException e){
            showToast("Student ID needs to be number.");
        }
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
        return;
    }
}