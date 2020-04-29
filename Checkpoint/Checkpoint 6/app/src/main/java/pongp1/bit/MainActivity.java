package pongp1.bit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    public class listViewOnClickHandler implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String clickedItem = parent.getItemAtPosition(position).toString();

            switch (clickedItem) {
                case "Services":
                    startActivity(new Intent(MainActivity.this, Services.class));
                    break;

                case "Fun Things To Do":
                    startActivity(new Intent(MainActivity.this, ThingsToDo.class));
                    break;

                case "Dinning":
                    startActivity(new Intent(MainActivity.this, Dinning.class));
                    break;

                case "Shopping":
                    startActivity(new Intent(MainActivity.this, Shopping.class));
                    break;
            }
        }
    }

    public ArrayAdapter<String> listItems() {
        String[] navItems = {"Services", "Fun Things To Do", "Dinning", "Shopping"};
        ArrayAdapter<String> navItemsAdapter = new ArrayAdapter<String>(this, R.layout.listview_layout, R.id.listViewText, navItems);
        return navItemsAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView navbar = (ListView) findViewById(R.id.listView1);
        navbar.setAdapter(listItems());
        navbar.setOnItemClickListener(new listViewOnClickHandler());
    }

}
