package pongp1.bit;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected AssetManager am;
    protected ArrayList<String> titleArray;
    protected  ArrayList<String> descriptionArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleArray = new ArrayList<>();
        descriptionArray = new ArrayList<>();
        am = getAssets();
        try {
            InputStream is = am.open("dunedin_events_2017.txt");
            int fileSize = is.available();
            byte[] JSONBuffer = new byte[fileSize];
            is.read(JSONBuffer);
            is.close();

            String JSONInput = new String(JSONBuffer);

            try{
                JSONObject data = new JSONObject(JSONInput);
                JSONObject events = data.getJSONObject("events");
                JSONArray eventArray = events.getJSONArray("event");
                for(int i = 0; i < eventArray.length(); i++){
                    JSONObject event = eventArray.getJSONObject(i);
                    titleArray.add(event.getString("title"));
                    descriptionArray.add(event.getString("description"));
                }
            }

            catch(JSONException e){
                Log.i("JSON error: ", e.getMessage());
            }
        }

        catch(IOException e) {
            Log.i("IOFile error: ", e.getMessage());
        }

        ListView eventTitleList = findViewById(R.id.listView1);
        eventTitleList.setAdapter(new ArrayAdapter<String>(this, R.layout.listview_layout, R.id.listTextView1, titleArray));
        eventTitleList.setOnItemClickListener(new OnItemClickHandler());
    }

    public class OnItemClickHandler implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, descriptionArray.get(position), Toast.LENGTH_LONG).show();
        }
    }
}
