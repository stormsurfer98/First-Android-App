package me.shreygupta.myapplication;

/**
 * Created by Shrey on 9/9/14.
 */

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.Intent;

public class SecondActivity extends Activity {
    private Button revealMessage;
    private TextView messageHidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Get the message from the intent
        Intent intent = getIntent();
        final String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        revealMessage = (Button)findViewById(R.id.revealMessage);
        messageHidden = (TextView)findViewById(R.id.messageHidden);
        revealMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageHidden.setText(message);
            }
        });
    }
}