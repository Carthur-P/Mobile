package pongp1.bit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public class ShortClick implements View.OnClickListener
    {
        @Override
        public void onClick (View v)
        {
            Toast.makeText(MainActivity.this, "Short Click", Toast.LENGTH_SHORT).show();
        }
    }

    public class LongClick implements View.OnLongClickListener
    {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(MainActivity.this, "Long Click", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public class KeyPress implements View.OnKeyListener
    {
        EditText nameText = (EditText) findViewById(R.id.editText1);

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_AT))
            {
                Toast.makeText(MainActivity.this, "Dont enter an @ sign", Toast.LENGTH_SHORT).show();
                return true;
            }

            if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
            {
                if(nameText.getText().length() < 8)
                {
                    Toast.makeText(MainActivity.this, "The username " + nameText.getText() + " is too short", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(MainActivity.this, "Thank you, your username is " + nameText.getText(), Toast.LENGTH_SHORT).show();
                }

                return true;
            }

            else
            {
                return false;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button messageButton = (Button) findViewById(R.id.button1);
        messageButton.setOnClickListener(new ShortClick());
        messageButton.setOnLongClickListener(new LongClick());

        EditText nameText = (EditText) findViewById(R.id.editText1);
        nameText.setOnKeyListener(new KeyPress());
    }
}
