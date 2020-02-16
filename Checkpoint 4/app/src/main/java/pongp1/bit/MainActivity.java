package pongp1.bit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public class OnClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent nextActivity = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(nextActivity);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.constraint.ConstraintLayout screen = (android.support.constraint.ConstraintLayout) findViewById(R.id.screen1);
        screen.setOnClickListener(new OnClickHandler());
    }
}
