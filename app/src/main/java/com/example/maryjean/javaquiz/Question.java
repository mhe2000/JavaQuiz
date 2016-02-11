package com.example.maryjean.javaquiz;

/**
 * Created by Maryjean on 2/10/2016.
 */
class Question {
    private int mTextResId;
    private boolean mAnswer;

    public Question(int textResId, boolean answer) {
        mTextResId = textResId;
        mAnswer = answer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswerTrue(boolean answer) {
        mAnswer = answer;
    }
}
