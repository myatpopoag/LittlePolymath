package com.larkium.littlepolymath;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomeScreen extends AppCompatActivity {
    Button startGame;
    ImageView credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        initViews();

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,Rule.class);
                startActivity(intent);
                finish();
            }
        });

        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,credit.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void initViews() {
        //initialize views here
        startGame =(Button) findViewById(R.id.start);
        credit = (ImageView) findViewById(R.id.credit);
    }
    @Override
    public void onBackPressed() {
            new AlertDialog.Builder(this)
                    .setMessage("Are you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        }

}

