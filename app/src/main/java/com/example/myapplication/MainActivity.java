package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCenter.start(getApplication(), "a24eed57-6681-4d68-937e-5243cdf18357",
                Analytics.class, Crashes.class);
    }

    public static final  String EXTRA_MESSAGE="com.example.myapplication1";

    public void sendMessage(View view){
        Map<String, String> properties = new HashMap<>();
        properties.put("Category", "Music");
        properties.put("FileName", "favorite.avi");
        Analytics.trackEvent("Video clicked", properties);


Intent intent=new Intent(this, DisplayMessageActivity.class);
EditText editText=(EditText)findViewById(R.id.editText);
String message=editText.getText().toString();
intent.putExtra(EXTRA_MESSAGE,message);
startActivity(intent);

    }
}