package pongp1.bit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public class ConfirmChoice implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            RadioGroup instruments = (RadioGroup) findViewById(R.id.radioGroupInstruments);
            RadioButton chosen = (RadioButton) findViewById(instruments.getCheckedRadioButtonId());
            Toast.makeText(MainActivity.this, "Thank you! you are now enrolled to play the " + chosen.getText(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirm = (Button) findViewById(R.id.button1);
        confirm.setOnClickListener(new ConfirmChoice());
    }
}
