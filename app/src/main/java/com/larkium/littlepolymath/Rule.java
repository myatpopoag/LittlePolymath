package com.larkium.littlepolymath;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Rule extends AppCompatActivity {
    Button skip,next;
    private WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rule);

        wv=(WebView)findViewById(R.id.webview);
        wv.loadUrl("file:///android_asset/rule.html");
        initViews();
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Rule.this,StartGame.class);
                startActivity(intent);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Rule.this,Reward.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void initViews() {
        //initialize views here
        skip=(Button)findViewById(R.id.skip);
        next=(Button)findViewById(R.id.next);
    }
    //On BackPressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        finish();
    }

}
