package pongp1.bit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    public class GoToWebsite implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Intent goToNextActivity = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.op.ac.nz/hub"));
            startActivity(goToNextActivity);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button nextButton = (Button) findViewById(R.id.button1);
        nextButton.setOnClickListener(new GoToWebsite());
    }
}
