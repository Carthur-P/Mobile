package pongp1.bit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout screen = (LinearLayout) findViewById(R.id.screen1);
        screen.setOnClickListener(new OnClickHandler());
    }

    public class OnClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, QuestionScreen.class));
        }
    }
}
