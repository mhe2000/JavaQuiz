package com.example.maryjean.javaquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maryjean on 2/10/2016.
 */
public class QuestionBank {
    public List<Question> mQuestionList = new ArrayList<>();
    public int mCurrentIndex = 0;


    public QuestionBank(){
        mQuestionList.add(new Question(R.string.question_primates, false));
        mQuestionList.add(new Question(R.string.question_humans, true));
        mQuestionList.add(new Question(R.string.question_koala, false));
        mQuestionList.add(new Question(R.string.question_porcupine, false));
    }

    public List<Question> getQuestionList() {
        return mQuestionList;
    }

    public void setQuestionList(List<Question> questionList) {
        mQuestionList = questionList;
    }

    public int getCurrentIndex() {
        return mCurrentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        mCurrentIndex = currentIndex;
    }
}
