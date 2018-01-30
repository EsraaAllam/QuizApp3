package com.example.android.quizapp;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //insert next bit under onCreate method
    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("SCORE", score);
        outState.putString("MESSAGE",message);
    }

    /**
     * Saves scores if screen rewritten
     *
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        score = savedInstanceState.getInt("SCORE");
        message = savedInstanceState.getString("MESSAGE");
    }

    /**
     *
     * @return the score for the first question
     */
    private int checkFirstQuestion()
    {
        CheckBox firstChoiceQues1 = (CheckBox) findViewById(R.id.first_choice_q1);
        CheckBox secondChoiceQues1 = (CheckBox) findViewById(R.id.second_choice_q1);
        CheckBox thirdChoiceQues1 = (CheckBox) findViewById(R.id.third_choice_q1);
        CheckBox fouthChoiceQues1 = (CheckBox) findViewById(R.id.fourth_choice_q1);
        if((!firstChoiceQues1.isChecked()) &&  (!secondChoiceQues1.isChecked()) && (!thirdChoiceQues1.isChecked()) && (!fouthChoiceQues1.isChecked()) ){
            Toast.makeText(this,"Please, Enter the First Question !!!",Toast.LENGTH_SHORT).show();
            return -1;
        }
        else if(firstChoiceQues1.isChecked() && thirdChoiceQues1.isChecked()){
            score++;
        }
        return score;
    }

    /**
     *
     * @return the score for the second question
     */
    private int chekSecondQuestion(){
        EditText editTextQues2 = (EditText) findViewById(R.id.edit_view_question_two);
        if(editTextQues2.getText().toString().isEmpty()){
            Toast.makeText(this,"Please, Enter the Second Question !!!",Toast.LENGTH_SHORT).show();
            return -1;
        }
        String textValue = editTextQues2.getText().toString();
        try{
            if(Integer.parseInt(textValue) == 15){
                score++;
                Log.v("MainActivity","The is a number "+score);
            }
        }
        catch (NumberFormatException e){
            Log.v("MainActivity","The is a number "+score);
        }
        return score;
    }

    /**
     *
     * @return the score for the Third question
     */
    private int checkThirdQuestion(){
        RadioButton firstChoiceQues3 = (RadioButton) findViewById(R.id.yes_radio_button);
        RadioButton secondChoiceQues3 = (RadioButton) findViewById(R.id.no_radio_button);
        if((!firstChoiceQues3.isChecked()) && (!secondChoiceQues3.isChecked()))
        {
            Toast.makeText(this,"Please, Enter the Third Question !!!",Toast.LENGTH_SHORT).show();
            return -1;
        }
        else if(firstChoiceQues3.isChecked()){
            score++;
        }
        return score;
    }

    /**
     *
     * @return the score for the four question
     */
    private int checkFourQuestion(){
        RadioButton firstChoiceQues4 = (RadioButton) findViewById(R.id.qfour_one_radio_button);
        RadioButton secondChoiceQues4 = (RadioButton) findViewById(R.id.qfour_two_radio_button);
        RadioButton thirdChoiceQues4 = (RadioButton) findViewById(R.id.qfour_three_radio_button);
        if((!firstChoiceQues4.isChecked()) && (!secondChoiceQues4.isChecked()) && (!thirdChoiceQues4.isChecked()))
        {
            Toast.makeText(this,"Please, Enter the Four Question !!!",Toast.LENGTH_SHORT).show();
            return -1;
        }
        else if(thirdChoiceQues4.isChecked()){
            score++;
        }
        return score;
    }

    /**
     *
     * @return the score for the five question
     */
    private int checkFiveQuestion(){
        RadioButton firstChoiceQues5 = (RadioButton) findViewById(R.id.qfive_one_radio_button);
        RadioButton secondChoiceQues5 = (RadioButton) findViewById(R.id.qfive_two_radio_button);
        RadioButton thirdChoiceQues5 = (RadioButton) findViewById(R.id.qfive_three_radio_button);
        if((!firstChoiceQues5.isChecked()) && (!secondChoiceQues5.isChecked()) && (!thirdChoiceQues5.isChecked()))
        {
            Toast.makeText(this,"Please, Enter the Five Question !!!",Toast.LENGTH_SHORT).show();
            return -1;
        }
        else if(secondChoiceQues5.isChecked()){
            score++;
        }
        return score;
    }

    /**
     *
     * @param view to reset all the Quiz
     *
     */
    public void resetScore(View view)
    {
        score = 0;
        message = "";

        EditText learnerName = (EditText) findViewById(R.id.edit_view_enter_name);
        learnerName.getText().clear();

        CheckBox firstChoiceQues1 = (CheckBox) findViewById(R.id.first_choice_q1);
        firstChoiceQues1.setChecked(false);
        CheckBox secondChoiceQues1 = (CheckBox) findViewById(R.id.second_choice_q1);
        secondChoiceQues1.setChecked(false);
        CheckBox thirdChoiceQues1 = (CheckBox) findViewById(R.id.third_choice_q1);
        thirdChoiceQues1.setChecked(false);
        CheckBox fouthChoiceQues1 = (CheckBox) findViewById(R.id.fourth_choice_q1);
        fouthChoiceQues1.setChecked(false);

        EditText editTextQues2 = (EditText) findViewById(R.id.edit_view_question_two);
        editTextQues2.getText().clear();

        RadioButton firstChoiceQues3 = (RadioButton) findViewById(R.id.yes_radio_button);
        firstChoiceQues3.setChecked(false);
        RadioButton secondChoiceQues3 = (RadioButton) findViewById(R.id.no_radio_button);
        secondChoiceQues3.setChecked(false);

        RadioButton firstChoiceQues4 = (RadioButton) findViewById(R.id.qfour_one_radio_button);
        firstChoiceQues4.setChecked(false);
        RadioButton secondChoiceQues4 = (RadioButton) findViewById(R.id.qfour_two_radio_button);
        secondChoiceQues4.setChecked(false);
        RadioButton thirdChoiceQues4 = (RadioButton) findViewById(R.id.qfour_three_radio_button);
        thirdChoiceQues4.setChecked(false);

        RadioButton firstChoiceQues5 = (RadioButton) findViewById(R.id.qfive_one_radio_button);
        firstChoiceQues5.setChecked(false);
        RadioButton secondChoiceQues5 = (RadioButton) findViewById(R.id.qfive_two_radio_button);
        secondChoiceQues5.setChecked(false);
        RadioButton thirdChoiceQues5 = (RadioButton) findViewById(R.id.qfive_three_radio_button);
        thirdChoiceQues5.setChecked(false);
        displayScore(" ");
    }

    /**
     *
     * @param name the name of learner
     * @param flag to check which message will display on screeen
     * @return the message
     */
    private String resultMassege(String name, int flag)
    {

        String resultMessage ;
        if(flag == 1){
            resultMessage = "Congratulation !!!  "+name ;
            resultMessage += "\n   You Grade: 5 / 5";
        }
        else
        {
            resultMessage = "Great Job !!!  "+name ;
            resultMessage += "\n   You Grade: "+score+" / 5";
        }
        return resultMessage;
    }

    public void submitScore(View view){
        EditText learnerName = (EditText) findViewById(R.id.edit_view_enter_name);
        String name = learnerName.getText().toString();
        if(name.isEmpty()){
            Toast.makeText(this,"Please, Enter Your Name !!!",Toast.LENGTH_SHORT).show();
        }
        else {
            if ((checkFirstQuestion() != -1) && (chekSecondQuestion() != -1) && (checkThirdQuestion() != -1) && (checkFourQuestion() != -1) && (checkFiveQuestion() != -1)) {
                if (score == 5) {
                    message = resultMassege(name, 1);
                    displayScore(message);
                } else {
                    message = resultMassege(name, 2);
                    displayScore(message);
                }
            }
            score = 0;
        }
    }

    private void displayScore(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.score_text_view);
        orderSummaryTextView.setText(message);
    }
}
