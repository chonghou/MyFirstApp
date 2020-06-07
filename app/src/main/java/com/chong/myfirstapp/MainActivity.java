package com.chong.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void dial(View view){
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        Uri number = Uri.parse(message);
//        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        Uri webpage = Uri.parse("https://www.baidu.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        // Always use string resources for UI text.
// This says something like "Share this photo with"
        String title = getResources().getString(R.string.chooser_title);
// Create intent to show chooser
        Intent chooser = Intent.createChooser(webIntent, title);
// Verify the intent will resolve to at least one activity
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }


    }


}
