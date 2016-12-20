package com.example.android.brainystuffs;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    RelativeLayout em2;
    RelativeLayout em;
    ArrayList<Integer> numbers=new ArrayList<Integer>();
int answerLocation;
    int score=0;
    int ques=0;
    TextView tvresult;
    TextView tvTimer;
    TextView tvpoint;
    TextView tvsum;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgi;
    GridLayout gd;
    //public void disable(){

    //}

  // boolean active=false;
    public void playAgain(View v){
        tvsum.setVisibility(View.VISIBLE);
        gd.setVisibility(View.VISIBLE);
        tvTimer.setVisibility(View.VISIBLE);
        tvpoint.setVisibility(View.VISIBLE);
      //  active=false;
       //if(active==true) {
     //   em.setVisibility(View.VISIBLE);

           score = 0;
           ques = 0;
           tvresult.setText("");
           tvpoint.setText("0/0");
           tvTimer.setText("30s");

           playAgi.setVisibility(View.INVISIBLE);
           new CountDownTimer(30100, 1000) {
               @Override
               public void onTick(long millisUntilFinished) {

                   tvTimer.setText(String.valueOf(millisUntilFinished / 1000) + "s");


               }

               @Override
               public void onFinish() {
                  // active=true;
                 //  em2.setVisibility(View.INVISIBLE);
                   tvsum.setVisibility(View.INVISIBLE);
                   gd.setVisibility(View.INVISIBLE);
                   playAgi.setVisibility(View.VISIBLE);
                   tvTimer.setVisibility(View.INVISIBLE);
                   tvpoint.setVisibility(View.INVISIBLE);
                   tvTimer.setText("0" + "s");
                   if (score > 10)
                       tvresult.setText("Well done..Your Score is: " + Integer.toString(score) + " / " + Integer.toString(ques));


                   else
                       tvresult.setText("Below Average..Your score is: " + Integer.toString(score) + " / " + Integer.toString(ques));

               }
           }.start();


        generateQ();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
tvTimer=(TextView)findViewById(R.id.timerTextView);
        tvresult = (TextView)findViewById(R.id.resultTextView);
        tvpoint=(TextView)findViewById(R.id.pointsTextView);
         button0 = (Button)findViewById(R.id.button20);
        button1 = (Button)findViewById(R.id.button21);
         button2 = (Button)findViewById(R.id.button22);
         button3 = (Button)findViewById(R.id.button23);
        tvsum = (TextView)findViewById(R.id.sumTextView);
        em = (RelativeLayout)findViewById(R.id.was);
        em2 =(RelativeLayout)findViewById(R.id.was2);
        em2.setVisibility(View.INVISIBLE);
        playAgi=(Button)findViewById(R.id.playAg);
         gd = (GridLayout)findViewById(R.id.gridLayout);
        em.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAg));

    }







    public  void generateQ(){
        Random r =new Random();
        int a= r.nextInt(21);
        int b=r.nextInt(21);
        tvsum.setText(Integer.toString(a)+" + "+Integer.toString(b));
        answerLocation=r.nextInt(4);
        numbers.clear();
        for(int i=0;i<4;i++){
            if(i==answerLocation){
                numbers.add(a+b);
            }
            else{
                int incorrect;
                incorrect=r.nextInt(41);
                while(incorrect==(a+b)){
                    incorrect=r.nextInt(41);
                }
                numbers.add(incorrect);

            }
        }
        button0.setText(Integer.toString(numbers.get(0)));
        button1.setText(Integer.toString(numbers.get(1)));
        button2.setText(Integer.toString(numbers.get(2)));
        button3.setText(Integer.toString(numbers.get(3)));


    }








    public void vis(View v){
       //  em = (RelativeLayout)findViewById(R.id.was);
        em.setVisibility(View.INVISIBLE);
        // em2 =(RelativeLayout)findViewById(R.id.was2);
        em2.setVisibility(View.VISIBLE);
    }
    public void chooseAnswer(View v){
        //Log.i("info", (String) v.getTag());
        if(v.getTag().toString().equals(Integer.toString(answerLocation))){
            score++;
           // tvresult = (TextView)findViewById(R.id.resultTextView);
            tvresult.setText("Correct!!!");
        }
        else
        {
            tvresult.setText("Incorrect!!!");
        }
        ques++;
        tvpoint.setText(Integer.toString(score)+" / "+Integer.toString(ques));
        generateQ();
    }
}
