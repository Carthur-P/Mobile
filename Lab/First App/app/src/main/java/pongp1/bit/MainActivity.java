package pongp1.bit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        String dogBreed = "";
        TextView randomText = (TextView) findViewById(R.id.randomText);
        int dogValue = rand.nextInt(4);

        switch(dogValue)
        {
            case 0:
                dogBreed = "Poodle";
                break;

            case 1:
                dogBreed = "Corgi";
                break;

            case 2:
                dogBreed = "labrador";
                break;

            case 3:
                dogBreed = "Husky";
                break;
        }

        randomText.setText("You have a " + dogBreed);
    }
}
