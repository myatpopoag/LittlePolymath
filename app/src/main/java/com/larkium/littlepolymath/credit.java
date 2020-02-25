package com.larkium.littlepolymath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;

public class credit extends AppCompatActivity {
    Button feedback;
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit);

        wv = (WebView) findViewById(R.id.webview3);
        wv.loadUrl("file:///android_asset/about.html");
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        finish();
    }
}
