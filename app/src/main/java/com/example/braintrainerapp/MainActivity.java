package com.example.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;
    TextView time;
    TextView scoring;
    TextView process;
    TextView end;
    Button button;
    CountDownTimer countDownTimer;
    Random random;
    int a, b, c;
    int correctAnswers = 0;
    int questions = 0;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // start of program
    public void GO(View view) {
        setVariables();

        countDownTimer = new CountDownTimer(31000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String zero = "";
                if ((millisUntilFinished / 1000) < 10)
                    zero = "0";
                time.setText("00:" + zero + Integer.toString((int) millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {

                gridLayout.setVisibility(View.INVISIBLE);
                time.setVisibility(View.INVISIBLE);
                scoring.setVisibility(View.INVISIBLE);
                process.setVisibility(View.INVISIBLE);

                end = findViewById(R.id.end);
                end.setText("YOUR SCORE IS " + Integer.toString(correctAnswers) + "\n" + " again? Press GO!");
                end.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                correctAnswers = 0;
                questions = 0;
                scoring.setText("0/0");


            }
        }.start();

        numberGeneration();
    }

    //for checking whether result is true or not
    public void Button1(View view) {

        Button button1 = findViewById(R.id.button1);
        if (button1.getText() == Integer.toString(c)) {
            correctAnswers++;
            mediaPlayer = MediaPlayer.create(this, R.raw.correct);


        } else mediaPlayer = MediaPlayer.create(this, R.raw.error);

        numberGeneration();
        questions++;
        scoring.setText(Integer.toString(correctAnswers) + "/" + Integer.toString(questions));
        mediaPlayer.start();
    }

    public void Button2(View view) {

        Button button2 = findViewById(R.id.button2);
        if (button2.getText() == Integer.toString(c)) {
            correctAnswers++;
            mediaPlayer = MediaPlayer.create(this, R.raw.correct);

        } else mediaPlayer = MediaPlayer.create(this, R.raw.error);
        numberGeneration();
        questions++;
        scoring.setText(Integer.toString(correctAnswers) + "/" + Integer.toString(questions));
        mediaPlayer.start();

    }

    public void Button3(View view) {

        Button button3 = findViewById(R.id.button3);
        if (button3.getText() == Integer.toString(c)) {
            correctAnswers++;
            mediaPlayer = MediaPlayer.create(this, R.raw.correct);

        } else mediaPlayer = MediaPlayer.create(this, R.raw.error);
        numberGeneration();
        questions++;
        scoring.setText(Integer.toString(correctAnswers) + "/" + Integer.toString(questions));
        mediaPlayer.start();
    }

    public void Button4(View view) {

        Button button4 = findViewById(R.id.button4);
        if (button4.getText() == Integer.toString(c)) {
            correctAnswers++;
            mediaPlayer = MediaPlayer.create(this, R.raw.correct);

        } else mediaPlayer = MediaPlayer.create(this, R.raw.error);
        numberGeneration();
        questions++;
        scoring.setText(Integer.toString(correctAnswers) + "/" + Integer.toString(questions));
        mediaPlayer.start();
    }

    //for number generation in buttons
    public void numberGeneration() {
        random = new Random();
        a = random.nextInt(21);
        b = random.nextInt(21);
        c = a + b;
        process.setText(Integer.toString(a) + "+" + Integer.toString(b));

        Button[] buttons = {findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3), findViewById(R.id.button4)};
        int n = random.nextInt(4);
        buttons[n].setText(Integer.toString(c));
        int count = 0;
        while (count < 4) {
            if (count != n) {
                int in = random.nextInt(40);
                while (in == c) {
                    in = random.nextInt(40);
                }
                buttons[count].setText(Integer.toString(in));
                if(count!=0 && buttons[count].equals(buttons[count-1])){
                    in = random.nextInt(40);
                    buttons[count].setText(Integer.toString(in));
                }
            }
            count++;

        }
    }

    public void Button(View view) {
        Button[] buttons = {findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3), findViewById(R.id.button4)};


    }

    public void setVariables() {
        end = findViewById(R.id.end);
        button = findViewById(R.id.go);
        gridLayout = findViewById(R.id.grid);
        time = findViewById(R.id.time);
        scoring = findViewById(R.id.scoring);
        process = findViewById(R.id.process);
        gridLayout.setVisibility(View.VISIBLE);
        time.setVisibility(View.VISIBLE);
        scoring.setVisibility(View.VISIBLE);
        process.setVisibility(View.VISIBLE);
        end.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);

    }


}
