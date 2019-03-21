package com.example.softnik.call_sms_share_webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button call ,sms, sharing,webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void call(View view) {
       Intent intent = new Intent(this,CallActivity.class);
       startActivity(intent);

    }

    public void sms(View view) {
        Intent intent = new Intent(this,SmsActivity.class);
        startActivity(intent);
    }

    public void sharing(View view) {
        Intent intent = new Intent(this,ShareActivity.class);
        startActivity(intent);
    }

    public void webview(View view) {
        Intent intent= new Intent(this,WebActivity.class);
        startActivity(intent);
    }
}
