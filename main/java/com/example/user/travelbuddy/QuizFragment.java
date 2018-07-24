package com.example.user.travelbuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.constraint.Constraints.TAG;

public class QuizFragment extends Fragment {
    private static final String KEY_INDEX = "index";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private TextView mScoreLabel;
    int score=0;
    int i=0;
    int counter=0;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_one, true),
            new Question(R.string.question_two, false),
            new Question(R.string.question_three, false),
            new Question(R.string.question_four, true),
            new Question(R.string.question_five, true),
    };

    private int mCurrentIndex = 0;
    public QuizFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_quiz,container,false);

        mQuestionTextView = (TextView) view.findViewById(R.id.question_text_view);
        mTrueButton = (Button) view.findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mFalseButton = (Button) view.findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mScoreLabel=(TextView) view.findViewById(R.id.score_label);

        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }
        updateQuestion();



        return view;
    }

    private void updateQuestion() {
        if (counter<5) {
            int question = mQuestionBank[mCurrentIndex].getTextResId();
            mQuestionTextView.setText(question);
            counter += 1;
        }
        else{
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

            dlgAlert.setMessage("You have completed the quiz!\nYour score: "+score);
            dlgAlert.setTitle("Quiz");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
//dismiss the dialog
                        }
                    });
        }
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
            score+=1;
        }
        else {
            messageResId = R.string.incorrect_toast;
            score+=0;
        }

        Toast.makeText(QuizFragment.super.getContext(),messageResId, Toast.LENGTH_SHORT).show();
        mScoreLabel.setText("Your score: "+score);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }


}
