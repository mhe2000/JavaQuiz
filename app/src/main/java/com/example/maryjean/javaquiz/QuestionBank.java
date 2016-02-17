package com.example.maryjean.javaquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      Maryjean Emerson <maryjean_emerson@hotmail.com>
 * @version     1.15               (current version number of program)
 *
 * Create an array list to hold multiple true and false questions
 * as well as the answer (either True or False) from the strings.xml file.
 *
 *
 */
class QuestionBank {
    private final List<Question> mQuestionList = new ArrayList<>();
    private int mCurrentIndex = -1;


    public QuestionBank(){
        mQuestionList.add(new Question(R.string.question_primates, false));
        mQuestionList.add(new Question(R.string.question_humans, true));
        mQuestionList.add(new Question(R.string.question_koala, false));
        mQuestionList.add(new Question(R.string.question_porcupine, false));
    }


    public Question getNextQuestion(){
        if (mCurrentIndex < mQuestionList.size()-1){
            mCurrentIndex++;
        }
        return mQuestionList.get(mCurrentIndex);
    }
    public Question getPreviousQuestion(){
        if (mCurrentIndex > 0){
            mCurrentIndex--;
        }
        return mQuestionList.get(mCurrentIndex);
    }
}
