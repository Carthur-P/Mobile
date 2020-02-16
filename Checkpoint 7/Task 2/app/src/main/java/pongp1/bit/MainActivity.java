package pongp1.bit;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
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
        Button changeColour = (Button) findViewById(R.id.button1);
        changeColour.setOnClickListener(new OnButtonClickHandler());
    }

    public class OnButtonClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startActivityForResult(new Intent(MainActivity.this, MainActivity2.class), 0);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        TextView message = (TextView) findViewById(R.id.textView2);
        Resources resourceResolver = getResources();
        if((requestCode == 0) && (resultCode == Activity.RESULT_OK))
        {
            message.setTextColor(resourceResolver.getColor(data.getIntExtra("textColour", 0)));
        }

        else {
            message.setTextColor(Color.BLACK);
        }
    }
}
