package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mNameET, mAgeET;
    CheckBox mRemember;
    Button mBtn;
    SharedPreferences sharedPreferences;
    Boolean isRemembered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameET = findViewById(R.id.nameET);
        mAgeET = findViewById(R.id.ageET);
        mRemember = findViewById(R.id.checkBox);
        mBtn = findViewById(R.id.login);
        sharedPreferences = getSharedPreferences("SHARED_PREF",MODE_PRIVATE);

        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false); //if true move to another activity
        if(isRemembered) {
            Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
            startActivity(intent);
            finish();
        }

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        String name  = mNameET.getText().toString();
        int age = Integer.parseInt(mAgeET.getText().toString().trim());
        Boolean checked = mRemember.isChecked();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME" ,name);
        editor.putInt("AGE" ,age);
        editor.putBoolean("CHECKED" ,checked);
        editor.apply();

        Toast.makeText(MainActivity.this, "Information Successful", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}