package pongp1.bit;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = "Friday Febuary dates are: ";
        Resources r = getResources();
        int dateArray[] = r.getIntArray(R.array.febFriday);
        TextView date = (TextView) findViewById(R.id.textView1);
        for (int friDate : dateArray )
        {
            text += " " + Integer.toString(friDate);
        }
        date.setText(text);
    }
}
