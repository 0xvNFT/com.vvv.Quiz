package com.vvv.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizUtils {

    private static final String[] SET1_QUESTIONS = {
            "Which logo is this?",
            "Which animal is known as the 'King of the Jungle'?",
            "What is the largest planet in our solar system?",
            "Which country is famous for the Great Pyramid of Giza?",
            "What is the main ingredient in guacamole?"
    };

    private static final String[][] SET1_CHOICES = {
            {"Adidas", "Nike", "New Balance", "Converse"},
            {"Lion", "Elephant", "Tiger", "Giraffe"},
            {"Jupiter", "Saturn", "Neptune", "Mars"},
            {"Egypt", "Greece", "Italy", "China"},
            {"Avocado", "Tomato", "Onion", "Lime"}
    };

    private static final int[] SET1_IMAGES = {
            R.drawable.adidas,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable
    };

    private static final String[] SET2_QUESTIONS = {
            "Which city is known as the Big Apple?",
            "Who is known as the 'Father of Modern Physics'?",
            "What is the chemical symbol for gold?",
            "Which famous scientist developed the theory of relativity?",
            "What is this used for?"
    };

    private static final String[][] SET2_CHOICES = {
            {"New York City", "Los Angeles", "Chicago", "Houston"},
            {"Albert Einstein", "Isaac Newton", "Galileo Galilei", "Niels Bohr"},
            {"Au", "Ag", "G", "H2o"},
            {"Albert Einstein", "Isaac Newton", "Charles Darwin", "Niels Bohr"},
            {"Writing", "Speaking", "Reading", "Hunting"}
    };

    private static final int[] SET2_IMAGES = {
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.pen
    };

    private static final String[] SET3_QUESTIONS = {
            "Which instrument is known as the 'king of musical instruments'?",
            "What animal is this?",
            "What is the currency of Brazil?",
            "What is the main ingredient in hummus?",
            "Which river is the longest in the world?"
    };

    private static final String[][] SET3_CHOICES = {
            {"Piano", "Violin", "Guitar", "Flute"},
            {"Dog", "Bird", "Cat", "Person"},
            {"Real", "Euro", "Peso", "Dollar"},
            {"Chickpeas", "Lentils", "Eggplant", "Tomato"},
            {"Nile", "Amazon", "Yangtze", "Mississippi"}
    };

    private static final int[] SET3_IMAGES = {
            R.drawable.empty_drawable,
            R.drawable.dog,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable
    };

    private static final String[] SET4_QUESTIONS = {
            "Which country is known as the 'Land of the Pharaohs'?",
            "Which country is this flag?",
            "What is the chemical symbol for iron?",
            "Select the odd number below.",
            "What insect is this?"
    };

    private static final String[][] SET4_CHOICES = {
            {"Egypt", "Greece", "Rome", "India"},
            {"Vietnam", "China", "Japan", "Thailand"},
            {"Fe", "Ag", "Zn", "Au"},
            {"11", "92", "84", "08"},
            {"Ant", "Spider", "Frog", "Mosquito"}
    };

    private static final int[] SET4_IMAGES = {
            R.drawable.empty_drawable,
            R.drawable.vietnam,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable
    };

    private static final String[] SET5_QUESTIONS = {
            "What is the capital of Brazil?",
            "Which planet is known as the Evening Star?",
            "What is the largest fish in the ocean?",
            "Who wrote the novel 'To Kill a Mockingbird'?",
            "What is this called?"
    };

    private static final String[][] SET5_CHOICES = {
            {"Brasilia", "Rio de Janeiro", "Sao Paulo", "Buenos Aires"},
            {"Venus", "Mars", "Jupiter", "Mercury"},
            {"Whale Shark", "Blue Whale", "Great White Shark", "Giant Squid"},
            {"Harper Lee", "Jane Austen", "Charles Dickens", "Mark Twain"},
            {"Moon", "Sun", "Sky", "Star"}
    };

    private static final int[] SET5_IMAGES = {
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.empty_drawable,
            R.drawable.moon
    };

    private static final boolean[] HAS_IMAGE_ARRAY = {true, true, true, true, true};

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
