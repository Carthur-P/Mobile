package pongp1.bit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder confirmAlert;
    TextView messageBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public class OnClickHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Spinner monthSpinner = (Spinner) findViewById(R.id.spinner1);
            RadioGroup instruments = (RadioGroup) findViewById(R.id.radioGroupInstruments);
            RadioButton chosen = (RadioButton) findViewById(instruments.getCheckedRadioButtonId());

            if(instruments.getCheckedRadioButtonId() == -1)//no radio button is checked, id can't be -1
            {
                Toast.makeText(MainActivity.this, "Please select an instrument you want to learn", Toast.LENGTH_LONG).show();
            }

            else
            {
                confirmAlert = new AlertDialog.Builder(MainActivity.this);
                confirmAlert.setTitle("Confirm your enrollment to " + chosen.getText().toString() + " lesson");
                confirmAlert.setIcon(R.drawable.icon);
                confirmAlert.setPositiveButton("Yes", new OnPositiveClickHandler());
                confirmAlert.setNegativeButton("No", new OnNegativeClickHandler());
                confirmAlert.create();
                confirmAlert.show();
            }
        }
    }

    public class OnPositiveClickHandler implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            messageBox = findViewById(R.id.textView4);
            messageBox.setText("Thank you! you are now enrolled");
            messageBox.setVisibility(View.VISIBLE);
        }
    }

    public class OnNegativeClickHandler implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            messageBox = findViewById(R.id.textView4);
            messageBox.setText("That's a shame, maybe a different instrument?");
            messageBox.setVisibility(View.VISIBLE);
        }
    }
}
