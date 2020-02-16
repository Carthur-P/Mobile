package pongp1.bit;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button changeImage = findViewById(R.id.button1);
        changeImage.setOnClickListener(new OnClickHandler());
    }

    public void getImage(int imageID) {
        Resources resourceResolver = getResources();
        LinearLayout screen = (LinearLayout)findViewById(R.id.mainScreen);
        screen.setBackground(resourceResolver.getDrawable(imageID));
    }

    public class OnClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            ListNavFragment navWindow = new ListNavFragment();
            navWindow.show(fm, "listNav");
        }
    }
}
