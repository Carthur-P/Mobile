package pongp1.bit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button) findViewById(R.id.button1);
        TextView message = (TextView) findViewById(R.id.textView2);
        login.setOnClickListener(new onButtonClickHandler());

        Intent fetchIntent = getIntent();
        String username = fetchIntent.getStringExtra("username");

        if(username != null) {
            message.setText("You are logged in as " + username);
        }

        else
        {
            message.setText("You are not logged in");
        }
    }

    public class onButtonClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        }
    }
}
