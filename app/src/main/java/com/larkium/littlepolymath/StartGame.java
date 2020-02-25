package com.larkium.littlepolymath;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import java.util.Collections;
import java.util.List;


public class StartGame extends AppCompatActivity {
    Button buttonA, buttonB, buttonC, buttonD;
    TextView questionText, timeText, resultText ,title, quiznoText, coinText;
    QuizHelper quizHelper;
    QuizQuestion currentQuestion;
    List<QuizQuestion> list;
    int qid = 0;
    int timeValue = 20;
    int coinValue = 0;
    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playgame);

        //Initializing variables
        questionText = (TextView) findViewById(R.id.Question);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        timeText = (TextView) findViewById(R.id.timeText);
        coinText = (TextView) findViewById(R.id.coinText);
        resultText = (TextView) findViewById(R.id.resultText);
        title = (TextView) findViewById(R.id.title);


        //Our database helper class
        quizHelper = new QuizHelper(this);
        //Make db writable
        quizHelper.getWritableDatabase();

        //It will check if the ques,options are already added in table or not
        //If they are not added then the getAllOfTheQuestions() will return a list of size zero
        if (quizHelper.getAllOfTheQuestions().size() == 0) {
            //If not added then add the ques,options in table
            quizHelper.allQuestion();
        }

        //This will return us a list of data type TriviaQuestion
        list = quizHelper.getAllOfTheQuestions();

        //Now we gonna shuffle the elements of the list so that we will get questions randomly
        Collections.shuffle(list);

        //currentQuestion will hold the que, 4 option and ans for particular id
        currentQuestion = list.get(qid);

        //countDownTimer
        countDownTimer = new CountDownTimer(22000, 1000) {
            public void onTick(long millisUntilFinished) {

                //here you can have your logic to set text to timeText
                timeText.setText(String.valueOf(timeValue) + "\"");

                //With each iteration decrement the time by 1 sec
                timeValue -= 1;

                //This means the user is out of time so onFinished will called after this iteration
                if (timeValue == -1) {

                    //Since user is out of time setText as time up
                    resultText.setText(getString(R.string.timeup));

                    //Since user is out of time he won't be able to click any buttons
                    //therefore we will disable all four options buttons using this method
                    disableButton();
                }
            }

            //Now user is out of time
            public void onFinish() {
                //We will navigate him to the time up activity using below method
                timeUp();
            }
        }.start();

        //This method will set the que and four options
        updateQueAndOptions();


    }


    public void updateQueAndOptions() {

        //This method will setText for que and options
        coinText.setText(String.valueOf(coinValue));
        title.setText(currentQuestion.getCategory());
        questionText.setText(currentQuestion.getQuestion());
        buttonA.setText(currentQuestion.getOptA());
        buttonB.setText(currentQuestion.getOptB());
        buttonC.setText(currentQuestion.getOptC());
        buttonD.setText(currentQuestion.getOptD());


        timeValue = 20;

        //Now since the user has ans correct just reset timer back for another que- by cancel and start
        countDownTimer.cancel();
        countDownTimer.start();
        qid++;
    }

    //Onclick listener for first button
    public void buttonA(View view) {
        //compare the option with the ans if yes then make button color green
        if (currentQuestion.getOptA().equals(currentQuestion.getAnswer())) {
            buttonA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
            //Check if user has not exceeds the que limit

                //Now disable all the option button since user ans is correct so
                //user won't be able to press another option button after pressing one button
                disableButton();
                coinValue+=100;
                //Show the dialog that ans is correct
                correctDialog();

            //If user has exceeds the que limit just navigate him to GameWon activity





        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {
                buttonA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.timer));

                    disableButton();
                    incorrectDialog();

            }
    }

    //Onclick listener for second button
    public void buttonB(View view) {
        //compare the option with the ans if yes then make button color green
        if (currentQuestion.getOptB().equals(currentQuestion.getAnswer())) {
            buttonB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
            //Check if user has not exceeds the que limit

                //Now disable all the option button since user ans is correct so
                //user won't be able to press another option button after pressing one button
                disableButton();
                coinValue+=100;
                //Show the dialog that ans is correct
                correctDialog();




        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {
            buttonB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.timer));

                disableButton();
                incorrectDialog();
            }

    }

    //Onclick listener for third button
    public void buttonC(View view) {
        //compare the option with the ans if yes then make button color green
        if (currentQuestion.getOptC().equals(currentQuestion.getAnswer())) {
            buttonC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
            //Check if user has not exceeds the que limit


                //Now disable all the option button since user ans is correct so
                //user won't be able to press another option button after pressing one button
                disableButton();
                coinValue+=100;
                //Show the dialog that ans is correct
                correctDialog();





        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {
            buttonC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.timer));

                disableButton();
                incorrectDialog();
            }

    }

    //Onclick listener for fourth button
    public void buttonD(View view) {
        //compare the option with the ans if yes then make button color green
        if (currentQuestion.getOptD().equals(currentQuestion.getAnswer())) {
            buttonD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
            //Check if user has not exceeds the que limit


                //Now disable all the option button since user ans is correct so
                //user won't be able to press another option button after pressing one button
                disableButton();
                coinValue+=100;
                //Show the dialog that ans is correct
                correctDialog();




        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {
            buttonD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.timer));

                disableButton();
                incorrectDialog();
            }

    }



    //This method will navigate from current activity to GameWon
    public void gameWon() {
        if(coinValue<400){
            setContentView(R.layout.game_lost);
            Button lostbutton = (Button) findViewById(R.id.homebutton4);
            lostbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartGame.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if(coinValue==400){
            setContentView(R.layout.game_won4);
            Button homebutton4 = (Button) findViewById(R.id.homebutton4e);
            homebutton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartGame.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if(coinValue==500){
            setContentView(R.layout.game_won5);
            Button homebutton5 = (Button) findViewById(R.id.homebutton5);
            homebutton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartGame.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if(coinValue==600){
            setContentView(R.layout.game_won6);
            Button homebutton6 = (Button) findViewById(R.id.homebutton6);
            homebutton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartGame.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if (coinValue == 700) {
            setContentView(R.layout.game_won7);
            Button homebutton7 = (Button) findViewById(R.id.homebutton7);
            homebutton7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartGame.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if(coinValue==800){
            setContentView(R.layout.game_won8);
            Button homebutton8 = (Button) findViewById(R.id.homebutton8);
            homebutton8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartGame.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if (coinValue == 900) {
            setContentView(R.layout.game_won9);
            Button homebutton9 = (Button) findViewById(R.id.homebutton9);
            homebutton9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartGame.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            });

        }
        else if(coinValue==1000){
            setContentView(R.layout.game_won);
            Button homebutton1= (Button) findViewById(R.id.homebutton1);
            homebutton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartGame.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }

    //This method is called when user ans is wrong
    //this method will navigate user to the activity PlayAgain


    //This method is called when time is up
    //this method will navigate user to the activity Time_Up
    public void timeUp() {
        Intent intent = new Intent(this, TimeUp.class);
        startActivity(intent);
        finish();
    }

    //If user press home button and come in the game from memory then this
    //method will continue the timer from the previous time it left
    @Override
    protected void onRestart() {
        super.onRestart();
        countDownTimer.start();
    }

    //When activity is destroyed then this will cancel the timer
    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    //This will pause the time
    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    //On BackPressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        finish();
    }

    //This dialog is show to the user after he ans correct
    public void correctDialog() {
        final Dialog dialogCorrect = new Dialog(StartGame.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();

        //Since the dialog is show to user just pause the timer in background
        onPause();

        TextView correctText = (TextView) dialogCorrect.findViewById(R.id.correctText);
        TextView mark = (TextView) dialogCorrect.findViewById(R.id.mark);
        TextView exp = (TextView) dialogCorrect.findViewById(R.id.explanation);
        exp.setText(currentQuestion.getExp());
        Button buttonNext = (Button) dialogCorrect.findViewById(R.id.dialogNext);

        //OnCLick listener to go next que
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This will dismiss the dialog
                dialogCorrect.dismiss();

                //it will increment the question number
                currentQuestion = list.get(qid);
                if(qid==list.size()-1) {
                    gameWon();
                }
                //get the que and 4 option and store in the currentQuestion

                //Now this method will set the new que and 4 options
                updateQueAndOptions();
                //reset the color of buttons back to white
                resetColor();
                //Enable button - remember we had disable them when user ans was correct in there particular button methods
                enableButton();
            }
        });

    }

    public void incorrectDialog() {
        final Dialog dialoginCorrect = new Dialog(StartGame.this);
        dialoginCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialoginCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialoginCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialoginCorrect.setContentView(R.layout.dialog_incorrect);
        dialoginCorrect.setCancelable(false);
        dialoginCorrect.show();

        //Since the dialog is show to user just pause the timer in background
        onPause();

        TextView incorrectText = (TextView) dialoginCorrect.findViewById(R.id.incorrectText);
        TextView markText = (TextView) dialoginCorrect.findViewById(R.id.mark);
        TextView exp = (TextView) dialoginCorrect.findViewById(R.id.explanation);
        exp.setText(currentQuestion.getExp());
        Button buttonNext = (Button) dialoginCorrect.findViewById(R.id.dialogNext);


        //OnCLick listener to go next que
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This will dismiss the dialog
                dialoginCorrect.dismiss();

                //it will increment the question number
                currentQuestion = list.get(qid);
                if(qid==list.size()-1) {
                    gameWon();
                }
                    //get the que and 4 option and store in the currentQuestion

                //Now this method will set the new que and 4 options
                updateQueAndOptions();
                //reset the color of buttons back to white
                resetColor();
                //Enable button - remember we had disable them when user ans was correct in there particular button methods
                enableButton();
            }
        });
    }


    //This method will make button color white again since our one button color was turned green
    public void resetColor() {
        buttonA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.buttoncolor));
        buttonB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.buttoncolor));
        buttonC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.buttoncolor));
        buttonD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.buttoncolor));
    }

    //This method will disable all the option button
    public void disableButton() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
    }

    //This method will all enable the option buttons
    public void enableButton() {
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
    }


}
