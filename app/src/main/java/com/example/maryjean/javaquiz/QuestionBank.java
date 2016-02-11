package com.example.maryjean.javaquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maryjean on 2/10/2016.
 */
class QuestionBank {
    private List<Question> mQuestionList = new ArrayList<>();
    private int mCurrentIndex = -1;


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
