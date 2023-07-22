package com.vvv.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class QuestionFragment extends Fragment {

    private Question question;

    public QuestionFragment() {
    }

    public QuestionFragment(Question question) {
        this.question = question;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        TextView questionTextView = view.findViewById(R.id.questionTextView);
        ImageView questionImageView = view.findViewById(R.id.questionImageView);
        questionTextView.setText(question.getQuestionText());
        questionImageView.setImageResource(question.getImageResourceId());

        GridLayout choicesGridLayout = view.findViewById(R.id.choicesGridLayout);
        String[] choices = question.getChoices();
        for (int i = 0; i < choices.length; i++) {
            Button button = (Button) inflater.inflate(R.layout.custom_button, choicesGridLayout, false);
            button.setId(i);
            button.setText(choices[i]);
            int finalI = i;
            button.setOnClickListener(v -> onButtonClick(finalI));
            choicesGridLayout.addView(button);
        }
        if (question.hasImage()) {
            questionImageView.setVisibility(View.VISIBLE);
            questionImageView.setImageResource(question.getImageResourceId());
        } else {
            questionImageView.setVisibility(View.GONE);
        }
        return view;
    }

    private void onButtonClick(int choiceIndex) {
        String selectedChoice = question.getChoices()[choiceIndex];
        String correctAnswer = question.getCorrectAnswer();

        question.setSelectedChoice(selectedChoice);

        if (selectedChoice.equals(correctAnswer)) {
            question.setAnsweredCorrectly(true);
            ((QuizActivity) requireActivity()).setCurrentQuestionIndex(((QuizActivity) requireActivity()).getCurrentQuestionIndex() + 1);
            ((QuizActivity) requireActivity()).showQuestionFragment();
        } else {
            question.setAnsweredCorrectly(false);
            Intent loseIntent = new Intent(requireActivity(), LoseActivity.class);
            startActivity(loseIntent);
        }
    }
}

