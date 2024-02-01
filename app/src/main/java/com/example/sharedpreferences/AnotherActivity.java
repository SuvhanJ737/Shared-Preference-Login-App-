package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    TextView mNameTV, mAgeTV;
    Button mLogoutBtn;
    SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        mNameTV = findViewById(R.id.nameTv);
        mAgeTV = findViewById(R.id.ageTv);
        mLogoutBtn = findViewById(R.id.logout);
        preference = getSharedPreferences("SHARED_PREF" ,MODE_PRIVATE);

        String name = preference.getString("NAME", "");
        mNameTV.setText(name);
        int age = preference.getInt("AGE", 0);
        mAgeTV.setText(""+age);



        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = preference.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(AnotherActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}