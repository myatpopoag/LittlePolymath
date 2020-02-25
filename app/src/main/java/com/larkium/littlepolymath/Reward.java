package com.larkium.littlepolymath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

    public class Reward extends AppCompatActivity {
        Button start;
        private WebView wv;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.reward);

            wv=(WebView)findViewById(R.id.webview2);
            wv.loadUrl("file:///android_asset/reward.html");
            initViews();
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Reward.this,StartGame.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        public void initViews() {
            //initialize views here
            start=(Button)findViewById(R.id.start);
        }
        //On BackPressed
        @Override
        public void onBackPressed() {
            Intent intent = new Intent(this, HomeScreen.class);
            startActivity(intent);
            finish();
        }

    }
