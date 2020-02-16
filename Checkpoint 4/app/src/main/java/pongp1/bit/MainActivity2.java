package pongp1.bit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    public class OnClickHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView messageBox = (TextView) findViewById(R.id.textView4);
            Spinner monthSpinner = (Spinner) findViewById(R.id.spinner1);
            RadioGroup instruments = (RadioGroup) findViewById(R.id.radioGroupInstruments);
            RadioButton chosen = (RadioButton) findViewById(instruments.getCheckedRadioButtonId());

            if(instruments.getCheckedRadioButtonId() == -1)//no radio button is checked
            {
                Toast.makeText(MainActivity2.this, "Please select an instrument you want to learn", Toast.LENGTH_LONG).show();
            }

            else
            {
                String message = "Thank you! You are now enrolled for " + chosen.getText() + " in " + monthSpinner.getSelectedItem().toString();
                messageBox.setText(message);
                messageBox.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //setting up the button
        Button enroll = (Button) findViewById(R.id.button1);
        enroll.setOnClickListener(new OnClickHandler());

        //setting up the spinner
        String[] months = {
                "January",
                "Febuary",
                "March",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        Spinner monthSpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, months);
        monthSpinner.setAdapter(monthAdapter);
    }
}
