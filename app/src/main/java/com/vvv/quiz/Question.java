package com.vvv.quiz;

public class Question {
    private final boolean hasImage;
    private String questionText;
    private int imageResourceId;
    private String[] choices;
    private String correctAnswer;
    private String selectedChoice;
    private boolean answeredCorrectly;

    public Question(String questionText, String[] choices, String correctAnswer) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.hasImage = false;
        this.selectedChoice = null;
        this.answeredCorrectly = false;
    }

    public Question(String questionText, String[] choices, String correctAnswer, int imageResourceId) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.imageResourceId = imageResourceId;
        this.hasImage = true;
        this.selectedChoice = null;
        this.answeredCorrectly = false;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean hasImage() {
        return hasImage;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getSelectedChoice() {
        return selectedChoice;
    }

    public void setSelectedChoice(String selectedChoice) {
        this.selectedChoice = selectedChoice;
    }

    public boolean isAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }

}


