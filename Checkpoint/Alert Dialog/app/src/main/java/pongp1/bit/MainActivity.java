package pongp1.bit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alert;
    ImageView image;
    Resources resourceResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resourceResolver = getResources();
        Button confirm = findViewById(R.id.button1);
        image = findViewById(R.id.imageView1);
        confirm.setOnClickListener(new OnClickHandler());
    }

    public class OnClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Do you wish to confirm your order");
            alert.setPositiveButton("Yes", new OnPositiveClickHandler());
            alert.setNegativeButton("No", new OnNegativeClickHandler());
            alert.create();
            alert.show();
        }
    }

    public class OnPositiveClickHandler implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            image.setVisibility(View.VISIBLE);
            image.setImageDrawable(resourceResolver.getDrawable(R.drawable.confirm));
        }
    }

    public class OnNegativeClickHandler implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            image.setVisibility(View.VISIBLE);
            image.setImageDrawable(resourceResolver.getDrawable(R.drawable.cancel));
        }
    }
}
