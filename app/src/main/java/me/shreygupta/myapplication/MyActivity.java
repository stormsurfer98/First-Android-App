package me.shreygupta.myapplication;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.net.Uri;

public class MyActivity extends Activity {
    private TextView textView01;
    private Button button01;
    private Button button02;
    private Button button03;
    private EditText editText01;
    public static String EXTRA_MESSAGE;

    public void openWebPage(String url) { //From http://developer.android.com/guide/components/intents-common.html
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        textView01 = (TextView)findViewById(R.id.oldText);
        button01 = (Button)findViewById(R.id.changeButton);
        button02 = (Button)findViewById(R.id.button02);
        button03 = (Button)findViewById(R.id.surfWeb);
        final Intent intent = new Intent(this, SecondActivity.class);
        editText01 = (EditText)findViewById(R.id.editText);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView01.setText(editText01.getText().toString());
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textView01.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("https://www.google.com");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            newConfig.orientation = Configuration.ORIENTATION_PORTRAIT;
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            newConfig.orientation = Configuration.ORIENTATION_LANDSCAPE;
    }
}