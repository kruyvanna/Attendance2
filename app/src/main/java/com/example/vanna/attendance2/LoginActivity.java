package com.example.vanna.attendance2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.vanna.attendance2.history.AttenddanceHistoryActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView facebookButton = (TextView) findViewById(R.id.facebookButton);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/icomoon.ttf");
        facebookButton.setTypeface(typeface);
        facebookButton.setText("\ue901");

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AttenddanceHistoryActivity.class);
                startActivity(intent);
            }
        });

    }
}
