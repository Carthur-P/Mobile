package pongp1.bit;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionScreen extends AppCompatActivity {

    QuestionSetup q = new QuestionSetup();
    ArrayList<Question> questions = q.getQuestionArray();
    int index = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);
        setupQuestion();
        loadQuestion();
        index = 0;
        score = 0;

        Button submitButton = (Button) findViewById(R.id.button1);
        Button nextButton = (Button) findViewById(R.id.button2);
        submitButton.setOnClickListener(new OnSubmitClickHandler());
        nextButton.setOnClickListener(new OnNextClickHandler());
    }

    public void setupQuestion() {
        Collections.shuffle(questions);
    }

    public void loadQuestion() {
        TextView word = (TextView) findViewById(R.id.textView1);
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        word.setText(questions.get(index).getQuestion());
        image.setImageResource(questions.get(index).imageID);
    }

    public class OnSubmitClickHandler implements View.OnClickListener {
        Button submitButton = (Button) findViewById(R.id.button1);
        Button nextButton = (Button) findViewById(R.id.button2);
        RadioGroup answerGroup = (RadioGroup) findViewById(R.id.answerGroup);
        RadioButton der = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton die = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton das = (RadioButton) findViewById(R.id.radioButton3);

        @Override
        public void onClick(View v) {
            RadioButton chosen = (RadioButton) findViewById(answerGroup.getCheckedRadioButtonId());
            submitButton.setEnabled(false);
            nextButton.setEnabled(true);

            if (chosen.getText().equals(questions.get(index).getAnswer())) {
                chosen.setTextColor(Color.GREEN);
                score ++;
            }

            else {
                chosen.setTextColor(Color.RED);

                switch (questions.get(index).getAnswer()) {
                    case "Der":
                        der.setTextColor(Color.GREEN);
                        break;

                    case "Die":
                        die.setTextColor(Color.GREEN);
                        break;

                    case "Das":
                        das.setTextColor(Color.GREEN);
                        break;
                }
            }
        }
    }

    public class OnNextClickHandler implements View.OnClickListener {
        Button submitButton = (Button) findViewById(R.id.button1);
        Button nextButton = (Button) findViewById(R.id.button2);
        RadioGroup answerGroup = (RadioGroup) findViewById(R.id.answerGroup);
        RadioButton der = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton die = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton das = (RadioButton) findViewById(R.id.radioButton3);

        @Override
        public void onClick(View v) {
            if (index < questions.size() - 1) {
                index ++;
                nextButton.setEnabled(false);
                submitButton.setEnabled(true);
                der.setTextColor(Color.BLACK);
                die.setTextColor(Color.BLACK);
                das.setTextColor(Color.BLACK);
                loadQuestion();
                answerGroup.clearCheck();
            }

            else {
                Intent moveToScoreScreen = new Intent(QuestionScreen.this, ScoreScreen.class);
                moveToScoreScreen.putExtra("score", score);
                startActivity(moveToScoreScreen);
            }
        }
    }

}
