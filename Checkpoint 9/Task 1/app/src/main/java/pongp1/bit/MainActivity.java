package pongp1.bit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button showImageFragment = (Button) findViewById(R.id.button1);
        Button showListFragment = (Button) findViewById(R.id.button2);
        showImageFragment.setOnClickListener(new OnImageButtonClickHandler());
        showListFragment.setOnClickListener(new OnListButtonClickHandler());
    }

    public class OnImageButtonClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentContainer, new ImageFragment());
            ft.commit();
        }
    }

    public class OnListButtonClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentContainer, new ListFragment());
            ft.commit();
        }
    }
}
