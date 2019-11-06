package com.example.myhellocwru;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MessageActivity extends AppCompatActivity {

    private Button messageButton;
    private Button backButton;
    private EditText phoneNumber;
    private EditText messageContent;

    private void sendMessage(String phoneNumber, String smsMessage){
        if(ActivityCompat.checkSelfPermission(MessageActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MessageActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
        } else {
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phoneNumber, null, smsMessage, null, null);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        messageButton = (Button) findViewById(R.id.sendmessage);
        phoneNumber = (EditText) findViewById(R.id.number);
        backButton = (Button) findViewById(R.id.back);
        messageContent = (EditText) findViewById(R.id.messagecontent);

        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sendMessage(messageContent.getText().toString(), phoneNumber.getText().toString());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent backIntent = new Intent(MessageActivity.this, MainActivity.class);
                startActivity(backIntent);
            }
        });

    }

}
