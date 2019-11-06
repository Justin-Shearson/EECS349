package com.example.maldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button targetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        targetButton = (Button) findViewById(R.id.target);
        targetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent goToTarget = getPackageManager().getLaunchIntentForPackage("com.example.myhellocwru");
//                goToTarget.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(goToTarget);
            }
        });

    }
}
