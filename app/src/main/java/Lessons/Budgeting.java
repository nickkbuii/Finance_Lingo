package Lessons;

import androidx.appcompat.app.AppCompatActivity;

import database.Question;

public class Budgeting {

    //Budgeting debt_question prompts
    private String[] prompts = {
            "Which of the following categories does your post-tax income fall into?",
            "What is the percentage of your post-tax income that goes into savings?",
            "What is the percentage of your post-tax income that goes into expenses?",
            "What is the percentage of your post-tax income that goes into fun?",
            "Which of the following are considered expenses?"};

    //Budgeting answer options
    private String[][] choices = {
            {"Savings", "Expenses", "Fun", "All of the Above"},
            {"80%", "50%", "30%", "20%"},
            {"20%", "50%", "30%", "80%"},
            {"20%", "30%", "50%", "80%"},
            {"Rent", "Movie Tickets", "Stock", "All of the Above"}
    };
    //Correct answers to budgeting questions
    private String[] correctAnswers = {"All of the Above", "30%", "50%", "20%", "Rent"};

    //extend Budgeting.java to Question.java
    public Question question = new Question(prompts, choices, correctAnswers);
}
