package pongp1.bit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView nav = findViewById(R.id.listView1);
        String[] navItems = {"Terrier", "Sporting", "Working", "Hound"};
        nav.setAdapter(new ArrayAdapter<String>(this, R.layout.listview_layout2, R.id.textView1, navItems));
        nav.setOnItemClickListener(new OnNavItemClickHandler());
    }

    public class OnNavItemClickHandler implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String clickedItem = parent.getItemAtPosition(position).toString();

            switch(clickedItem){
                case "Terrier":
                   startActivity(new Intent(MainActivity.this, MainActivity2.class));
                   break;
            }
        }
    }
}
