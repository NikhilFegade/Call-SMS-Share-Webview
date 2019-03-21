package com.example.softnik.call_sms_share_webview;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Number, Message;
    Button Send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        Number = findViewById(R.id.edtNumber);
        Message = findViewById(R.id.edtMessage);
        Send = findViewById(R.id.btnSend);
        Send.setOnClickListener(this);
    }


    public  void sendSMS() {
        String sms = Message.getText().toString().trim();
        String phoneNumber = Number.getText().toString().trim();


        if (!TextUtils.isEmpty(sms) && !TextUtils.isEmpty(phoneNumber)) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
            } else {
                SmsManager smsManager = SmsManager.getDefault();
                //Send the SMS
                smsManager.sendTextMessage(phoneNumber, null, sms, null, null);
            }
        } else {
            Toast.makeText(SmsActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendSMS();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onClick(View v) {
        sendSMS();
    }
}
