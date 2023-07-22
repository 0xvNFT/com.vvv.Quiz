package com.vvv.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizUtils {

    private static final String[] SET1_QUESTIONS = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "What is the largest mammal on Earth?",
            "Who wrote the play 'Hamlet'?",
            "What is the chemical symbol for water?"
    };

    private static final String[][] SET1_CHOICES = {
            {"Paris", "London", "Berlin", "Rome"},
            {"Mars", "Venus", "Jupiter", "Saturn"},
            {"Blue Whale", "African Elephant", "Giraffe", "Hippopotamus"},
            {"William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain"},
            {"H", "O", "C", "N"}
    };

    private static final int[] SET1_IMAGES = {
            R.drawable.crown,
            R.drawable.sad,
            R.drawable.quiz_ic,
            R.drawable.quiz_act,
            R.drawable.info
    };

    private static final String[] SET2_QUESTIONS = {
            "What is the capital of Italy?",
            "Which planet is known as the Blue Planet?",
            "What is the tallest animal on Earth?",
            "Who wrote the play 'Romeo and Juliet'?",
            "What is the chemical symbol for oxygen?"
    };

    private static final String[][] SET2_CHOICES = {
            {"Rome", "Paris", "Berlin", "London"},
            {"Earth", "Venus", "Mars", "Mercury"},
            {"Giraffe", "African Elephant", "Blue Whale", "Hippopotamus"},
            {"William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain"},
            {"O", "H", "C", "N"}
    };

    private static final int[] SET2_IMAGES = {
            R.drawable.back,
            R.drawable.crown,
            R.drawable.info,
            R.drawable.sad,
            R.drawable.quiz_act
    };

    private static final String[] SET3_QUESTIONS = {
            "What is the capital of Japan?",
            "Which planet is known as the Ringed Planet?",
            "What is the fastest land animal?",
            "Who wrote the play 'Macbeth'?",
            "What is the chemical symbol for gold?"
    };

    private static final String[][] SET3_CHOICES = {
            {"Tokyo", "Beijing", "Seoul", "New Delhi"},
            {"Saturn", "Mars", "Jupiter", "Uranus"},
            {"Cheetah", "Lion", "Leopard", "Elephant"},
            {"William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain"},
            {"Au", "Ag", "Fe", "Pb"}
    };

    private static final int[] SET3_IMAGES = {
            R.drawable.quiz_act,
            R.drawable.crown,
            R.drawable.sad,
            R.drawable.back,
            R.drawable.info
    };

    private static final String[] SET4_QUESTIONS = {
            "What is the capital of Australia?",
            "Which planet is known as the Morning Star?",
            "What is the largest bird in the world?",
            "Who wrote the play 'The Great Gatsby'?",
            "What is the chemical symbol for silver?"
    };

    private static final String[][] SET4_CHOICES = {
            {"Canberra", "Sydney", "Melbourne", "Perth"},
            {"Venus", "Mars", "Jupiter", "Mercury"},
            {"Ostrich", "Penguin", "Eagle", "Albatross"},
            {"F. Scott Fitzgerald", "Jane Austen", "Charles Dickens", "Mark Twain"},
            {"Ag", "Au", "Fe", "Pb"}
    };

    private static final int[] SET4_IMAGES = {
            R.drawable.info,
            R.drawable.crown,
            R.drawable.sad,
            R.drawable.quiz_act,
            R.drawable.back
    };

    private static final String[] SET5_QUESTIONS = {
            "What is the capital of Brazil?",
            "Which planet is known as the Evening Star?",
            "What is the largest fish in the ocean?",
            "Who wrote the novel 'To Kill a Mockingbird'?",
            "What is the chemical symbol for carbon?"
    };

    private static final String[][] SET5_CHOICES = {
            {"Brasilia", "Rio de Janeiro", "Sao Paulo", "Buenos Aires"},
            {"Venus", "Mars", "Jupiter", "Mercury"},
            {"Whale Shark", "Blue Whale", "Great White Shark", "Giant Squid"},
            {"Harper Lee", "Jane Austen", "Charles Dickens", "Mark Twain"},
            {"C", "O", "H", "N"}
    };

    private static final int[] SET5_IMAGES = {
            R.drawable.quiz_ic,
            R.drawable.crown,
            R.drawable.back,
            R.drawable.sad,
            R.drawable.info
    };

    private static final boolean[] HAS_IMAGE_ARRAY = {false, false, false, false, false, true};

    public static List<Question> generateRandomQuestions(int numQuestions, int set) {
        List<Question> questions = new ArrayList<>();
        List<Integer> randomIndexes = new ArrayList<>();
        String[] questionSet;
        String[][] choiceSet;
        int[] imageSet;

        if (set == 1) {
            questionSet = SET1_QUESTIONS;
            choiceSet = SET1_CHOICES;
            imageSet = SET1_IMAGES;
        } else if (set == 2) {
            questionSet = SET2_QUESTIONS;
            choiceSet = SET2_CHOICES;
            imageSet = SET2_IMAGES;
        } else if (set == 3) {
            questionSet = SET3_QUESTIONS;
            choiceSet = SET3_CHOICES;
            imageSet = SET3_IMAGES;
        } else if (set == 4) {
            questionSet = SET4_QUESTIONS;
            choiceSet = SET4_CHOICES;
            imageSet = SET4_IMAGES;
        } else if (set == 5) {
            questionSet = SET5_QUESTIONS;
            choiceSet = SET5_CHOICES;
            imageSet = SET5_IMAGES;
        } else {
            questionSet = SET1_QUESTIONS;
            choiceSet = SET1_CHOICES;
            imageSet = SET1_IMAGES;
        }

        for (int i = 0; i < questionSet.length; i++) {
            randomIndexes.add(i);
        }
        Collections.shuffle(randomIndexes);

        for (int i = 0; i < numQuestions; i++) {
            int randomQuestionIndex = randomIndexes.get(i);
            String questionText = questionSet[randomQuestionIndex];
            int imageResourceId = HAS_IMAGE_ARRAY[randomQuestionIndex] ? imageSet[randomQuestionIndex] : 0;
            List<String> uniqueChoices = new ArrayList<>(Arrays.asList(choiceSet[randomQuestionIndex]));
            Collections.shuffle(uniqueChoices);
            String[] choices = uniqueChoices.toArray(new String[0]);

            String correctAnswer = choiceSet[randomQuestionIndex][0];

            Question question;
            if (imageResourceId != 0) {
                question = new Question(questionText, choices, correctAnswer, imageResourceId);
            } else {
                question = new Question(questionText, choices, correctAnswer);
            }
            questions.add(question);
        }

        return questions;
    }
}
