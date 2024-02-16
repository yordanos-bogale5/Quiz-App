package com.example.quiz_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton[] radioButtons;
    private Button answerButton;

    private int currentQuestionIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize UI elements
        questionTextView = view.findViewById(R.id.questionTextView);
        radioGroup = view.findViewById(R.id.radioGroup);
        radioButtons = new RadioButton[4]; // Assuming you have 4 choices
        radioButtons[0] = view.findViewById(R.id.radioButton1);
        radioButtons[1] = view.findViewById(R.id.radioButton2);
        radioButtons[2] = view.findViewById(R.id.radioButton3);
        radioButtons[3] = view.findViewById(R.id.radioButton4);
        answerButton = view.findViewById(R.id.answerButton);

        // Set the current question and choices
        setQuestionAndChoices();

        // Set up an onClickListener for the answer button
        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the user's answer (replace this with your actual logic)
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = view.findViewById(selectedRadioButtonId);
                    String userAnswer = selectedRadioButton.getText().toString();
                    String correctAnswer = QuestionAnswer.correctAnswers[currentQuestionIndex];

                    if (userAnswer.equals(correctAnswer)) {
                        // User's answer is correct
                        // Handle correct answer logic
                    } else {
                        // User's answer is incorrect
                        // Handle incorrect answer logic
                    }
                }
                // Move to the next question
                currentQuestionIndex++;
                if (currentQuestionIndex < QuestionAnswer.question.length) {
                    setQuestionAndChoices();
                } else {
                    // All questions answered, show quiz completion logic
                }
            }
        });

        return view;
    }

    private void setQuestionAndChoices() {
        // Set the current question and choices
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(QuestionAnswer.choices[currentQuestionIndex][i]);
        }
        // Clear the radio group selection
        radioGroup.clearCheck();
    }
}
