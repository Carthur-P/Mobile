package pongp1.bit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        TextView score = (TextView) findViewById(R.id.textView2);
        Intent fetchIntent = getIntent();
        int finalScore = fetchIntent.getIntExtra("score", 0);
        score.setText(Integer.toString(finalScore) + "/11");

        Button playAgainButton = (Button) findViewById(R.id.button1);
        Button exitButton = (Button) findViewById(R.id.button2);
        playAgainButton.setOnClickListener(new OnPlayAgainButtonClickHandler());
        exitButton.setOnClickListener(new OnExitClickHandler());
    }

    public class OnPlayAgainButtonClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ScoreScreen.this, QuestionScreen.class));
        }
    }

    public class OnExitClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }
}
