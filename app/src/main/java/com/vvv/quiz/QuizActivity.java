package com.vvv.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int currentSetNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();

        if (intent.hasExtra("SET")) {
            currentSetNumber = intent.getIntExtra("SET", 1);
        }

        questions = QuizUtils.generateRandomQuestions(5, currentSetNumber);

        showQuestionFragment();

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            onBackPressed();
        });
        ImageView about = findViewById(R.id.about);
        about.setOnClickListener(v -> {
            Intent aboutintent = new Intent(this, AboutActivity.class);
            startActivity(aboutintent);
        });
    }

    void showQuestionFragment() {
        if (currentQuestionIndex < questions.size()) {
            QuestionFragment questionFragment = new QuestionFragment(questions.get(currentQuestionIndex));
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragmentContainer, questionFragment);
            transaction.commit();
        } else {
            int score = calculateScore();
            if (currentSetNumber == 1 && score >= 0) {
                showScore(score);
            } else {
                switchToNextSet();
            }
        }
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    private void showScore(int score) {
        Intent scoreIntent = new Intent(this, WinActivity.class);
        scoreIntent.putExtra("SCORE", score);
        startActivity(scoreIntent);
        finish();
    }

    private int calculateScore() {
        int correctAnswers = 0;
        int wrongAnswers = 0;

        for (Question question : questions) {
            String selectedChoice = question.getSelectedChoice();
            String correctAnswer = question.getCorrectAnswer();

            if (selectedChoice != null && selectedChoice.equals(correctAnswer)) {
                correctAnswers++;
            } else {
                wrongAnswers++;
            }
        }
        return (correctAnswers * 10) - (wrongAnswers * 5);
    }

    private void switchToNextSet() {
        currentSetNumber++;
        if (currentSetNumber <= 5) {
            questions = QuizUtils.generateRandomQuestions(5, currentSetNumber);
            currentQuestionIndex = 0;
            showQuestionFragment();
        } else {
            int finalScore = calculateScore();
            Intent intent = new Intent(this, WinActivity.class);
            intent.putExtra("SCORE", finalScore);
            startActivity(intent);
            finish();
        }
    }

}
