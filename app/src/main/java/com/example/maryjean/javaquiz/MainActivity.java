package com.example.maryjean.javaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;
    private Button mCheatButton;


    private final QuestionBank QuesBank = new QuestionBank();
    private static final String Tag = "Main";
    private static final String IndexKey = "index";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Tag, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mCheatButton = (Button) findViewById(R.id.cheat_button);

        final Question currentQuestion;

        if(savedInstanceState != null){
            int curQuestionIndex = savedInstanceState.getInt(IndexKey);
            QuesBank.setQuestionIndex(curQuestionIndex);
            Log.d(Tag, "onCreate: " + String.valueOf(curQuestionIndex));
            currentQuestion = QuesBank.getQuestion();
        }
        else{
            currentQuestion = QuesBank.getNextQuestion();
        }


        setUpQuestion(currentQuestion);

        Button mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIsComplete();
                setUpQuestion(QuesBank.getNextQuestion());
            }
        });

        Button mPreviousButton = (Button) findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpQuestion(QuesBank.getPreviousQuestion());
            }
        });
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cheat = new Intent(MainActivity.this, CheatActivity.class);
                startActivity(cheat);

            }
        });
    }

    public void checkIsComplete(){
        if(QuesBank.checkIfComplete()){
            Intent i = new Intent(MainActivity.this, CongratsActivity.class);
            startActivity(i);
            MainActivity.this.startActivity(i);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag, "onDestroy() called");
    }

    private void setUpQuestion(Question currentQuestion) {

        mQuestionTextView.setText(currentQuestion.getTextResId());

        if (currentQuestion.isAnswer()) {
            mTrueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuesBank.getQuestionAtIndex(QuesBank.getCurrentIndex()).allQuestionsCorrect = true;
                    checkIsComplete();
                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT)
                            .show();

                }
            });

            mFalseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuesBank.getQuestionAtIndex(QuesBank.getCurrentIndex()).allQuestionsCorrect = false;
                    checkIsComplete();
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT)
                            .show();

                }
            });
        }
        else {
            mTrueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuesBank.getQuestionAtIndex(QuesBank.getCurrentIndex()).allQuestionsCorrect = false;
                    checkIsComplete();
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT)
                            .show();

                }
            });

            mFalseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuesBank.getQuestionAtIndex(QuesBank.getCurrentIndex()).allQuestionsCorrect = true;
                    checkIsComplete();
                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT)
                            .show();

                }
            });
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState ){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(IndexKey, QuesBank.getQuestionIndex());
        Log.d(Tag, String.valueOf(QuesBank.getQuestionIndex()));
    }
}
