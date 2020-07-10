package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class rpsLogic extends AppCompatActivity {
    String userChoice;
    String ai;
    TextView gameResult, score, round;
    ImageView playerImage, cpuImage;
    int playerpoints= 0;
    int cpupoints= 0;
    int roundNum =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rps);
        round = findViewById(R.id.round);
        gameResult = findViewById(R.id.result);
        playerImage = findViewById(R.id.yourImage);
        cpuImage = findViewById(R.id.cpuImage);
        score = findViewById(R.id.score);
        userChoice = "";
        }
        public void rockUserChoice(View view){
            userChoice = "r";
            playerImage.setImageResource(R.drawable.rock);
            playgame();
            Random random = new Random();
            int color =  Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
            view.setBackgroundColor(color);

        }
        public void paperUserChoice(View view){
            userChoice = "p";
            playerImage.setImageResource(R.drawable.paper);
            playgame();
            Random random = new Random();
            int color =  Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
            view.setBackgroundColor(color);
        }
        public void scissorsUserChoice(View view){
            userChoice = "s";
            playerImage.setImageResource(R.drawable.scissors);
            playgame();
            Random random = new Random();
            int color =  Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
            view.setBackgroundColor(color);
        }
        public void playgame(){
        int rnd = (int) (Math.random() * 3);
        if (rnd == 0) {
            ai = "r";
            cpuImage.setImageResource(R.drawable.rock);
        } else if (rnd == 1) {
            ai = "p";
            cpuImage.setImageResource(R.drawable.paper);
        } else  {
            ai = "s";
            cpuImage.setImageResource(R.drawable.scissors);
        }if (userChoice.equals(ai)) {
            score.setText("Player: "+ playerpoints + " - "+ cpupoints +":CPU");
            gameResult.setText(String.format(" It's a Tie"));
            roundNum ++;
            round.setText("Round:"+roundNum);
        } else if (userChoice.equals("r") && ai.equals("s") || userChoice.equals("p") && ai.equals("r") || userChoice.equals("s") && ai.equals("p")) {
            playerpoints ++;
            score.setText("Player: "+ playerpoints + " - "+ cpupoints +":CPU");
            gameResult.setText("You Win");
            roundNum ++;
            round.setText("Round:"+roundNum);
        }
        else{
            cpupoints ++;
            score.setText("Player: "+ playerpoints + " - "+ cpupoints +":CPU");
            gameResult.setText(String.format("You Lose"));
            roundNum ++;
            round.setText("Round: "+roundNum);
    } } public void resetMethod(View view){
            userChoice = "";
            gameResult.setText("Ready?");
            cpupoints = 0;
            playerpoints = 0;
            roundNum=0;
            score.setText("Player: "+ playerpoints + " - "+ cpupoints +":CPU");
            round.setText("Round:"+roundNum);
            playerImage.setImageResource(R.drawable.question);
            cpuImage.setImageResource(R.drawable.question);
        }
}