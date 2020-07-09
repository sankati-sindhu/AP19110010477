package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private EditText mReply;
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.text_message);
        mReply = findViewById(R.id.editText_second);
        mReply.setText("");
        mReply.setHint(R.string.editText_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(message);
    }

    public void returnReply(View view) {
        Intent replyIntent = new Intent();
        String reply = mReply.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}