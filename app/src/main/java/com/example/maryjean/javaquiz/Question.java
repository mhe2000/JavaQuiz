package com.example.maryjean.javaquiz;

/**
 * @author      Maryjean Emerson <maryjean_emerson@hotmail.com>
 * @version     1.15               (current version number of program)
 *
 * Class created to contain the resource Id of the question in memory.
 * There is also a way to check if the answer is correct that the user chose.
 */
class Question {
    private final int mTextResId;
    private final boolean mAnswer;

    public Question(int textResId, boolean answer) {
        mTextResId = textResId;
        mAnswer = answer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }
}
