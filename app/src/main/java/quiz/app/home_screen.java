// File: src/main/java/quiz/app/HomeFragment.java
package quiz.app;

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
    private RadioButton radioButtonA, radioButtonB, radioButtonC, radioButtonD;
    private Button btnSubmit;

    private int currentQuestionIndex = 0;  // Index to track the current question

    private String questions[] = {
            "What is 10+26 ?",
            "Who invented Telephone?",
            "What is 12*9 ?",
            "Who is the founder of SpaceX?",
            "In the given options, which is the example of System Software?"
    };

    private String choices[][] = {
            {"32", "42", "36", "38"},
            {"Graham Bell", "Einstein", "Edison", "None of the above"},
            {"96", "84", "102", "108"},
            {"Jeff Bezos", "Elon Musk", "Steve Jobs", "Bill Gates"},
            {"Windows", "Linux", "MacOS", "All of the above"}
    };

    private String correctAnswers[] = {
            "36",
            "Graham Bell",
            "108",
            "Elon Musk",
            "All of the above"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        questionTextView = view.findViewById(R.id.questionTextView);
        radioGroup = view.findViewById(R.id.radioGroup);
        radioButtonA = view.findViewById(R.id.radioButtonA);
        radioButtonB = view.findViewById(R.id.radioButtonB);
        radioButtonC = view.findViewById(R.id.radioButtonC);
        radioButtonD = view.findViewById(R.id.radioButtonD);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        displayQuestion();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
                // Move to the next question
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    displayQuestion();
                } else {
                    // Display a message or navigate to the result screen
                }
            }
        });

        return view;
    }

    private void displayQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        radioButtonA.setText(choices[currentQuestionIndex][0]);
        radioButtonB.setText(choices[currentQuestionIndex][1]);
        radioButtonC.setText(choices[currentQuestionIndex][2]);
        radioButtonD.setText(choices[currentQuestionIndex][3]);

        // Clear the selected radio button
        radioGroup.clearCheck();
    }

    private void checkAnswer() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = getView().findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            String correctAnswer = correctAnswers[currentQuestionIndex];
            // Compare selectedAnswer with correctAnswer and handle accordingly
            // You can display a message or update a score variable, etc.
        } else {
            // Handle the case where no option is selected
        }
    }
}
