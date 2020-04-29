package pongp1.bit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button confirm = (Button) findViewById(R.id.button1);
        confirm.setOnClickListener(new onButtonClickHandler());
    }

    public class onButtonClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText username = (EditText) findViewById(R.id.editText1);
            Intent returnIntent = new Intent(MainActivity2.this, MainActivity.class);
            returnIntent.putExtra("username", username.getText().toString());
            startActivity(returnIntent);
        }
    }
}
