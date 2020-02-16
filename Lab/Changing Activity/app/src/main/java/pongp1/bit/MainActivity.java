package pongp1.bit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public class NextActivity implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Intent goToNextActivity = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(goToNextActivity);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = (Button) findViewById(R.id.button1);
        nextButton.setOnClickListener(new NextActivity());
    }
}
