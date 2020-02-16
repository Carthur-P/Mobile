package pongp1.bit;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("textColour", R.color.textColour);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
