package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * This app is a science based quiz that provides a score message at upon pressing submit.
 */
public class MainActivity extends AppCompatActivity {

    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;

    EditText answer5;
    RadioButton answer6;

    RadioButton answer8;
    EditText answer9;
    RadioButton answer10;

    RadioGroup clear1;
    RadioGroup clear2;
    RadioGroup clear3;
    RadioGroup clear6;
    RadioGroup clear8;
    RadioGroup clear10;

    CheckBox clear4a;
    CheckBox clear4b;
    CheckBox clear4c;
    CheckBox clear4d;
    CheckBox clear7a;
    CheckBox clear7b;
    CheckBox clear7c;
    CheckBox clear7d;

    Button showReset;

    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when you the SUBMIT button is clicked. It also reveals the RESET button when pressed for the first time.
     */
    public void submitAnswers(View view) {
        answer1 = (RadioButton) findViewById(R.id.q1b);
        answer2 = (RadioButton) findViewById(R.id.q2d);
        answer3 = (RadioButton) findViewById(R.id.q3true);
        answer5 = (EditText) findViewById(R.id.q5answer);
        answer6 = (RadioButton) findViewById(R.id.q6b);
        answer8 = (RadioButton) findViewById(R.id.q8true);
        answer9 = (EditText) findViewById(R.id.q9answer);
        answer10 = (RadioButton) findViewById(R.id.q10d);

        showReset = (Button) findViewById(R.id.resetButton);
        if (showReset.getVisibility() == View.INVISIBLE) {
            showReset.setVisibility(View.VISIBLE);
        }

        calculateScore();
        scoreMessage();
    }

    /**
     * This method is called when the RESET button is clicked.
     */
    public void resetAnswers(View view) {
        clear1 = (RadioGroup) findViewById(R.id.q1group);
        clear1.clearCheck();
        clear2 = (RadioGroup) findViewById(R.id.q2group);
        clear2.clearCheck();
        clear3 = (RadioGroup) findViewById(R.id.q3group);
        clear3.clearCheck();
        clear6 = (RadioGroup) findViewById(R.id.q6group);
        clear6.clearCheck();
        clear8 = (RadioGroup) findViewById(R.id.q8group);
        clear8.clearCheck();
        clear10 = (RadioGroup) findViewById(R.id.q10group);
        clear10.clearCheck();

        answer5.setText(null);
        answer9.setText(null);

        clear4a = (CheckBox) findViewById(R.id.q4a);
        if (clear4a.isChecked()) {
            clear4a.setChecked(false);
        }
        clear4b = (CheckBox) findViewById(R.id.q4b);
        if (clear4b.isChecked()) {
            clear4b.setChecked(false);
        }
        clear4c = (CheckBox) findViewById(R.id.q4c);
        if (clear4c.isChecked()) {
            clear4c.setChecked(false);
        }
        clear4d = (CheckBox) findViewById(R.id.q4d);
        if (clear4d.isChecked()) {
            clear4d.setChecked(false);
        }
        clear7a = (CheckBox) findViewById(R.id.q7a);
        if (clear7a.isChecked()) {
            clear7a.setChecked(false);
        }
        clear7b = (CheckBox) findViewById(R.id.q7b);
        if (clear7b.isChecked()) {
            clear7b.setChecked(false);
        }
        clear7c = (CheckBox) findViewById(R.id.q7c);
        if (clear7c.isChecked()) {
            clear7c.setChecked(false);
        }
        clear7d = (CheckBox) findViewById(R.id.q7d);
        if (clear7d.isChecked()) {
            clear7d.setChecked(false);
        }
        result = 0;
    }

    /**
     * This method creates the toast message displayed when the SUBMIT button is clicked.
     */
    private void scoreMessage() {
        if (result == 10) {
            Toast.makeText(this, "You got a perfect score! Congratulations!", Toast.LENGTH_SHORT).show();
        }
        if ((result > 5) && (result <= 9)) {
            Toast.makeText(this, "You scored " + result + " out of 10! Good job!", Toast.LENGTH_SHORT).show();
        }
        if ((result <= 5) && (result > 2)) {
            Toast.makeText(this, "You scored " + result + " out of 10! Nice try!", Toast.LENGTH_SHORT).show();
        }
        if (result <= 2) {
            Toast.makeText(this, "You scored " + result + " out of 10! Go study!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method calculates the score based on the users answers.
     */
    private void calculateScore() {
        int score = 0;

        if (answer1.isChecked()) {
            score += 1;
        }
        if (answer2.isChecked()) {
            score += 1;
        }
        if (answer3.isChecked()) {
            score += 1;
        }
        CheckBox fourA = findViewById(R.id.q4a);
        CheckBox fourB = findViewById(R.id.q4b);
        CheckBox fourC = findViewById(R.id.q4c);
        CheckBox fourD = findViewById(R.id.q4d);
        if (fourA.isChecked() && !fourB.isChecked() && !fourC.isChecked() && fourD.isChecked()) {
            score += 1;
        }
        if (answer5.getText().toString().toUpperCase().equals("ETHANOL")) {
            score += 1;
        }
        if (answer6.isChecked()) {
            score += 1;
        }
        CheckBox sevenA = findViewById(R.id.q7a);
        CheckBox sevenB = findViewById(R.id.q7b);
        CheckBox sevenC = findViewById(R.id.q7c);
        CheckBox sevenD = findViewById(R.id.q7d);
        if (sevenA.isChecked() && !sevenB.isChecked() && sevenC.isChecked() && !sevenD.isChecked()) {
            score += 1;
        }
        if (answer8.isChecked()) {
            score += 1;
        }
        if (answer9.getText().toString().toUpperCase().equals("NALOXONE")) {
            score += 1;
        }
        if (answer10.isChecked()) {
            score += 1;
        }

        result = score;
    }

}
