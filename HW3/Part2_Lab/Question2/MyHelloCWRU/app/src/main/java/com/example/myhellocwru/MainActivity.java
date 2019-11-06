package com.example.myhellocwru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private EditText et;
    private Button smsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.CallPhone);
        et = (EditText) findViewById(R.id.PhoneNumber);
        smsButton = (Button) findViewById(R.id.smsbutton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + et.getText().toString()));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    startActivity(callIntent);
                    return;
                }
            }
        });

        smsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent messageIntent = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(messageIntent);
            }
        });
    }
}
