package com.example.brandon.geoquiz;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class CheatActivity extends AppCompatActivity
{
    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.brandon.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.brandon.geoquiz.answer_shown";
    public static final String KEY_CHEAT = "cheat";
    private boolean mAnswerIsTrue;
    private boolean mIsAnswerShown = false;
    private TextView mAnswerTextView;
    private Button mShowAnswer;


    private void setAnswerShownResult(boolean isAnswerShown)
    {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        setAnswerShownResult(mIsAnswerShown);//Answer will not be shown until the user presses the button
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue)
                    mAnswerTextView.setText(R.string.true_button);
                else
                    mAnswerTextView.setText(R.string.false_button);
                mIsAnswerShown = true;
                setAnswerShownResult(mIsAnswerShown);
            }
        });
    }//end onCreate()

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY_CHEAT, mIsAnswerShown);
    }
}//end CheatActivity class
